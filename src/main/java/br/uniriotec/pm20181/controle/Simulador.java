package br.uniriotec.pm20181.controle;

        import br.uniriotec.pm20181.modelo.ambiente.Ambiente;
        import br.uniriotec.pm20181.modelo.foguete.Foguete;
        import br.uniriotec.pm20181.modelo.plano.PlanoVoo;
        import lombok.Getter;

        import java.util.ArrayList;
        import java.util.List;

public class Simulador {
    private List<HistoricoSimulador> listaHistorico = new ArrayList<>();

    @Getter
    final private Ambiente ambiente;

    public Simulador(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public void executa(Foguete foguete, PlanoVoo planoVoo, int tempoVoo) {

    }

    public HistoricoSimulador pegaHistoricoIndice(int indice) {
        return listaHistorico.get(indice);
    }
}