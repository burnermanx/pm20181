package br.uniriotec.pm20181.model;

public class ComponenteMotor extends Componente {

    public ComponenteMotor() {
        super(TiposComponente.COMPONENTE_MOTOR);
    }

    @Override
    double getMassa() {
        return 0;
    }

    @Override
    protected Componente clone() {
        return null;
    }
}
