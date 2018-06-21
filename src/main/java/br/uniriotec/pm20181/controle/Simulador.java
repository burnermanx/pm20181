package br.uniriotec.pm20181.controle;

import br.uniriotec.pm20181.modelo.ambiente.Ambiente;
        import br.uniriotec.pm20181.modelo.foguete.Foguete;
        import br.uniriotec.pm20181.modelo.plano.PlanoVoo;
        import lombok.Getter;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Classe responsável pela simulação de voo
 */
public class Simulador {
    private List<HistoricoSimulador> listaHistorico = new ArrayList<>();

    @Getter
    final private Ambiente ambiente;

    public Simulador(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    /**
     * Executa uma simulação de voo
     */
    public void executa(Foguete foguete, PlanoVoo planoVoo, int tempoVoo) {

    }

    /**
     * Retorna um item do histórico do voo, dado o indice
     */
    public HistoricoSimulador pegaHistoricoIndice(int indice) {
        return listaHistorico.get(indice);
    }
}