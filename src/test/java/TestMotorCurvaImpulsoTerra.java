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

public class TestMotorCurvaImpulsoTerra
{
	@Test
	public void testCicloCurto()
	{
		ServicoMotores servicoMotores = new ServicoMotores();
		Foguete foguete = new CarregadorFoguete().carrega("data/avaliacao/foguete-01-descricao.xml", servicoMotores);
		PlanoVoo plano = new CarregadorPlanoVoo().carrega("data/avaliacao/foguete-01-plano-01.xml", foguete);

		Ambiente planetaTerra = FabricaAmbientes.getInstance().getTerra();
		Simulador simulador = new Simulador(planetaTerra);
		simulador.executa(foguete, plano, 30);

		SuporteCasosTeste.confereHistorico(simulador, 0, "0.0000", "0.0000", "0.0000", "0.0000", "4.2737", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1, "0.1000", "0.0000", "0.0000", "0.0000", "4.2428", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2, "0.2000", "2.7789", "185.2567", "18.5257", "4.2119", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 3, "0.3000", "7.3787", "183.1525", "36.8409", "4.1810", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 4, "0.4000", "13.7780", "181.0126", "54.9422", "4.1501", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 5, "0.5000", "21.9547", "178.8363", "72.8258", "4.1192", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 6, "0.6000", "31.9055", "177.8799", "90.6138", "4.0882", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 7, "0.7000", "43.6502", "178.8855", "108.5023", "4.0573", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 8, "0.8000", "57.1989", "179.9018", "126.4925", "4.0264", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 9, "0.9000", "72.5621", "180.9291", "144.5854", "3.9955", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 10, "1.0000", "89.7459", "181.6809", "162.7535", "3.9646", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 11, "1.1000", "108.7554", "182.2771", "180.9812", "3.9337", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 12, "1.2000", "129.5967", "182.8780", "199.2690", "3.9028", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 13, "1.3000", "152.2758", "183.4835", "217.6174", "3.8719", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 14, "1.4000", "176.7938", "183.7467", "235.9920", "3.8410", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 15, "1.5000", "203.1523", "183.9570", "254.3877", "3.8100", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 16, "1.6000", "231.3536", "184.1661", "272.8044", "3.7791", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 17, "1.7000", "261.4002", "184.4112", "291.2455", "3.7482", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 18, "1.8000", "293.2991", "184.9592", "309.7414", "3.7173", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 19, "1.9000", "327.0560", "185.5115", "328.2925", "3.6864", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 20, "2.0000", "362.6762", "186.0684", "346.8994", "3.6555", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 21, "2.1000", "400.1645", "186.5584", "365.5552", "3.6246", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 22, "2.2000", "439.5239", "186.9241", "384.2476", "3.5937", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 23, "2.3000", "480.7581", "187.2915", "402.9768", "3.5628", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 24, "2.4000", "523.8707", "187.6608", "421.7429", "3.5319", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 25, "2.5000", "568.8644", "187.9662", "440.5395", "3.5010", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 26, "2.6000", "615.7418", "188.2283", "459.3623", "3.4700", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 27, "2.7000", "664.5054", "188.4908", "478.2114", "3.4391", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 28, "2.8000", "715.1579", "188.7539", "497.0868", "3.4082", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 29, "2.9000", "767.7049", "189.2228", "516.0091", "3.3773", "0.0001");
	}

	@Test
	public void testCicloLongo()
	{
		ServicoMotores servicoMotores = new ServicoMotores();
		Foguete foguete = new CarregadorFoguete().carrega("data/avaliacao/foguete-01-descricao.xml", servicoMotores);
		PlanoVoo plano = new CarregadorPlanoVoo().carrega("data/avaliacao/foguete-01-plano-01.xml", foguete);

		Ambiente planetaTerra = FabricaAmbientes.getInstance().getTerra();
		Simulador simulador = new Simulador(planetaTerra);
		simulador.executa(foguete, plano, 3000);

		SuporteCasosTeste.confereHistorico(simulador, 0, "0.0000", "0.0000", "0.0000", "0.0000", "4.2737", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 100, "10.0000", "8847.0215", "-21.8371", "1379.5459", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 200, "20.0000", "21771.2837", "-12.2188", "1223.4175", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 300, "30.0000", "33426.3373", "-10.3853", "1112.7218", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 400, "40.0000", "44033.9306", "-9.9580", "1011.5054", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 500, "50.0000", "53643.6926", "-9.8467", "912.6041", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 600, "60.0000", "62268.2724", "-9.8150", "814.3286", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 700, "70.0000", "69911.2137", "-9.8052", "716.2374", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 800, "80.0000", "76573.5958", "-9.8019", "618.2050", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 900, "90.0000", "82255.7735", "-9.8007", "520.1927", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1000, "100.0000", "86957.8724", "-9.8003", "422.1879", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1100, "110.0000", "90679.9399", "-9.8001", "324.1859", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1200, "120.0000", "93421.9948", "-9.8000", "226.1852", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1300, "130.0000", "95184.0451", "-9.8000", "128.1849", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1400, "140.0000", "95966.0941", "-9.8000", "30.1849", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1500, "150.0000", "95768.1430", "-9.8000", "-67.8151", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1600, "160.0000", "94590.1922", "-9.8000", "-165.8150", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1700, "170.0000", "92432.2438", "-9.7999", "-263.8146", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1800, "180.0000", "89294.3024", "-9.7998", "-361.8135", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 1900, "190.0000", "85176.3791", "-9.7996", "-459.8108", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2000, "200.0000", "80078.5014", "-9.7989", "-557.8039", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2100, "210.0000", "74000.7392", "-9.7972", "-655.7861", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2200, "220.0000", "66943.2828", "-9.7923", "-753.7381", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2300, "230.0000", "58906.6865", "-9.7772", "-851.5992", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2400, "240.0000", "49892.6869", "-9.7268", "-949.1670", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2500, "250.0000", "39907.1579", "-9.5457", "-1045.7128", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2600, "260.0000", "28971.5515", "-8.8467", "-1138.4179", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2700, "270.0000", "17169.6398", "-6.0304", "-1215.8337", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2800, "280.0000", "4834.8300", "4.4530", "-1233.5029", "1.8318", "0.0001");
		SuporteCasosTeste.confereHistorico(simulador, 2900, "290.0000", "0.0000", "0.0000", "0.0000", "1.8318", "0.0001");
	}
}