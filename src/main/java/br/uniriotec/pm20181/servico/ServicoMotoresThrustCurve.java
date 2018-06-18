package br.uniriotec.pm20181.servico;

import br.uniriotec.pm20181.modelo.webservice.SearchRequest;
import br.uniriotec.pm20181.modelo.webservice.SearchResponse;
import okhttp3.*;

import java.io.IOException;

public class ServicoMotoresThrustCurve implements ServicoMotores {

    private static final String SERVICE_URL = "http://www.thrustcurve.org/servlets/search";
    private static final String MEDIA_XML = "text/xml;charset=ISO-8859-1";

    private OkHttpClient httpClient = new OkHttpClient.Builder()
            .build();

    @Override
    public void pegarDadosMotor(String fabricante, String modelo, CallbackServico callback) {
        SearchRequest searchRequest = new SearchRequest.Builder()
                .withCommonName(modelo)
                .withManufacturer(fabricante)
                .build();

        RequestBody requestBody = RequestBody.create(MediaType.parse(MEDIA_XML), searchRequest.toXml());

        Request request = new Request.Builder()
                .url(SERVICE_URL)
                .post(requestBody)
                .build();

        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.onRequestFinished(false, null);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                SearchResponse searchResponse = response.body() != null ?
                        SearchResponse.fromXml(response.body().string()) : null;

                callback.onRequestFinished(searchResponse != null, searchResponse);
            }
        });
    }
}
