package br.uniriotec.pm20181.model;

public class ComponenteParaquedas extends Componente {

    public ComponenteParaquedas() {
        super(TiposComponente.COMPONENTE_PARAQUEDAS);
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
