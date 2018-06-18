package br.unirio.pm.test.avaliacao;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import br.uniriotec.pm20181.controle.Simulador;
import br.uniriotec.pm20181.modelo.ambiente.Ambiente;
import br.uniriotec.pm20181.modelo.ambiente.FabricaAmbientes;
import br.uniriotec.pm20181.modelo.foguete.Foguete;
import br.uniriotec.pm20181.modelo.foguete.Motor;
import br.uniriotec.pm20181.modelo.plano.PlanoVoo;
import br.uniriotec.pm20181.servico.CarregadorFoguete;
import br.uniriotec.pm20181.servico.CarregadorPlanoVoo;
import br.uniriotec.pm20181.servico.ServicoMotores;
import org.junit.Test;



/**
 * Caso de teste que testa um foguete simples com motor de impulso linear
 * 
 * @author marcio.barros
 */
public class TestMotorImpulsoLinear
{
	@Test
	public void test()
	{
		ServicoMotores servicoMotoresSpy = mock(ServicoMotores.class);

		when(servicoMotoresSpy.pegaMotor("Ellis", "L600"))
			.thenReturn(criaMotorImpulsoLinear());

		when(servicoMotoresSpy.carregaImpulso(any()))
				.thenReturn(true);

		Foguete foguete = new CarregadorFoguete().carrega("data/avaliacao/foguete-01-descricao.xml", servicoMotoresSpy);
		PlanoVoo plano = new CarregadorPlanoVoo().carrega("data/avaliacao/foguete-01-plano-01.xml", foguete);

		Ambiente planetaTerra = FabricaAmbientes.getInstance().getTerra();
		Simulador simulador = new Simulador(planetaTerra);
		simulador.executa(foguete, plano, 120);

		SuporteCasosTeste.confereHistorico(simulador, 0, "0.0000", "0.8643", "57.6169", "5.7617", "0.1956", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2, "0.2000", "4.3525", "58.7507", "17.4552", "0.1923", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 4, "0.4000", "10.2246", "59.8819", "29.3750", "0.1890", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 6, "0.6000", "18.5259", "61.0078", "41.5204", "0.1857", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 8, "0.8000", "28.2168", "-10.1547", "46.6617", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 10, "1.0000", "37.1438", "-10.1249", "44.6352", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 12, "1.2000", "45.6667", "-10.0964", "42.6146", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 14, "1.4000", "53.7865", "-10.0694", "40.5993", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 16, "1.6000", "61.5043", "-10.0438", "38.5893", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 18, "1.8000", "68.8211", "-10.0195", "36.5842", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 20, "2.0000", "75.7378", "-9.9966", "34.5838", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 22, "2.2000", "82.2552", "-9.9750", "32.5877", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 24, "2.4000", "88.3744", "-9.9547", "30.5958", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 26, "2.6000", "94.0958", "-9.9358", "28.6077", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 28, "2.8000", "99.4204", "-9.9181", "26.6232", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 30, "3.0000", "104.3488", "-9.9017", "24.6421", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 32, "3.2000", "108.8816", "-9.8865", "22.6640", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 34, "3.4000", "113.0193", "-9.8727", "20.6888", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 36, "3.6000", "116.7625", "-9.8600", "18.7162", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 38, "3.8000", "120.1117", "-9.8486", "16.7459", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 40, "4.0000", "123.0672", "-9.8384", "14.7777", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 42, "4.2000", "125.6295", "-9.8294", "12.8114", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 44, "4.4000", "127.7988", "-9.8216", "10.8467", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 46, "4.6000", "129.5755", "-9.8150", "8.8834", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 48, "4.8000", "130.9597", "-9.8096", "6.9212", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 50, "5.0000", "131.9517", "-9.8054", "4.9600", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 52, "5.2000", "132.5515", "-9.8024", "2.9993", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 54, "5.4000", "132.7594", "-9.8006", "1.0391", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 56, "5.6000", "132.5752", "-9.8000", "-0.9209", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 58, "5.8000", "131.9990", "-9.7994", "-2.8808", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 60, "6.0000", "131.0309", "-9.7977", "-4.8405", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 62, "6.2000", "129.6710", "-9.7948", "-6.7996", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 64, "6.4000", "127.9194", "-9.7907", "-8.7579", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 66, "6.6000", "125.7763", "-9.7854", "-10.7153", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 68, "6.8000", "123.2420", "-9.7789", "-12.6714", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 70, "7.0000", "120.3168", "-9.7712", "-14.6260", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 72, "7.2000", "117.0010", "-9.7624", "-16.5790", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 74, "7.4000", "113.2950", "-9.7524", "-18.5300", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 76, "7.6000", "109.1992", "-9.7412", "-20.4788", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 78, "7.8000", "104.7141", "-9.7288", "-22.4252", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 80, "8.0000", "99.8403", "-9.7153", "-24.3689", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 82, "8.2000", "94.5783", "-9.7006", "-26.3098", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 84, "8.4000", "88.9288", "-9.6847", "-28.2475", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 86, "8.6000", "82.8923", "-9.6677", "-30.1819", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 88, "8.8000", "76.4697", "-9.6495", "-32.1127", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 90, "9.0000", "69.6617", "-9.6302", "-34.0398", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 92, "9.2000", "62.4691", "-9.6097", "-35.9627", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 94, "9.4000", "54.8928", "-9.5880", "-37.8814", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 96, "9.6000", "46.9336", "-9.5653", "-39.7956", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 98, "9.8000", "38.5925", "-9.5414", "-41.7051", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 100, "10.0000", "29.8705", "-9.5163", "-43.6097", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 102, "10.2000", "20.7687", "-9.4902", "-45.5090", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 104, "10.4000", "11.2880", "-9.4629", "-47.4030", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 106, "10.6000", "1.4297", "-9.4346", "-49.2913", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 108, "10.8000", "0.0000", "0.0000", "0.0000", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 110, "11.0000", "0.0000", "0.0000", "0.0000", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 112, "11.2000", "0.0000", "0.0000", "0.0000", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 114, "11.4000", "0.0000", "0.0000", "0.0000", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 116, "11.6000", "0.0000", "0.0000", "0.0000", "0.1848", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 118, "11.8000", "0.0000", "0.0000", "0.0000", "0.1848", "0.0001");
	}

	private Motor criaMotorImpulsoLinear()
	{
		Motor motor = new Motor();
		motor.setPesoCombustivel(12.48);
		motor.setPesoTotal(12.48);
		motor.setTempoImpulso(0.751879699);
		motor.adicionaImpulso(0, 13.3);
		motor.adicionaImpulso(0.751879699, 13.3);
		return motor;
	}
}