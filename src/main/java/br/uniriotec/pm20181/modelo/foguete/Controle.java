package br.uniriotec.pm20181.modelo.foguete;

import br.uniriotec.pm20181.modelo.plano.Acao;
import br.uniriotec.pm20181.servico.ServicoMotores;
import br.uniriotec.pm20181.util.XmlUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe referente ao componente de controle
 */
public class Controle extends Componente {

    public Controle() {
        super(TiposComponente.COMPONENTE_CONTROLE);
    }


    @Override
    protected Componente clone() {
        return null;
    }

    @Override
    void acaoDisparo() {

    }

    @Override
    boolean fromXml(XmlUtils xmlUtils, ServicoMotores servicoMotores) {
        return false;
    }
}
