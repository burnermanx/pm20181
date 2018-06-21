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
    @Getter @Setter private String tipo;
    @Getter @Setter private String nome;
    @Getter @Setter protected Double peso;
    @Getter @Setter private Double diametro;
    @Getter @Setter protected Boolean ativado;
    protected Map<Direcao, Componente> componentes = new HashMap<>();


    /**
     * O cosntrutor rece o tipo do componente
     * @param tipo
     */
    public Componente(String tipo) {
        this.tipo = tipo;
    }


    /**
     * Anexa um componente ao próprio na direção especificada
     * @param direcao
     * @param componente
     */
    void adicionaComponenteConectado(Direcao direcao, Componente componente) {
        componentes.put(direcao, componente);
    }


    /**
     * Busca um componente dada a sua direção
     * @param direcao
     *  @return retorna um objeto Componente ou nulo se o componente não for encontrado
     */
    Componente pegaComponenteConectado(Direcao direcao) {
        return componentes.get(direcao);
    }


    /**
     * Busca um componente dado seu nome
     * @param nome
     * @return  retorna um objeto Componente ou nulo se o componente não for encontrado
     */
    Componente pegaComponenteNome(@NonNull String nome) {
        //Se o nome do componente sendo pesquisado já for do próprio, retorne
        if (nome.contentEquals(this.nome)) {
            return this;
        }


        //Criando lista com todos os objetos de componente anexados a sua volta
        List<Componente> componentesDisponiveis = new ArrayList<>(componentes.values());

        for (Componente componente : componentesDisponiveis) {
            Componente componenteEncontrado = null;
            componenteEncontrado = componente.pegaComponenteNome(nome);
            if (componenteEncontrado != null) {
                return componenteEncontrado;
            }
        }
        //Caso nenhum componente tenha sido encontrado, retorna nulo
        return null;
    }


    Double getMassa() {
        double pesoTotal = this.peso;

        //Se não tem componentes anexados ao componente, retorne o peso do próprio
        if (componentes.isEmpty()) {
            return pesoTotal;
        }
        //Criando lista de componentescom todos os objetos de componentes conectados
        List<Componente> componentesConectados = new ArrayList<>();
        componentes.forEach((direcao, componente) -> componentesConectados.add(componente));

        for (Componente componente : componentesConectados) {
            pesoTotal = pesoTotal + componente.getMassa();
        }

        return pesoTotal;
    }

    /**
     * Calcular a área do foguete vista por cima, dado o componente.
     * @return a maior área possível do foguete visto por cima
     */
    Double getArea() {
        double areaRedor = AreaUtil.areaCirculo(this.diametro);

        //Se não tenho componentes ao redor do componente, retorne a área do próprio.
        if (componentes.isEmpty()) {
            return areaRedor;
        }

        double areaAbaixo = 0.0;
        List<Componente> componentesAoRedor = new ArrayList<>();
        componentes.forEach(((direcao, componente) -> {
            if (direcao != Direcao.ABAIXO) {
                componentesAoRedor.add(componente);
            }
        }));

        for (Componente componente : componentesAoRedor) {
            areaRedor = areaRedor + AreaUtil.areaCirculo(componente.diametro);
        }

        Componente componenteAbaixo = componentes.get(Direcao.ABAIXO);
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

    protected void processaComando(Acao acao) {
        if (acao.getTipo().contentEquals("desconexao")) {
            removeComponente();
        }
    }

    private void removeComponente() {

    }

    void adicionaForcas(Ambiente ambiente, Foguete foguete, int intervaloTempo) {

    }

    abstract boolean fromXml(XmlUtils xmlUtils, ServicoMotores servicoMotores);
}
