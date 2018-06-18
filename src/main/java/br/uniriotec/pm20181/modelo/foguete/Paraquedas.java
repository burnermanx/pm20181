package br.uniriotec.pm20181.modelo.foguete;

import lombok.Getter;
import lombok.Setter;

public class Paraquedas extends Componente {

    public Paraquedas() {
        super(TiposComponente.COMPONENTE_PARAQUEDAS);
    }

    @Getter @Setter private double cd;

    @Override
    double getMassa() {
        return 0;
    }

    @Override
    protected Componente clone() {
        return null;
    }
}
