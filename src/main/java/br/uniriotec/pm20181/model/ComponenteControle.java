package br.uniriotec.pm20181.model;

public class ComponenteControle extends Componente {

    public ComponenteControle() {
        super(TiposComponente.COMPONENTE_CONTROLE);
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
