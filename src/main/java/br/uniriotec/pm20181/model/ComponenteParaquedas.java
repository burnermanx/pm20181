package br.uniriotec.pm20181.model;

import lombok.Getter;
import lombok.Setter;

public class ComponenteParaquedas extends Componente {

    public ComponenteParaquedas() {
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
