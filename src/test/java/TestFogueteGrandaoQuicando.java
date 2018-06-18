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

public class TestFogueteGrandaoQuicando
{
	@Test
	public void testCicloCurto()
	{
		ServicoMotores servicoMotores = new ServicoMotores();
		Foguete foguete = new CarregadorFoguete().carrega("data/avaliacao/foguete-03-descricao.xml", servicoMotores);
		PlanoVoo plano = new CarregadorPlanoVoo().carrega("data/avaliacao/foguete-03-plano-02.xml", foguete);

		Ambiente planetaTerra = FabricaAmbientes.getInstance().getTerra();
		Simulador simulador = new Simulador(planetaTerra);
		simulador.executa(foguete, plano, 1800);

		SuporteCasosTeste.confereHistorico(simulador, 0, "0.0000", "0.0000", "0.0000", "0.0000", "23.6174", "0.0151");
		SuporteCasosTeste.confereHistorico(simulador, 10, "1.0000", "28.7218", "55.9707", "51.6337", "22.9992", "0.0151");
		SuporteCasosTeste.confereHistorico(simulador, 20, "2.0000", "113.0225", "51.7559", "105.4565", "22.3810", "0.0151");
		SuporteCasosTeste.confereHistorico(simulador, 30, "3.0000", "248.1174", "45.7186", "153.9981", "21.7628", "0.0151");
		SuporteCasosTeste.confereHistorico(simulador, 40, "4.0000", "428.0423", "39.5952", "196.3730", "21.1446", "0.0151");
		SuporteCasosTeste.confereHistorico(simulador, 50, "5.0000", "646.5647", "33.0464", "232.3916", "20.5264", "0.0151");
		SuporteCasosTeste.confereHistorico(simulador, 60, "6.0000", "897.2021", "26.9281", "261.9647", "19.9082", "0.0151");
		SuporteCasosTeste.confereHistorico(simulador, 70, "7.0000", "1172.5916", "4.7611", "281.0206", "19.2900", "0.0151");
		SuporteCasosTeste.confereHistorico(simulador, 80, "8.0000", "1449.6892", "-15.9341", "271.9991", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 90, "9.0000", "1710.3870", "-17.9731", "253.3694", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 100, "10.0000", "1953.2958", "-16.7165", "236.1061", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 110, "11.0000", "2179.6426", "-15.6622", "219.9843", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 120, "12.0000", "2390.4581", "-14.7705", "204.8246", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 130, "13.0000", "2586.6147", "-14.0114", "190.4814", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 140, "14.0000", "2768.8555", "-13.3615", "176.8357", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 150, "15.0000", "2937.8171", "-12.8026", "163.7884", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 160, "16.0000", "3094.0471", "-12.3202", "151.2569", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 170, "17.0000", "3238.0184", "-11.9029", "139.1712", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 180, "18.0000", "3370.1402", "-11.5413", "127.4715", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 190, "19.0000", "3490.7668", "-11.2280", "116.1062", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 200, "20.0000", "3600.2055", "-10.9567", "105.0307", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 210, "21.0000", "3698.7220", "-10.7226", "94.2056", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 220, "22.0000", "3786.5455", "-10.5214", "83.5962", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 230, "23.0000", "3863.8728", "-10.3499", "73.1714", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 240, "24.0000", "3930.8715", "-10.2051", "62.9033", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 250, "25.0000", "3987.6828", "-10.0850", "52.7662", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 260, "26.0000", "4034.4233", "-9.9875", "42.7366", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 270, "27.0000", "4071.1874", "-9.9115", "32.7927", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 280, "28.0000", "4098.0480", "-9.8556", "22.9135", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 290, "29.0000", "4115.0583", "-9.8192", "13.0795", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 300, "30.0000", "4122.2516", "-9.8018", "3.2715", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 310, "31.0000", "4119.6431", "-9.7970", "-6.5280", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 320, "32.0000", "4107.2408", "-9.7771", "-16.3156", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 330, "33.0000", "4085.0675", "-9.7386", "-26.0731", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 340, "34.0000", "4053.1644", "-9.6815", "-35.7818", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 350, "35.0000", "4011.5914", "-9.6059", "-45.4232", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 360, "36.0000", "3960.4269", "-9.5119", "-54.9789", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 370, "37.0000", "3899.7677", "-9.3996", "-64.4305", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 380, "38.0000", "3829.7288", "-9.2692", "-73.7599", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 390, "39.0000", "3750.4431", "-9.1210", "-82.9490", "15.3396", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 400, "40.0000", "3662.0616", "-8.9535", "-91.9801", "15.2778", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 410, "41.0000", "3595.9040", "41.3208", "-49.4898", "14.9687", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 420, "42.0000", "3570.6977", "39.3075", "-9.3085", "14.6596", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 430, "43.0000", "3584.4526", "37.2088", "28.8354", "14.3505", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 440, "44.0000", "3635.1887", "35.4346", "65.0955", "14.0414", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 450, "45.0000", "3721.0317", "33.2551", "99.3746", "13.7323", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 460, "46.0000", "3839.8008", "31.1058", "131.4041", "13.4232", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 470, "47.0000", "3987.7061", "13.8591", "156.1468", "13.1141", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 480, "48.0000", "4147.0500", "-13.1858", "158.1019", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 490, "49.0000", "4297.3868", "-12.6139", "145.2380", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 500, "50.0000", "4435.1818", "-12.1239", "132.8998", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 510, "51.0000", "4560.9148", "-11.7032", "121.0126", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 520, "52.0000", "4674.9978", "-11.3420", "109.5126", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 530, "53.0000", "4777.7845", "-11.0321", "98.3450", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 540, "54.0000", "4869.5781", "-10.7671", "87.4621", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 550, "55.0000", "4950.6377", "-10.5417", "76.8221", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 560, "56.0000", "5021.1836", "-10.3518", "66.3876", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 570, "57.0000", "5081.4008", "-10.1938", "56.1252", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 580, "58.0000", "5131.4431", "-10.0651", "46.0045", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 590, "59.0000", "5171.4351", "-9.9635", "35.9974", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 600, "60.0000", "5201.4746", "-9.8872", "26.0779", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 610, "61.0000", "5221.6344", "-9.8352", "16.2213", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 620, "62.0000", "5231.9630", "-9.8065", "6.4038", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 630, "63.0000", "5232.4856", "-9.7993", "-3.3974", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 640, "64.0000", "5223.2117", "-9.7823", "-13.1892", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 650, "65.0000", "5204.1617", "-9.7425", "-22.9515", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 660, "66.0000", "5175.3789", "-9.6802", "-32.6616", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 670, "67.0000", "5136.9290", "-9.5953", "-42.2970", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 680, "68.0000", "5088.9001", "-9.4883", "-51.8352", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 690, "69.0000", "5031.4026", "-9.3594", "-61.2545", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 700, "70.0000", "4964.5686", "-9.2091", "-70.5330", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 710, "71.0000", "4888.5514", "-9.0379", "-79.6496", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 720, "72.0000", "4803.5254", "-8.8463", "-88.5838", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 730, "73.0000", "4709.6850", "-8.6351", "-97.3155", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 740, "74.0000", "4607.2444", "-8.4050", "-105.8256", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 750, "75.0000", "4496.4362", "-8.1569", "-114.0956", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 760, "76.0000", "4377.5111", "-7.8919", "-122.1082", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 770, "77.0000", "4250.7365", "-7.6109", "-129.8467", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 780, "78.0000", "4116.3957", "-7.3151", "-137.2961", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 790, "79.0000", "3974.7864", "-7.0059", "-144.4422", "11.1698", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 800, "80.0000", "3826.2195", "-6.6846", "-151.2723", "11.1389", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 810, "81.0000", "3706.3321", "62.1465", "-94.3619", "10.8298", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 820, "82.0000", "3648.5006", "59.1510", "-33.9145", "10.5207", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 830, "83.0000", "3649.4426", "56.6365", "23.8263", "10.2116", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 840, "84.0000", "3706.7247", "54.3864", "79.2811", "9.9025", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 850, "85.0000", "3817.8747", "51.0684", "131.9385", "9.5934", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 860, "86.0000", "3979.4895", "47.2330", "180.8695", "9.2843", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 870, "87.0000", "4186.2186", "24.7318", "220.5820", "8.9752", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 880, "88.0000", "4413.7006", "-16.6554", "227.8207", "7.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 890, "89.0000", "4629.6035", "-18.7235", "208.2305", "7.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 900, "90.0000", "4827.0182", "-17.1075", "190.4238", "7.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 910, "91.0000", "5007.5176", "-15.7907", "174.0622", "7.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 920, "92.0000", "5172.3848", "-14.7066", "158.8847", "7.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 930, "93.0000", "5322.6771", "-13.8066", "144.6867", "7.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 940, "94.0000", "5459.2731", "-13.0547", "131.3046", "7.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 950, "95.0000", "5582.9070", "-12.4237", "118.6060", "7.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 960, "96.0000", "5694.1952", "-11.8926", "106.4819", "7.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 970, "97.0000", "5793.6563", "-11.4455", "94.8416", "7.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 980, "98.0000", "5881.7271", "-11.0698", "83.6081", "7.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 990, "99.0000", "5958.7742", "-10.7555", "72.7159", "7.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1000, "100.0000", "6025.2090", "-3.4950", "62.8078", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1010, "101.0000", "6080.8606", "-11.4481", "50.9963", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1020, "102.0000", "6125.1555", "-10.8139", "39.9130", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1030, "103.0000", "6158.7022", "-10.3555", "29.3644", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1040, "104.0000", "6181.9376", "-10.0445", "19.1912", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1050, "105.0000", "6195.1536", "-9.8628", "9.2567", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1060, "106.0000", "6198.5143", "-9.8001", "-0.5620", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1070, "107.0000", "6192.0792", "-9.7475", "-10.3425", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1080, "108.0000", "6175.9231", "-9.5824", "-20.0083", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1090, "109.0000", "6150.2271", "-9.3110", "-29.4498", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1100, "110.0000", "6115.2769", "-8.9436", "-38.5661", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1110, "111.0000", "6071.4519", "-8.4939", "-47.2685", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1120, "112.0000", "6019.2117", "-7.9774", "-55.4831", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1130, "113.0000", "5959.0800", "-7.4111", "-63.1525", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1140, "114.0000", "5891.6278", "-6.8120", "-70.2361", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1150, "115.0000", "5817.4564", "-6.1963", "-76.7102", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1160, "116.0000", "5737.1815", "-5.5787", "-82.5664", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1170, "117.0000", "5651.4189", "-4.9718", "-87.8099", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1180, "118.0000", "5560.7722", "-4.3861", "-92.4574", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1190, "119.0000", "5465.8226", "-3.8296", "-96.5348", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1200, "120.0000", "5367.1211", "-3.3083", "-100.0746", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1210, "121.0000", "5265.1830", "-2.8259", "-103.1143", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1220, "122.0000", "5160.4848", "-2.3843", "-105.6938", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1230, "123.0000", "5053.4616", "-1.9841", "-107.8546", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1240, "124.0000", "4944.5077", "-1.6245", "-109.6376", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1250, "125.0000", "4833.9767", "-1.3042", "-111.0828", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1260, "126.0000", "4722.1835", "-1.0208", "-112.2282", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1270, "127.0000", "4609.4062", "-0.7718", "-113.1093", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1280, "128.0000", "4495.8893", "-0.5543", "-113.7590", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1290, "129.0000", "4381.8459", "-0.3656", "-114.2073", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1300, "130.0000", "4267.4609", "-0.2026", "-114.4812", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1310, "131.0000", "4152.8940", "-0.0627", "-114.6050", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1320, "132.0000", "4038.2819", "0.0569", "-114.6004", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1330, "133.0000", "3923.7417", "0.1585", "-114.4862", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1340, "134.0000", "3809.3727", "0.2443", "-114.2793", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1350, "135.0000", "3695.2585", "0.3165", "-113.9942", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1360, "136.0000", "3581.4697", "0.3768", "-113.6436", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1370, "137.0000", "3468.0650", "0.4268", "-113.2386", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1380, "138.0000", "3355.0931", "0.4680", "-112.7885", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1390, "139.0000", "3242.5941", "0.5016", "-112.3015", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1400, "140.0000", "3130.6006", "0.5287", "-111.7845", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1410, "141.0000", "3019.1390", "0.5503", "-111.2435", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1420, "142.0000", "2908.2301", "0.5672", "-110.6835", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1430, "143.0000", "2797.8903", "0.5802", "-110.1089", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1440, "144.0000", "2688.1320", "0.5898", "-109.5232", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1450, "145.0000", "2578.9646", "0.5966", "-108.9294", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1460, "146.0000", "2470.3943", "0.6010", "-108.3302", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1470, "147.0000", "2362.4255", "0.6035", "-107.7276", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1480, "148.0000", "2255.0603", "0.6043", "-107.1235", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1490, "149.0000", "2148.2993", "0.6038", "-106.5194", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1500, "150.0000", "2042.1418", "0.6022", "-105.9164", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1510, "151.0000", "1936.5861", "0.5996", "-105.3156", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1520, "152.0000", "1831.6295", "0.5962", "-104.7178", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1530, "153.0000", "1727.2685", "0.5923", "-104.1237", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1540, "154.0000", "1623.4991", "0.5879", "-103.5338", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1550, "155.0000", "1520.3170", "0.5831", "-102.9485", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1560, "156.0000", "1417.7171", "0.5780", "-102.3682", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1570, "157.0000", "1315.6943", "0.5726", "-101.7932", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1580, "158.0000", "1214.2433", "0.5671", "-101.2236", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1590, "159.0000", "1113.3586", "0.5615", "-100.6596", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1600, "160.0000", "1013.0345", "0.5557", "-100.1013", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1610, "161.0000", "913.2652", "0.5499", "-99.5487", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1620, "162.0000", "814.0450", "0.5441", "-99.0020", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1630, "163.0000", "715.3681", "0.5383", "-98.4610", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1640, "164.0000", "617.2286", "0.5325", "-97.9259", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1650, "165.0000", "519.6209", "0.5268", "-97.3965", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1660, "166.0000", "422.5390", "0.5211", "-96.8729", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1670, "167.0000", "325.9774", "0.5154", "-96.3549", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1680, "168.0000", "229.9303", "0.5098", "-95.8426", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1690, "169.0000", "134.3923", "0.5043", "-95.3358", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1700, "170.0000", "39.3576", "0.4988", "-94.8346", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1710, "171.0000", "0.0000", "0.0000", "0.0000", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1720, "172.0000", "0.0000", "0.0000", "0.0000", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1730, "173.0000", "0.0000", "0.0000", "0.0000", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1740, "174.0000", "0.0000", "0.0000", "0.0000", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1750, "175.0000", "0.0000", "0.0000", "0.0000", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1760, "176.0000", "0.0000", "0.0000", "0.0000", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1770, "177.0000", "0.0000", "0.0000", "0.0000", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1780, "178.0000", "0.0000", "0.0000", "0.0000", "2.0000", "0.0050");
		SuporteCasosTeste.confereHistorico(simulador, 1790, "179.0000", "0.0000", "0.0000", "0.0000", "2.0000", "0.0050");
	}
}