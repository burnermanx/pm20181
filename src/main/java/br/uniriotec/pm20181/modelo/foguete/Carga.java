package br.uniriotec.pm20181.modelo.foguete;

import lombok.Getter;
import lombok.Setter;

public class Carga extends Componente {

    public Carga() {
        super(TiposComponente.COMPONENTE_CARGA);
    }

    @Getter @Setter
    private double pesoCarga;

    @Override
    double getMassa() {
        return 0;
    }

    @Override
    protected Componente clone() {
        return null;
    }
}
