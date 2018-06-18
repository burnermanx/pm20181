package br.unirio.pm.test.avaliacao;

import br.uniriotec.pm20181.controle.Simulador;
import br.uniriotec.pm20181.modelo.ambiente.Ambiente;
import br.uniriotec.pm20181.modelo.ambiente.FabricaAmbientes;
import br.uniriotec.pm20181.modelo.foguete.Foguete;
import br.uniriotec.pm20181.modelo.plano.PlanoVoo;
import br.uniriotec.pm20181.servico.CarregadorFoguete;
import br.uniriotec.pm20181.servico.CarregadorPlanoVoo;
import br.uniriotec.pm20181.servico.ServicoMotores;
import br.uniriotec.pm20181.servico.ServicoMotoresThrustCurve;
import org.junit.Test;



public class TestMotorCurvaImpulsoMarte
{
	@Test
	public void testCicloCurto()
	{
		ServicoMotores servicoMotores = new ServicoMotoresThrustCurve();
		Foguete foguete = new CarregadorFoguete().carrega("data/avaliacao/foguete-01-descricao.xml", servicoMotores);
		PlanoVoo plano = new CarregadorPlanoVoo().carrega("data/avaliacao/foguete-01-plano-01.xml", foguete);

		Ambiente planetaTerra = FabricaAmbientes.getInstance().getMarte();
		Simulador simulador = new Simulador(planetaTerra);
		simulador.executa(foguete, plano, 3000);

		SuporteCasosTeste.confereHistorico(simulador, 0, "0.0000", "0.0000", "0.0000", "0.0000", "4.2737", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1, "0.1000", "0.0000", "0.0000", "0.0000", "4.2428", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2, "0.2000", "2.8702", "191.3457", "19.1346", "4.2119", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 3, "0.3000", "7.6223", "189.2438", "38.0590", "4.1810", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 4, "0.4000", "14.2349", "187.1108", "56.7700", "4.1501", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 5, "0.5000", "22.6860", "184.9460", "75.2646", "4.1192", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 6, "0.6000", "32.9726", "184.0055", "93.6652", "4.0882", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 7, "0.7000", "45.1146", "185.0316", "112.1683", "4.0573", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 8, "0.8000", "59.1225", "186.0732", "130.7757", "4.0264", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 9, "0.9000", "75.0070", "187.1308", "149.4887", "3.9955", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 10, "1.0000", "92.7747", "187.9180", "168.2805", "3.9646", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 11, "1.1000", "112.4311", "188.5549", "187.1360", "3.9337", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 12, "1.2000", "133.9827", "189.2018", "206.0562", "3.9028", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 13, "1.3000", "157.4362", "189.8588", "225.0421", "3.8719", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 14, "1.4000", "182.7931", "190.1791", "244.0600", "3.8410", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 15, "1.5000", "210.0559", "190.4521", "263.1052", "3.8100", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 16, "1.6000", "239.2273", "190.7294", "282.1782", "3.7791", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 17, "1.7000", "270.3109", "191.0485", "301.2830", "3.7482", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 18, "1.8000", "303.3143", "191.6762", "320.4506", "3.7173", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 19, "1.9000", "338.2441", "192.3144", "339.6821", "3.6864", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 20, "2.0000", "375.1068", "192.9631", "358.9784", "3.6555", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 21, "2.1000", "413.9079", "193.5514", "378.3335", "3.6246", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 22, "2.2000", "454.6515", "194.0214", "397.7357", "3.5937", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 23, "2.3000", "497.3426", "194.4995", "417.1856", "3.5628", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 24, "2.4000", "541.9860", "194.9858", "436.6842", "3.5319", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 25, "2.5000", "588.5856", "195.4146", "456.2257", "3.5010", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 26, "2.6000", "637.1453", "195.8066", "475.8063", "3.4700", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 27, "2.7000", "687.6690", "196.2055", "495.4269", "3.4391", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 28, "2.8000", "740.1608", "196.6114", "515.0880", "3.4082", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 29, "2.9000", "794.6281", "197.2297", "534.8110", "3.3773", "0.0001");
	}

	@Test
	public void testCicloLongo()
	{
		ServicoMotores servicoMotores = new ServicoMotoresThrustCurve();
		Foguete foguete = new CarregadorFoguete().carrega("data/avaliacao/foguete-01-descricao.xml", servicoMotores);
		PlanoVoo plano = new CarregadorPlanoVoo().carrega("data/avaliacao/foguete-01-plano-01.xml", foguete);

		Ambiente planetaTerra = FabricaAmbientes.getInstance().getMarte();
		Simulador simulador = new Simulador(planetaTerra);
		simulador.executa(foguete, plano, 3000);

		SuporteCasosTeste.confereHistorico(simulador, 0, "0.0000", "0.0000", "0.0000", "0.0000", "4.2737", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 100, "10.0000", "9376.3784", "-3.9169", "1515.9875", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 200, "20.0000", "24339.8655", "-3.7705", "1477.7111", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 300, "30.0000", "38925.6241", "-3.7292", "1440.2563", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 400, "40.0000", "53138.2742", "-3.7170", "1403.0379", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 500, "50.0000", "66979.1744", "-3.7131", "1365.8913", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 600, "60.0000", "80448.7465", "-3.7118", "1328.7677", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 700, "70.0000", "93547.1286", "-3.7114", "1291.6518", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 800, "80.0000", "106274.3668", "-3.7114", "1254.5382", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 900, "90.0000", "118630.4982", "-3.7109", "1217.4324", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1000, "100.0000", "130615.5645", "-3.7110", "1180.3229", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1100, "110.0000", "142229.5327", "-3.7110", "1143.2129", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1200, "120.0000", "153472.4011", "-3.7110", "1106.1029", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1300, "130.0000", "164344.1696", "-3.7110", "1068.9930", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1400, "140.0000", "174844.8382", "-3.7110", "1031.8830", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1500, "150.0000", "184974.4067", "-3.7110", "994.7730", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1600, "160.0000", "194732.8753", "-3.7110", "957.6630", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1700, "170.0000", "204120.2438", "-3.7110", "920.5530", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1800, "180.0000", "213136.5124", "-3.7110", "883.4430", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1900, "190.0000", "221781.6809", "-3.7110", "846.3330", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2000, "200.0000", "230055.7495", "-3.7110", "809.2230", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2100, "210.0000", "237958.7180", "-3.7110", "772.1130", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2200, "220.0000", "245490.5865", "-3.7110", "735.0030", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2300, "230.0000", "252651.3551", "-3.7110", "697.8930", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2400, "240.0000", "259441.0236", "-3.7110", "660.7830", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2500, "250.0000", "265859.5922", "-3.7110", "623.6730", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2600, "260.0000", "271907.0607", "-3.7110", "586.5630", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2700, "270.0000", "277583.4293", "-3.7110", "549.4530", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2800, "280.0000", "282888.6978", "-3.7110", "512.3430", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2900, "290.0000", "287822.8664", "-3.7110", "475.2330", "1.8318", "0.0001");
	}
}