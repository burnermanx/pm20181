package br.uniriotec.pm20181.servico;

import br.uniriotec.pm20181.modelo.foguete.Foguete;
import br.uniriotec.pm20181.modelo.plano.Acao;
import br.uniriotec.pm20181.modelo.plano.PlanoVoo;
import br.uniriotec.pm20181.util.XmlUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

import static br.uniriotec.pm20181.modelo.plano.Acao.Tipo.DESCONEXAO;
import static br.uniriotec.pm20181.modelo.plano.Acao.Tipo.DISPARO;

/**
 * Classe responsavel por fazer a carga do XML de plano de voo
 */
public class CarregadorPlanoVoo {

    /**
     * Cria uma instancia de PlanoVoo dado a localização do arquivo XML
     * @param xml localização do XML de plano de voo
     * @param foguete Foguete o qual receberá o plano de voo
     * @return Objeto de Plano de voo
     */
    public PlanoVoo carrega(String xml, Foguete foguete) {
        Element root = XmlUtils.getRootElementFromXmlFile(xml);
        if (root != null) {
            PlanoVoo planoVoo = new PlanoVoo();
            List<Element> elementList = XmlUtils.getElements(root, "acao");

            for (Element element : elementList) {
                String nome = element.getAttribute("nome");
                String tempo = element.getAttribute("tempo");
                String tipo = element.getAttribute("tipo");

                Acao acao = new Acao(getTipo(tipo), Double.parseDouble(tempo), nome);
                planoVoo.addAcao(acao);
            }

            foguete.setPlanoVoo(planoVoo);
            return planoVoo;
        }

        return null;
    }

    /**
     * Converte o string de tipo de comando para um enum de comando
     * @param tipo tipo de comando em string
     * @return tipo de comando em enum Tipo
     */
    private Acao.Tipo getTipo(String tipo) {
        if (tipo.contentEquals(DISPARO.getName())) {
            return DISPARO;
        }

        if (tipo.contentEquals(DESCONEXAO.getName())) {
            return DESCONEXAO;
        }

        return null;
    }
}
