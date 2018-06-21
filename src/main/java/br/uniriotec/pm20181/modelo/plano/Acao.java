package br.uniriotec.pm20181.modelo.plano;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa uma ação do plano de voo
 */
public class Acao {

    /**
     * Tipos de ação
     */
    public enum Tipo {
        DISPARO, DESCONEXAO;

        /**
         * Pegar nome da ação
         * @return nome da ação em letras minusculas
         */
        public String getName() {
            return this.name().toLowerCase();
        }
    }

    @Getter @Setter private Tipo tipo;
    @Getter @Setter private Double tempo;
    @Getter @Setter private String nome;

    /**
     * Construtor padrão para ação
     * @param tipo tipo da ação
     * @param tempo tempo de execução
     * @param nome nome do componente
     */
    public Acao(Tipo tipo, Double tempo, String nome) {
        this.tipo = tipo;
        this.tempo = tempo;
        this.nome = nome;
    }
}