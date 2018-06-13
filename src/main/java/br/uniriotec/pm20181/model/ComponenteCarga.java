package br.uniriotec.pm20181.model;

import lombok.Getter;
import lombok.Setter;

public class ComponenteCarga extends Componente {

    public ComponenteCarga() {
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
