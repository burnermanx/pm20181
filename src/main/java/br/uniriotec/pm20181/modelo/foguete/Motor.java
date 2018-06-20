package br.uniriotec.pm20181.modelo.foguete;

import br.uniriotec.pm20181.servico.ServicoMotores;
import br.uniriotec.pm20181.util.XmlUtils;
import lombok.Getter;
import lombok.Setter;

public class Motor extends Componente {

    public Motor() {
        super(TiposComponente.COMPONENTE_MOTOR);
    }

    private @Getter @Setter String motor;
    private @Getter @Setter String fabricante;
    private @Getter @Setter Double pesoTotal;
    private @Getter @Setter Double pesoCombustivel;
    private @Getter @Setter Double tempoImpulso;

    @Override
    Double getMassa() {
        return super.getMassa() + pesoCombustivel + pesoTotal;
    }

    public void adicionaImpulso(double a, double b) {

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
