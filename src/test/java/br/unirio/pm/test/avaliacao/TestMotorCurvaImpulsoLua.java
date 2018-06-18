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


public class TestMotorCurvaImpulsoLua
{
	@Test
	public void testCicloCurto()
	{
		ServicoMotores servicoMotores = new ServicoMotoresThrustCurve();
		Foguete foguete = new CarregadorFoguete().carrega("data/avaliacao/foguete-01-descricao.xml", servicoMotores);
		PlanoVoo plano = new CarregadorPlanoVoo().carrega("data/avaliacao/foguete-01-plano-01.xml", foguete);

		Ambiente planetaTerra = FabricaAmbientes.getInstance().getLua();
		Simulador simulador = new Simulador(planetaTerra);
		simulador.executa(foguete, plano, 30);

		SuporteCasosTeste.confereHistorico(simulador, 0, "0.0000", "0.0000", "0.0000", "0.0000", "4.2737", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1, "0.1000", "0.0000", "0.0000", "0.0000", "4.2428", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2, "0.2000", "2.9016", "193.4367", "19.3437", "4.2119", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 3, "0.3000", "7.7059", "191.3348", "38.4772", "4.1810", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 4, "0.4000", "14.3917", "189.2019", "57.3973", "4.1501", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 5, "0.5000", "22.9370", "187.0373", "76.1011", "4.1192", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 6, "0.6000", "33.3385", "186.0970", "94.7108", "4.0882", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 7, "0.7000", "45.6165", "187.1233", "113.4231", "4.0573", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 8, "0.8000", "59.7813", "188.1653", "132.2396", "4.0264", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 9, "0.9000", "75.8436", "189.2233", "151.1620", "3.9955", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 10, "1.0000", "93.8099", "190.0110", "170.1631", "3.9646", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 11, "1.1000", "113.6860", "190.6485", "189.2279", "3.9337", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 12, "1.2000", "135.4782", "191.2959", "208.3575", "3.9028", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 13, "1.3000", "159.1933", "191.9537", "227.5529", "3.8719", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 14, "1.4000", "184.8327", "192.2747", "246.7803", "3.8410", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 15, "1.5000", "212.3989", "192.5485", "266.0352", "3.8100", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 16, "1.6000", "241.8948", "192.8268", "285.3179", "3.7791", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 17, "1.7000", "273.3238", "193.1468", "304.6326", "3.7482", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 18, "1.8000", "306.6937", "193.7757", "324.0101", "3.7173", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 19, "1.9000", "342.0110", "194.4150", "343.4516", "3.6864", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 20, "2.0000", "379.2821", "195.0650", "362.9581", "3.6555", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 21, "2.1000", "418.5127", "195.6545", "382.5236", "3.6246", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 22, "2.2000", "459.7070", "196.1260", "402.1362", "3.5937", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 23, "2.3000", "502.8697", "196.6056", "421.7967", "3.5628", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 24, "2.4000", "548.0057", "197.0935", "441.5061", "3.5319", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 25, "2.5000", "595.1192", "197.5240", "461.2585", "3.5010", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 26, "2.6000", "644.2138", "197.9177", "481.0502", "3.4700", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 27, "2.7000", "695.2936", "198.3185", "500.8821", "3.4391", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 28, "2.8000", "748.3627", "198.7264", "520.7547", "3.4082", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 29, "2.9000", "803.4284", "199.3467", "540.6894", "3.3773", "0.0001");
	}

	@Test
	public void testCicloLongo()
	{
		ServicoMotores servicoMotores = new ServicoMotoresThrustCurve();
		Foguete foguete = new CarregadorFoguete().carrega("data/avaliacao/foguete-01-descricao.xml", servicoMotores);
		PlanoVoo plano = new CarregadorPlanoVoo().carrega("data/avaliacao/foguete-01-plano-01.xml", foguete);

		Ambiente planetaTerra = FabricaAmbientes.getInstance().getLua();
		Simulador simulador = new Simulador(planetaTerra);
		simulador.executa(foguete, plano, 3000);

		SuporteCasosTeste.confereHistorico(simulador, 0, "0.0000", "0.0000", "0.0000", "0.0000", "4.2737", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 100, "10.0000", "9484.2194", "-1.6200", "1537.8543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 200, "20.0000", "24780.1428", "-1.6200", "1521.6543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 300, "30.0000", "39914.0662", "-1.6200", "1505.4543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 400, "40.0000", "54885.9896", "-1.6200", "1489.2543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 500, "50.0000", "69695.9130", "-1.6200", "1473.0543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 600, "60.0000", "84343.8364", "-1.6200", "1456.8543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 700, "70.0000", "98829.7598", "-1.6200", "1440.6543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 800, "80.0000", "113153.6832", "-1.6200", "1424.4543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 900, "90.0000", "127315.6066", "-1.6200", "1408.2543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1000, "100.0000", "141315.5300", "-1.6200", "1392.0543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1100, "110.0000", "155153.4535", "-1.6200", "1375.8543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1200, "120.0000", "168829.3769", "-1.6200", "1359.6543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1300, "130.0000", "182343.3003", "-1.6200", "1343.4543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1400, "140.0000", "195695.2237", "-1.6200", "1327.2543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1500, "150.0000", "208885.1471", "-1.6200", "1311.0543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1600, "160.0000", "221913.0705", "-1.6200", "1294.8543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1700, "170.0000", "234778.9939", "-1.6200", "1278.6543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1800, "180.0000", "247482.9173", "-1.6200", "1262.4543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1900, "190.0000", "260024.8407", "-1.6200", "1246.2543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2000, "200.0000", "272404.7641", "-1.6200", "1230.0543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2100, "210.0000", "284622.6875", "-1.6200", "1213.8543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2200, "220.0000", "296678.6109", "-1.6200", "1197.6543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2300, "230.0000", "308572.5343", "-1.6200", "1181.4543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2400, "240.0000", "320304.4577", "-1.6200", "1165.2543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2500, "250.0000", "331874.3811", "-1.6200", "1149.0543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2600, "260.0000", "343282.3045", "-1.6200", "1132.8543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2700, "270.0000", "354528.2279", "-1.6200", "1116.6543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2800, "280.0000", "365612.1514", "-1.6200", "1100.4543", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2900, "290.0000", "376534.0748", "-1.6200", "1084.2543", "1.8318", "0.0001");
	}
}