package br.uniriotec.pm20181.modelo.foguete;

import br.uniriotec.pm20181.servico.ServicoMotores;
import br.uniriotec.pm20181.util.XmlUtils;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Element;

public class Motor extends Componente {

    public Motor() {
        super(TiposComponente.COMPONENTE_MOTOR);
    }

    public Motor(Element xml) {
        super(TiposComponente.COMPONENTE_MOTOR);
        fromXml(xml);
    }

    private @Getter @Setter Long id;
    private @Getter @Setter String motor;
    private @Getter @Setter String fabricante;
    private @Getter @Setter Double pesoTotal;
    private @Getter @Setter Double pesoCombustivel;
    private @Getter @Setter Double tempoImpulso;

    @Override
    Double getMassa() {
        return super.getMassa() + pesoTotal;
    }

    public void adicionaImpulso(double a, double b) {

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

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
