package br.uniriotec.pm20181.model;

import lombok.Getter;
import lombok.Setter;

public class ComponenteMotor extends Componente {

    public ComponenteMotor() {
        super(TiposComponente.COMPONENTE_MOTOR);
    }

    @Getter @Setter private String motor;
    @Getter @Setter private String fabricante;

    @Override
    double getMassa() {
        return 0;
    }

    @Override
    protected Componente clone() {
        return null;
    }
}
