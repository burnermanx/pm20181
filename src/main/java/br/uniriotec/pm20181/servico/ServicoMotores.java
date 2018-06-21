package br.uniriotec.pm20181.servico;

import br.uniriotec.pm20181.modelo.foguete.Motor;
import br.uniriotec.pm20181.modelo.webservice.SearchResponse;

/**
 * Abstração do serviço de motores
 */
public interface ServicoMotores {
    /**
     * Retorna um objeto de Motor, dado fabricante e modelo.
     */
    public Motor pegaMotor(String fabricante, String modelo);

    /**
     * Carrega a curva de impulso do motor
     */
    public boolean carregaImpulso(Motor motor);
}
