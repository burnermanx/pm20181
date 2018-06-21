package br.uniriotec.pm20181.modelo.ambiente;

import lombok.Getter;

/**
 * Abstração de um ambiente com força gravitacional
 */
public abstract class Ambiente {
    public Ambiente(double gravidade) {
        this.gravidade = gravidade;
    }

    @Getter
    protected double gravidade;
}
