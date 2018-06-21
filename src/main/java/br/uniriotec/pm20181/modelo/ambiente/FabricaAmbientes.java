package br.uniriotec.pm20181.modelo.ambiente;

public class FabricaAmbientes {
    private static FabricaAmbientes instance;

    public static FabricaAmbientes getInstance() {
        if (instance == null) {
            instance = new FabricaAmbientes();
        }

        return instance;
    }

    public Ambiente getTerra() {
        return new Terra();
    }

    public Ambiente getLua() {
        return new Lua();
    }

    public Ambiente getMarte() {
        return new Marte();
    }
}
