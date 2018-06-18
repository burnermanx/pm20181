package br.uniriotec.pm20181.modelo.foguete;

public class Controle extends Componente {

    public Controle() {
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
