package br.uniriotec.pm20181.modelo.foguete;

import br.uniriotec.pm20181.modelo.plano.Acao;
import br.uniriotec.pm20181.servico.ServicoMotores;
import br.uniriotec.pm20181.util.XmlUtils;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe referente ao componente de controle
 */
public class Controle extends Componente {

    public Controle() {
        super(TiposComponente.COMPONENTE_CONTROLE);
    }

    public Controle(Element xmlElement) {
        super(TiposComponente.COMPONENTE_CONTROLE);
        fromXml(xmlElement);
    }


    @Override
    protected Componente clone() {
        return null;
    }

    @Override
    void acaoDisparo() {

    }

    @Override
    public boolean fromXml(Element xmlElement) {
        try {
            this.setNome(XmlUtils.getStringAttribute(xmlElement, "nome"));
            this.setPeso(XmlUtils.getDoubleNode(xmlElement, "peso"));
            this.setDiametro(XmlUtils.getDoubleNode(xmlElement, "diametro"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


}
