package br.uniriotec.pm20181.modelo.foguete;

import br.uniriotec.pm20181.servico.ServicoMotores;
import br.uniriotec.pm20181.util.XmlUtils;
import lombok.Getter;
import lombok.Setter;

public class Motor extends Componente {

    public Motor() {
        super(TiposComponente.COMPONENTE_MOTOR);
    }

    @Getter @Setter private String motor;
    @Getter @Setter private String fabricante;
    @Getter @Setter private double pesoCombustivel;
    @Getter @Setter private double tempoImpulso;

    @Override
    double getMassa() {
        return super.getMassa() + pesoCombustivel;
    }

    @Override
    protected Componente clone() {
        return null;
    }

    @Override
    boolean fromXml(XmlUtils xmlUtils, ServicoMotores servicoMotores) {
        return false;
    }
}
