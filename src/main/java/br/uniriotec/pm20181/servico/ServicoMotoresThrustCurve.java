package br.uniriotec.pm20181.servico;

import br.uniriotec.pm20181.modelo.webservice.SearchRequest;
import br.uniriotec.pm20181.modelo.webservice.SearchResponse;
import okhttp3.*;

import java.io.IOException;

public class ServicoMotoresThrustCurve implements ServicoMotores {

    private OkHttpClient httpClient = new OkHttpClient.Builder()
            .build();

    @Override
    public void pegarDadosMotor(String fabricante, String modelo, CallbackServico callback) {
        SearchRequest searchRequest = new SearchRequest.Builder()
                .withCommonName(modelo)
                .withManufacturer(fabricante)
                .build();

        RequestBody requestBody = RequestBody.create(MediaType.parse("text/xml;charset=ISO-8859-1"), searchRequest.toXml());

        Request request = new Request.Builder()
                .url("http://www.thrustcurve.org/servlets/search")
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
