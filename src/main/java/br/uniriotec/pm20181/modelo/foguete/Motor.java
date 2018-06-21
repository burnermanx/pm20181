package br.uniriotec.pm20181.modelo.foguete;

import br.uniriotec.pm20181.servico.ServicoMotores;
import br.uniriotec.pm20181.util.XmlUtils;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa o componente de Motor
 */
public class Motor extends Componente {

    public Motor() {
        super(TiposComponente.COMPONENTE_MOTOR);
    }

    public Motor(Element xml) {
        super(TiposComponente.COMPONENTE_MOTOR);
        fromXml(xml);
    }

    @Getter @Setter private Long id;
    @Getter @Setter private String motor;
    @Getter @Setter private String fabricante;
    @Getter @Setter private Double pesoTotal;
    @Getter @Setter private Double pesoCombustivel;
    @Getter @Setter private Double tempoImpulso;
    @Getter final private List<Impulso> listaImpulso = new ArrayList<>();


    @Override
    Double getMassa() {
        return super.getMassa() + pesoTotal;
    }

    /**
     * Adiciona um impulso ao motor
     */
    public void adicionaImpulso(double f, double m) {
        listaImpulso.add(new Impulso(f, m));
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

    /**
     * Classe boxing para impulso
     */
    static class Impulso {
        Impulso(double f, double m) {
            this.f = f;
            this.m = m;
        }

        double f;
        double m;
    }
}
