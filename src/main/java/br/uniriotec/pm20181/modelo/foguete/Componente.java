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

public abstract class Componente {
    @Getter @Setter private String tipo;
    @Getter @Setter private String nome;
    @Getter @Setter protected Double peso;
    @Getter @Setter private Double diametro;
    @Getter @Setter protected Boolean ativado;
    protected Map<Direcao, Componente> componentes = new HashMap<>();

    public Componente(String tipo) {
        this.tipo = tipo;
    }

    void adicionaComponenteConectado(Direcao direcao, Componente componente) {
        componentes.put(direcao, componente);
    }

    Componente pegaComponenteConectado(Direcao direcao) {
        return componentes.get(direcao);
    }

    Componente pegaComponenteNome(@NonNull String nome) {
        if (nome.contentEquals(this.nome)) {
            return this;
        }

        List<Componente> componentesDisponiveis = new ArrayList<>(componentes.values());

        for (Componente componente : componentesDisponiveis) {
            Componente componenteEncontrado = null;
            componenteEncontrado = componente.pegaComponenteNome(nome);
            if (componenteEncontrado != null) {
                return componenteEncontrado;
            }
        }

        return null;
    }

    Double getMassa() {
        double pesoTotal = this.peso;

        //Se não tenho componentes anexados ao componente, retorne o peso do próprio
        if (componentes.isEmpty()) {
            return pesoTotal;
        }

        List<Componente> componentesConectados = new ArrayList<>();
        componentes.forEach((direcao, componente) -> componentesConectados.add(componente));

        for (Componente componente : componentesConectados) {
            pesoTotal = pesoTotal + componente.getMassa();
        }

        return pesoTotal;
    }

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

    void processaComando(Acao acao) {

    }

    void adicionaForcas(Ambiente ambiente, Foguete foguete, int intervaloTempo) {

    }

    abstract boolean fromXml(XmlUtils xmlUtils, ServicoMotores servicoMotores);
}
