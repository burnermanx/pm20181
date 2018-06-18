package br.uniriotec.pm20181.modelo.foguete;

import br.uniriotec.pm20181.servico.ServicoMotores;
import br.uniriotec.pm20181.util.XmlUtils;

import java.util.List;

public class Controle extends Componente {

    public Controle() {
        super(TiposComponente.COMPONENTE_CONTROLE);
    }

    @Override
    double getMassa() {
        double pesoTotal = this.peso;


        //Se não tiver componentes logo abaixo, retornar o próprio peso
        if (pegaComponenteConectado(Direcao.ABAIXO) == null) {
            return pesoTotal;
        }



        return this.peso;
    }

    @Override
    protected Componente clone() {
        return null;
    }

    @Override
    boolean fromXml(XmlUtils xmlUtils, ServicoMotores servicoMotores) {
        return false;
    }
}
