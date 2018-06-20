package br.uniriotec.pm20181.modelo.foguete;

import br.uniriotec.pm20181.servico.ServicoMotores;
import br.uniriotec.pm20181.util.XmlUtils;
import lombok.Getter;
import lombok.Setter;

public class Carga extends Componente {

    public Carga() {
        super(TiposComponente.COMPONENTE_CARGA);
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
    boolean fromXml(XmlUtils xmlUtils, ServicoMotores servicoMotores) {
        return false;
    }
}
