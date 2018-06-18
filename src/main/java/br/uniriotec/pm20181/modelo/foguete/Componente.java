package br.uniriotec.pm20181.modelo.foguete;

import br.uniriotec.pm20181.util.AreaUtil;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.*;

public abstract class Componente {
    @Getter @Setter private String tipo;
    @Getter @Setter private String nome;
    @Getter @Setter private double peso;
    @Getter @Setter private double diametro;
    @Getter @Setter private boolean ativado;
    private Map<Direcao, Componente> componentes = new HashMap<>();

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

    abstract double getMassa();

    double getArea() {
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

    void processaComando(Comandos comando) {

    }


    /*
    void adicionaForcas(sistemaForcas, foguete, intervaloTempo) {

    }



    abstract boolean fromXml(xmlComponente, servicoMotores);
        */
}
