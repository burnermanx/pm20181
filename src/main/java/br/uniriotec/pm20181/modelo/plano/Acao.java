package br.uniriotec.pm20181.modelo.plano;

import lombok.Getter;
import lombok.Setter;

public class Acao {
    @Getter @Setter private String tipo;
    @Getter @Setter private Double tempo;
    @Getter @Setter private String nome;

    public Acao(String tipo, Double tempo, String nome) {
        this.tipo = tipo;
        this.tempo = tempo;
        this.nome = nome;
    }
}
//externalizar o calculo de area do foguete
//