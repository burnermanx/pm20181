package br.uniriotec.pm20181.modelo.foguete;

import br.uniriotec.pm20181.modelo.ambiente.Ambiente;
import br.uniriotec.pm20181.modelo.plano.Acao;
import br.uniriotec.pm20181.servico.ServicoMotores;
import br.uniriotec.pm20181.util.AreaUtil;
import br.uniriotec.pm20181.util.XmlUtils;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.*;

/**
 * Classe abstrata referente a um componente que constitui um foguete
 */
public abstract class Componente {
    @Getter
    @Setter
    private String tipo;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private Double peso;
    @Getter
    @Setter
    private Double diametro;
    @Getter
    @Setter
    private Boolean ativado;
    @Getter
    private final Map<Direcao, Componente> componentes = new HashMap<>();


    /**
     * O cosntrutor rece o tipo do componente
     *
     * @param tipo tipo do componente
     */
    Componente(String tipo) {
        setTipo(tipo);
    }


    /**
     * Anexa um componente ao próprio na direção especificada
     *
     * @param direcao    direção onde o componente será encaixado
     * @param componente objeto Componente a ser encaixado
     */
    public void adicionaComponenteConectado(Direcao direcao, Componente componente) {
        getComponentes().put(direcao, componente);
    }


    /**
     * Busca um componente dada a sua direção
     *
     * @param direcao direcao de onde o Componente tem de ser pego
     * @return retorna um objeto Componente ou nulo se o componente não for encontrado
     */
    Componente pegaComponenteConectado(Direcao direcao) {
        return getComponentes().get(direcao);
    }


    /**
     * Busca um componente dado seu nome
     *
     * @param nome nome do componente
     * @return retorna um objeto Componente ou nulo se o componente não for encontrado
     */
    public Componente pegaComponenteNome(@NonNull String nome) {
        //Se o nome do componente sendo pesquisado já for do próprio, retorne
        if (nome.contentEquals(this.getNome())) {
            return this;
        }

        for (Componente componente : getComponentes().values()) {
            Componente componenteEncontrado;
            componenteEncontrado = componente.pegaComponenteNome(nome);
            if (componenteEncontrado != null) {
                return componenteEncontrado;
            }
        }
        //Caso nenhum componente tenha sido encontrado, retorna nulo
        return null;
    }


    Double getMassa() {
        double pesoTotal = this.getPeso();

        //Se não tem componentes anexados ao componente, retorne o peso do próprio
        if (getComponentes().isEmpty()) {
            return pesoTotal;
        }

        for (Componente componente : getComponentes().values()) {
            pesoTotal = pesoTotal + componente.getMassa();
        }

        return pesoTotal;
    }

    /**
     * Calcular a área do foguete vista por cima, dado o componente.
     *
     * @return a maior área possível do foguete visto por cima
     */
    Double getArea() {
        double areaRedor = AreaUtil.areaCirculo(this.getDiametro());

        //Se não tenho componentes ao redor do componente, retorne a área do próprio.
        if (getComponentes().isEmpty()) {
            return areaRedor;
        }

        double areaAbaixo = 0.0;
        List<Componente> componentesAoRedor = new ArrayList<>();
        getComponentes().forEach(((direcao, componente) -> {
            if (direcao != Direcao.ABAIXO) {
                componentesAoRedor.add(componente);
            }
        }));

        for (Componente componente : componentesAoRedor) {
            areaRedor = areaRedor + AreaUtil.areaCirculo(componente.getDiametro());
        }

        Componente componenteAbaixo = getComponentes().get(Direcao.ABAIXO);
        if (componenteAbaixo != null) {
            areaAbaixo = componenteAbaixo.getArea();
        }

        if (areaAbaixo > areaRedor) {
            return areaAbaixo;
        } else {
            return areaRedor;
        }
    }

    protected abstract Componente clone();

    /**
     * Método responsável para execução de ações
     *
     * @param acao Objeto Acao referente a ação a ser executada
     */
    protected void processaComando(Acao acao) {
        if (acao.getTipo() == Acao.Tipo.DESCONEXAO) {
            removeComponente(acao.getNome());
        }

        if (acao.getTipo() == Acao.Tipo.DISPARO) {
            acaoDisparo();
        }
    }

    /**
     * Método responsável por remover um componente, caso seja encontrado
     *
     * @param nome nome do componente
     */
    private void removeComponente(@NonNull String nome) {
        for (Direcao direcao : getComponentes().keySet()) {
            Componente componente = pegaComponenteConectado(direcao);

            if (componente.getNome().contentEquals(nome)) {
                getComponentes().remove(direcao);
                break;
            } else {
                componente.removeComponente(nome);
            }
        }
    }

    abstract void acaoDisparo();

    /**
     * Adiciona forças de acordo com o ambiente
     *
     * @param ambiente       ambiente
     * @param foguete        foguete
     * @param intervaloTempo intervalo de tempo
     */
    void adicionaForcas(Ambiente ambiente, Foguete foguete, int intervaloTempo) {

    }

    /**
     * Criar instancia do Componente vindo de um arquivo XML
     *
     * @param xmlUtils
     * @param servicoMotores
     * @return
     */
    abstract boolean fromXml(XmlUtils xmlUtils, ServicoMotores servicoMotores);
}
