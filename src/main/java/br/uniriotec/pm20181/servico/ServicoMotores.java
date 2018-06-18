package br.uniriotec.pm20181.servico;

import br.uniriotec.pm20181.modelo.foguete.Motor;
import br.uniriotec.pm20181.modelo.webservice.SearchResponse;

public interface ServicoMotores {
    public Motor pegaMotor(String fabricante, String modelo);

    public boolean carregaImpulso(Motor motor);
}
