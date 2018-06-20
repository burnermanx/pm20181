package br.unirio.pm.test.avaliacao;

import br.uniriotec.pm20181.modelo.foguete.Motor;
import br.uniriotec.pm20181.servico.ServicoMotores;
import br.uniriotec.pm20181.servico.ServicoMotoresThrustCurve;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestServicoMotor {

    private static ServicoMotores servicoMotores;
    private static final Double ELLIS_600_PESO_TOTAL = 4119.81;
    private static final Double ELLIS_600_TEMPO_IMPULSO = 4995.4;

    @BeforeClass
    public static void inicializar() {
        servicoMotores = new ServicoMotoresThrustCurve();
    }

    @Test
    public void testeServicoBuscaErro() {
        Motor motorVazio = servicoMotores.pegaMotor("teste", "teste");
        assertNull(motorVazio);
    }

    @Test
    public void testeServicoBuscaEllisL600() {
        Motor motorEllis600 = servicoMotores.pegaMotor("Ellis", "L600");
        assertNotNull(motorEllis600);
        assertEquals(motorEllis600.getFabricante(), "Ellis");
        assertEquals(motorEllis600.getNome(), "L600");
        assertEquals(new Double(motorEllis600.getPesoTotal()), ELLIS_600_PESO_TOTAL);
        assertEquals(new Double(motorEllis600.getTempoImpulso()), ELLIS_600_TEMPO_IMPULSO);
    }
}
