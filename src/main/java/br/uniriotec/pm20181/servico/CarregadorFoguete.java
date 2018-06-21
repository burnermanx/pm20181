package br.uniriotec.pm20181.servico;

import br.uniriotec.pm20181.modelo.foguete.Foguete;

/**
 * Classe auxiliar para leitura do XML do Foguete
 */
public class CarregadorFoguete {


    /**
     * Método responsável pelo carregamento do XML que define a construção do foguete
     * @param xml String do XML do foguete
     * @param servicoMotores Serviço de motores para a consulta de dados adicionais sobre o Motor
     * @return instância do Foguete
     */
    public Foguete carrega(String xml, ServicoMotores servicoMotores) {
        Foguete foguete = new Foguete();


        return foguete;
    }
}
