package br.uniriotec.pm20181.modelo.ambiente;

import lombok.Getter;

public abstract class Ambiente {
    public Ambiente(double gravidade) {
        this.gravidade = gravidade;
    }

    @Getter
    protected double gravidade;
}
