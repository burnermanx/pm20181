package br.uniriotec.pm20181.modelo.foguete;

import lombok.Getter;
import lombok.Setter;

public class Motor extends Componente {

    public Motor() {
        super(TiposComponente.COMPONENTE_MOTOR);
    }



    @Getter @Setter private String motor;
    @Getter @Setter private String fabricante;
    @Getter @Setter private double pesoCombustivel;
    @Getter @Setter private double pesoTotal;
    @Getter @Setter private double tempoImpulso;

    @Override
    double getMassa() {
        return 0;
    }

    @Override
    protected Componente clone() {
        return null;
    }
}
