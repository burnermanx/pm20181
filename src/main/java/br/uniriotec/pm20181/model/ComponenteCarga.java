package br.uniriotec.pm20181.model;

public class ComponenteCarga extends Componente {

    public ComponenteCarga() {
        super(TiposComponente.COMPONENTE_CARGA);
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
