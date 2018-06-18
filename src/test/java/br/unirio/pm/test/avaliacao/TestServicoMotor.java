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

    @BeforeClass
    public static void inicializar() {
        servicoMotores = new ServicoMotoresThrustCurve();
    }

    @Test
    public void testeServicoWeb() {
        Motor motorVazio = servicoMotores.pegaMotor("teste", "teste");
        Motor motorEllis600 = servicoMotores.pegaMotor("Ellis", "L600");

        assertNull(motorVazio);
        assertNotNull(motorEllis600);
        assertEquals(motorEllis600.getFabricante(), "Ellis");
        assertEquals(motorEllis600.getNome(), "L600");
    }
}
