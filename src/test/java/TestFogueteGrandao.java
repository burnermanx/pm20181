package br.unirio.pm.test.avaliacao;

import org.junit.Test;

import br.unirio.pm.controle.Simulador;
import br.unirio.pm.modelo.ambiente.Ambiente;
import br.unirio.pm.modelo.ambiente.FabricaAmbientes;
import br.unirio.pm.modelo.foguete.Foguete;
import br.unirio.pm.modelo.plano.PlanoVoo;
import br.unirio.pm.servico.CarregadorFoguete;
import br.unirio.pm.servico.CarregadorPlanoVoo;
import br.unirio.pm.servico.ServicoMotores;

public class TestFogueteGrandao
{
	@Test
	public void testCicloCurto()
	{
		ServicoMotores servicoMotores = new ServicoMotores();
		Foguete foguete = new CarregadorFoguete().carrega("data/avaliacao/foguete-03-descricao.xml", servicoMotores);
		PlanoVoo plano = new CarregadorPlanoVoo().carrega("data/avaliacao/foguete-03-plano-01.xml", foguete);

		Ambiente planetaTerra = FabricaAmbientes.getInstance().getTerra();
		Simulador simulador = new Simulador(planetaTerra);
		simulador.executa(foguete, plano, 1800);

		SuporteCasosTeste.confereHistorico(simulador, 0, "0.0000", "0.0000", "0.0000", "0.0000", "23.6174", "0.0151");
		SuporteCasosTeste.confereHistorico(simulador, 50, "5.0000", "646.5647", "33.0464", "232.3916", "20.5264", "0.0151");
		SuporteCasosTeste.confereHistorico(simulador, 100, "10.0000", "2051.4236", "26.2027", "326.5326", "14.6905", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 150, "15.0000", "3947.0163", "-0.5907", "413.1623", "13.1450", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 200, "20.0000", "6225.1590", "22.7247", "521.0731", "9.9025", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 250, "25.0000", "8957.7205", "-42.6332", "501.1825", "7.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 300, "30.0000", "11029.2131", "-22.5591", "349.4390", "7.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 350, "35.0000", "12437.4169", "-24.1435", "212.4092", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 400, "40.0000", "13244.8396", "-14.1537", "122.1394", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 450, "45.0000", "13690.3333", "-10.8540", "61.1718", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 500, "50.0000", "13861.4806", "-9.8331", "10.1549", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 550, "55.0000", "13785.3518", "-9.4237", "-38.3488", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 600, "60.0000", "13476.6991", "-7.9629", "-82.1296", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 650, "65.0000", "12971.7187", "-5.8519", "-116.7096", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 700, "70.0000", "12322.2354", "-3.6615", "-140.3105", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 750, "75.0000", "11582.0037", "-1.8139", "-153.7088", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 800, "80.0000", "10796.5206", "-0.4825", "-159.1622", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 850, "85.0000", "9998.7442", "0.3565", "-159.2512", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 900, "90.0000", "9209.5741", "0.8194", "-156.1593", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 950, "95.0000", "8440.6191", "1.0335", "-151.4363", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1000, "100.0000", "7697.2975", "1.1002", "-146.0539", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1050, "105.0000", "6981.3357", "1.0879", "-140.5617", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1100, "110.0000", "6292.4707", "1.0382", "-135.2392", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1150, "115.0000", "5629.4873", "0.9740", "-130.2091", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1200, "120.0000", "4990.7990", "0.9072", "-125.5100", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1250, "125.0000", "4374.7467", "0.8432", "-121.1391", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1300, "130.0000", "3779.7389", "0.7842", "-117.0757", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1350, "135.0000", "3204.3061", "0.7308", "-113.2932", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1400, "140.0000", "2647.1151", "0.6825", "-109.7645", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1450, "145.0000", "2106.9635", "0.6391", "-106.4643", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1500, "150.0000", "1582.7679", "0.5999", "-103.3703", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1550, "155.0000", "1073.5501", "0.5644", "-100.4626", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1600, "160.0000", "578.4245", "0.5322", "-97.7240", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1650, "165.0000", "96.5862", "0.5028", "-95.1392", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1700, "170.0000", "0.0000", "0.0000", "0.0000", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1750, "175.0000", "0.0000", "0.0000", "0.0000", "2.0000", "0.0050");
	}
}