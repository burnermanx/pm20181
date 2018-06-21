package br.uniriotec.pm20181.modelo.foguete;

import br.uniriotec.pm20181.servico.ServicoMotores;
import br.uniriotec.pm20181.util.XmlUtils;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Element;


/**
 *  Classe responsável pelo componente de carga
 */
public class Carga extends Componente {

    public Carga() {
        super(TiposComponente.COMPONENTE_CARGA);
    }

    public Carga(Element xml) {
        super(TiposComponente.COMPONENTE_CARGA);
        fromXml(xml);
    }

    @Getter @Setter
    private Double pesoCarga;

    @Override
    Double getMassa() {
        return super.getMassa() + pesoCarga;
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
            this.setDiametro(XmlUtils.getDoubleNode(xmlElement, "diametro"));
            this.setPeso(XmlUtils.getDoubleNode(xmlElement, "peso"));
            this.setPesoCarga(XmlUtils.getDoubleNode(xmlElement, "pesoCarga"));

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


}
