package br.uniriotec.pm20181.modelo.foguete;

import br.uniriotec.pm20181.servico.ServicoMotores;
import br.uniriotec.pm20181.util.XmlUtils;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Element;

public class Paraquedas extends Componente {

    public Paraquedas() {
        super(TiposComponente.COMPONENTE_PARAQUEDAS);
    }

    public Paraquedas(Element xmlElement) {
        super(TiposComponente.COMPONENTE_PARAQUEDAS);
        fromXml(xmlElement);
    }

    @Getter @Setter private Double cd;

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
            this.setCd(XmlUtils.getDoubleNode(xmlElement, "cd"));
            this.setDiametro(XmlUtils.getDoubleNode(xmlElement, "diametro"));
            this.setPeso(XmlUtils.getDoubleNode(xmlElement, "peso"));

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}