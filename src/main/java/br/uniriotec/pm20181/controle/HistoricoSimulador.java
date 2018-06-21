package br.uniriotec.pm20181.controle;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe que representa o histórico do simulador
 */
public class HistoricoSimulador {
    static final String KEY_ALTITUDE = "altitude";
    static final String KEY_ACELERACAO = "aceleracao";
    static final String KEY_VELOCIDADE = "velocidade";
    static final String KEY_MASSA = "massa";
    static final String KEY_AREA = "area";

    private int tempo;
    private Map<String, String> valores = new HashMap<>();

    public int getTempo() {
        return this.tempo;
    }

    /**
     * Pega um valor do histórico dado a chave
     */
    public String pegaValor(String chave) {
        return valores.get(chave);
    }

    /**
     * Insere um valor no histórico
     */
    public void insereValor(String chave, String valor) {
        valores.put(chave, valor);
    }
}
