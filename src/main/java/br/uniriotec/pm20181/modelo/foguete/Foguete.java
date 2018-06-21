package br.uniriotec.pm20181.modelo.foguete;

import br.uniriotec.pm20181.modelo.plano.PlanoVoo;
import lombok.Getter;
import lombok.Setter;

public class Foguete {
    @Getter @Setter private Double cd;
    @Getter @Setter private Controle controle;
    @Getter @Setter private Paraquedas paraquedas;
    @Getter @Setter private PlanoVoo planoVoo;

    public double getMassa() {
        double massaPqd = paraquedas != null ? paraquedas.getMassa() : 0.0;
        return controle.getMassa() + massaPqd;
    }

    public double getArea() {
        return controle.getArea();
    }
}
