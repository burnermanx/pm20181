package br.uniriotec.pm20181.servico;

import br.uniriotec.pm20181.modelo.webservice.SearchResponse;

public interface ServicoMotores {
    public void pegarDadosMotor(String fabricante, String modelo, CallbackServico callback);

    public interface CallbackServico {
        void onRequestFinished(boolean isSuccess, SearchResponse response);
    }
}
