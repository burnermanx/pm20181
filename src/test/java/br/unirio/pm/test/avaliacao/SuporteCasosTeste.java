package br.unirio.pm.test.avaliacao;

import br.uniriotec.pm20181.controle.HistoricoSimulador;
import br.uniriotec.pm20181.controle.Simulador;

import static org.junit.Assert.assertEquals;



public class SuporteCasosTeste
{
	public static void confereHistorico(Simulador simulador, int indice, String tempo, String altitude, String aceleracao, String velocidade, String massa, String area)
	{
		HistoricoSimulador historico = simulador.pegaHistoricoIndice(indice);
		assertEquals(historico.getTempo(), tempo);
		assertEquals(historico.pegaValor("altitude"), altitude);
		assertEquals(historico.pegaValor("aceleracao"), aceleracao);
		assertEquals(historico.pegaValor("velocidade"), velocidade);
		assertEquals(historico.pegaValor("massa"), massa);
		assertEquals(historico.pegaValor("area"), area);
	}
}