package br.uniriotec.pm20181.servico;

import br.uniriotec.pm20181.modelo.foguete.Motor;
import br.uniriotec.pm20181.modelo.webservice.DownloadRequest;
import br.uniriotec.pm20181.modelo.webservice.SearchRequest;
import br.uniriotec.pm20181.modelo.webservice.SearchResponse;
import br.uniriotec.pm20181.util.XmlUtils;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import org.w3c.dom.Element;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ServicoMotoresThrustCurve implements ServicoMotores {

    private static final String SERVICE_URL = "http://www.thrustcurve.org/servlets/";
    private static final String ENPOINT_SEARCH = "search";
    private static final String ENDPOINT_DOWNLOAD = "download";
    private static final String MEDIA_XML = "text/xml;charset=ISO-8859-1";

    final private OkHttpClient httpClient;

    public ServicoMotoresThrustCurve() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(System.out::println);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }

    /**
     * Metodo para pegar os dados adicionais do foguete no ThrustCurve
     * @param fabricante
     * @param modelo
     * @return instancia de Motor com os dados, ou nulo caso o motor não tenha sido encontrado
     */
    @Override
    public Motor pegaMotor(String fabricante, String modelo) {
        SearchRequest searchRequest = new SearchRequest.Builder()
                .withCommonName(modelo)
                .withManufacturer(fabricante)
                .build();

        Request request = createRequest(SERVICE_URL + ENPOINT_SEARCH, searchRequest.toXml());

        try {
            Response response = httpClient.newCall(request).execute();
            SearchResponse searchResponse = response.body() != null ?
                    SearchResponse.fromXml(response.body().string()) : null;

            if (searchResponse != null && searchResponse.getResults() != null
                    && !searchResponse.getResults().isEmpty()) {
                SearchResponse.SearchResult result = searchResponse.getResults().get(0);

                Motor motor = new Motor();
                motor.setId(result.getMotorId());
                motor.setPesoCombustivel(result.getPropWeight());
                motor.setPesoTotal(result.getTotalWeight());
                motor.setTempoImpulso(result.getTotalImpulseNs());
                motor.setFabricante(result.getManufacturer());
                motor.setMotor(result.getCommonName());

                carregaImpulso(motor);

                return motor;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Método responsável por pegar os dados de impulso do motor do ThrustCurve
     * @param motor motor a receber os dados
     * @return true se a operação foi efetuada com sucesso.
     */
    @Override
    public boolean carregaImpulso(Motor motor) {
        try {
            DownloadRequest downloadRequest = new DownloadRequest.Builder()
                    .withMotorId(motor.getId())
                    .build();

            Request request = createRequest(SERVICE_URL + ENDPOINT_DOWNLOAD, downloadRequest.toXml());

            Response response = httpClient.newCall(request).execute();
            if (response != null && response.isSuccessful() && response.body() != null) {
                String responseXml = response.body().string();
                Element root = XmlUtils.getRootElementFromXmlString(responseXml, StandardCharsets.ISO_8859_1.name());
                Element results = XmlUtils.getSingleElement(root, "results");
                Element result = XmlUtils.getSingleElement(results, "result");

                String binData = XmlUtils.getStringNode(result, "data");
                String data = new String(DatatypeConverter.parseBase64Binary(binData));

                Element dataRoot = XmlUtils.getRootElementFromXmlString(data, StandardCharsets.ISO_8859_1.name());
                Element dataEngineList = XmlUtils.getSingleElement(dataRoot, "engine-list");
                Element dataEngine = XmlUtils.getSingleElement(dataEngineList, "engine");
                Element dataEngineData = XmlUtils.getSingleElement(dataEngine, "data");
                List<Element> engData = XmlUtils.getElements(dataEngineData, "eng-data");

                for (Element element : engData) {
                    double f = XmlUtils.getDoubleAttribute(element, "f");
                    double m = XmlUtils.getDoubleAttribute(element, "m");

                    motor.adicionaImpulso(f, m);
                }

                return true;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Criador de objeto de Request para o OkHttp
     */
    private Request createRequest(String url, String body) {
        RequestBody requestBody = RequestBody.create(MediaType.parse(MEDIA_XML), body);

        return new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
    }
}
