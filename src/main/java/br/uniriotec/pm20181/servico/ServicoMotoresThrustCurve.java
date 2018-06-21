package br.uniriotec.pm20181.servico;

import br.uniriotec.pm20181.modelo.foguete.Motor;
import br.uniriotec.pm20181.modelo.webservice.SearchRequest;
import br.uniriotec.pm20181.modelo.webservice.SearchResponse;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;

public class ServicoMotoresThrustCurve implements ServicoMotores {

    private static final String SERVICE_URL = "http://www.thrustcurve.org/servlets/search";
    private static final String MEDIA_XML = "text/xml;charset=ISO-8859-1";

    final private OkHttpClient httpClient;

    public ServicoMotoresThrustCurve() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(System.out::println);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @Override
    public Motor pegaMotor(String fabricante, String modelo) {
        SearchRequest searchRequest = new SearchRequest.Builder()
                .withCommonName(modelo)
                .withManufacturer(fabricante)
                .build();

        RequestBody requestBody = RequestBody.create(MediaType.parse(MEDIA_XML), searchRequest.toXml());

        Request request = new Request.Builder()
                .url(SERVICE_URL)
                .post(requestBody)
                .build();

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

                return motor;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean carregaImpulso(Motor motor) {
        return false;
    }
}
