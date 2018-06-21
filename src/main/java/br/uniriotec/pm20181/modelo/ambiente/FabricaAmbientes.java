package br.uniriotec.pm20181.modelo.ambiente;

/**
 * Classe responsável por criar instancias de ambientes
 */
public class FabricaAmbientes {
    private static FabricaAmbientes instance;

    /**
     * Retorna a instancia da fábrica de ambientes
     */
    public static FabricaAmbientes getInstance() {
        if (instance == null) {
            instance = new FabricaAmbientes();
        }

        return instance;
    }

    /**
     * Retorna o ambiente da Terra
     */
    public Ambiente getTerra() {
        return new Terra();
    }

    /**
     * Retorna o ambiente da Lua
     */
    public Ambiente getLua() {
        return new Lua();
    }

    /**
     * Retorna o ambiente da Marte
     */
    public Ambiente getMarte() {
        return new Marte();
    }
}
