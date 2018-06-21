package br.uniriotec.pm20181.modelo.foguete;

import br.uniriotec.pm20181.modelo.plano.PlanoVoo;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa um Foguete
 */
public class Foguete {
    @Getter @Setter private Double cd;
    @Getter @Setter private Controle controle;
    @Getter @Setter private Paraquedas paraquedas;
    @Getter @Setter private PlanoVoo planoVoo;

    /**
     * Retorna a massa total do foguete
     */
    public double getMassa() {
        double massaPqd = paraquedas != null ? paraquedas.getMassa() : 0.0;
        return controle.getMassa() + massaPqd;
    }
    /**
     * Retorna a área do foguete, visto por cima
     */
    public double getArea() {
        return controle.getArea();
    }
}
