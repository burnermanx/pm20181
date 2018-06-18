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

public class TestMotorParaquedas
{
	@Test
	public void testCicloCurto()
	{
		ServicoMotores servicoMotores = new ServicoMotores();
		Foguete foguete = new CarregadorFoguete().carrega("data/avaliacao/foguete-02-descricao.xml", servicoMotores);
		PlanoVoo plano = new CarregadorPlanoVoo().carrega("data/avaliacao/foguete-02-plano-02.xml", foguete);

		Ambiente planetaTerra = FabricaAmbientes.getInstance().getTerra();
		Simulador simulador = new Simulador(planetaTerra);
		simulador.executa(foguete, plano, 800);

		SuporteCasosTeste.confereHistorico(simulador, 0, "0.0000", "0.0000", "0.0000", "0.0000", "9.2177", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 10, "1.0000", "38.2736", "74.9770", "68.8969", "8.9086", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 20, "2.0000", "151.0864", "69.9340", "141.3400", "8.5995", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 30, "3.0000", "332.6094", "62.2865", "207.2251", "8.2904", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 40, "4.0000", "575.2625", "54.3413", "265.1856", "7.9813", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 50, "5.0000", "870.9419", "45.7258", "314.8278", "7.6722", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 60, "6.0000", "1211.1155", "37.6463", "355.9658", "7.3631", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 70, "7.0000", "1586.0095", "7.6892", "383.0264", "7.0540", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 80, "8.0000", "1964.1017", "-42.3711", "369.7827", "5.1144", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 90, "9.0000", "2303.4971", "-43.5855", "320.8641", "5.1144", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 100, "10.0000", "2600.4959", "-35.0667", "282.2338", "5.1144", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 110, "11.0000", "2863.2661", "-29.1383", "250.5937", "5.1144", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 120, "12.0000", "3097.6256", "-17.1526", "224.6940", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 130, "13.0000", "3282.7789", "-47.6473", "163.4628", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 140, "14.0000", "3422.2329", "-31.6243", "125.5514", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 150, "15.0000", "3531.1679", "-23.1589", "98.9803", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 160, "16.0000", "3617.6183", "-18.1751", "78.7624", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 170, "17.0000", "3686.3273", "-15.0330", "62.4280", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 180, "18.0000", "3740.2918", "-12.9690", "48.5993", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 190, "19.0000", "3781.4808", "-11.5909", "36.4341", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 200, "20.0000", "3811.2065", "-10.6832", "25.3752", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 210, "21.0000", "3830.3267", "-10.1242", "15.0248", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 220, "22.0000", "3839.3597", "-9.8462", "5.0749", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 230, "23.0000", "3838.5483", "-9.7823", "-4.7292", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 240, "24.0000", "3827.9893", "-9.5717", "-14.4149", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 250, "25.0000", "3807.9270", "-9.1405", "-23.7664", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 260, "26.0000", "3778.8200", "-8.5248", "-32.5816", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 270, "27.0000", "3741.3035", "-7.7732", "-40.7021", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 280, "28.0000", "3696.1410", "-6.9385", "-48.0209", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 290, "29.0000", "3644.1710", "-6.0717", "-54.4834", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 300, "30.0000", "3586.2579", "-5.2159", "-60.0820", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 310, "31.0000", "3523.2504", "-4.4042", "-64.8467", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 320, "32.0000", "3455.9497", "-3.6588", "-68.8348", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 330, "33.0000", "3385.0889", "-2.9924", "-72.1203", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 340, "34.0000", "3311.3220", "-2.4094", "-74.7851", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 350, "35.0000", "3235.2196", "-1.9085", "-76.9123", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 360, "36.0000", "3157.2711", "-1.4845", "-78.5816", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 370, "37.0000", "3077.8900", "-1.1303", "-79.8659", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 380, "38.0000", "2997.4215", "-0.8373", "-80.8303", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 390, "39.0000", "2916.1509", "-0.5972", "-81.5315", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 400, "40.0000", "2834.3116", "-0.4019", "-82.0179", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 410, "41.0000", "2752.0935", "-0.2441", "-82.3302", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 420, "42.0000", "2669.6497", "-0.1174", "-82.5023", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 430, "43.0000", "2587.1032", "-0.0163", "-82.5622", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 440, "44.0000", "2504.5521", "0.0641", "-82.5328", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 450, "45.0000", "2422.0743", "0.1275", "-82.4325", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 460, "46.0000", "2339.7313", "0.1774", "-82.2766", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 470, "47.0000", "2257.5713", "0.2164", "-82.0769", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 480, "48.0000", "2175.6321", "0.2466", "-81.8433", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 490, "49.0000", "2093.9428", "0.2698", "-81.5835", "1.1000", "0.0045");
		SuporteCasosTeste.confereHistorico(simulador, 500, "50.0000", "2024.3352", "91.3607", "-30.4236", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 510, "51.0000", "2007.2984", "3.7752", "-14.1003", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 520, "52.0000", "1994.3237", "0.5771", "-12.5916", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 530, "53.0000", "1981.9167", "0.1056", "-12.3400", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 540, "54.0000", "1969.6127", "0.0250", "-12.2897", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 550, "55.0000", "1957.3332", "0.0109", "-12.2744", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 560, "56.0000", "1945.0646", "0.0085", "-12.2651", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 570, "57.0000", "1932.8044", "0.0080", "-12.2570", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 580, "58.0000", "1920.5522", "0.0079", "-12.2490", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 590, "59.0000", "1908.3079", "0.0079", "-12.2411", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 600, "60.0000", "1896.0715", "0.0079", "-12.2332", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 610, "61.0000", "1883.8431", "0.0079", "-12.2253", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 620, "62.0000", "1871.6225", "0.0079", "-12.2174", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 630, "63.0000", "1859.4097", "0.0079", "-12.2096", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 640, "64.0000", "1847.2049", "0.0078", "-12.2017", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 650, "65.0000", "1835.0078", "0.0078", "-12.1939", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 660, "66.0000", "1822.8187", "0.0078", "-12.1861", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 670, "67.0000", "1810.6373", "0.0078", "-12.1782", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 680, "68.0000", "1798.4638", "0.0078", "-12.1704", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 690, "69.0000", "1786.2980", "0.0078", "-12.1626", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 700, "70.0000", "1774.1401", "0.0078", "-12.1548", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 710, "71.0000", "1761.9899", "0.0078", "-12.1470", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 720, "72.0000", "1749.8476", "0.0078", "-12.1393", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 730, "73.0000", "1737.7130", "0.0078", "-12.1315", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 740, "74.0000", "1725.5861", "0.0077", "-12.1237", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 750, "75.0000", "1713.4670", "0.0077", "-12.1160", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 760, "76.0000", "1701.3557", "0.0077", "-12.1083", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 770, "77.0000", "1689.2521", "0.0077", "-12.1005", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 780, "78.0000", "1677.1561", "0.0077", "-12.0928", "1.1000", "0.0962");
		SuporteCasosTeste.confereHistorico(simulador, 790, "79.0000", "1665.0679", "0.0077", "-12.0851", "1.1000", "0.0962");
	}
}