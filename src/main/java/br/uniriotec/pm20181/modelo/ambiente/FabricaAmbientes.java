package br.uniriotec.pm20181.modelo.ambiente;

public class FabricaAmbientes {
    public static FabricaAmbientes instance;

    public static FabricaAmbientes getInstance() {
        if (instance == null) {
            instance = new FabricaAmbientes();
        }

        return instance;
    }

    public Ambiente getTerra() {
        return new Ambiente();
    }

    public Ambiente getLua() {
        return new Ambiente();
    }

    public Ambiente getMarte() {
        return new Ambiente();
    }
}
