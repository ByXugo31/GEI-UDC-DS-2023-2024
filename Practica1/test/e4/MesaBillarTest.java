package e4;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


public class MesaBillarTest {

    private static MesaBillar mesa;

    @BeforeAll
    public static void setUp() {
        mesa = new MesaBillar();
    }

    @Test
    public void testIniciarPartida() {
        mesa.iniciarPartida();
        assertTrue(mesa.esPartidaIniciada());
    }

    @Test
    public void testMeterBolaBlanca() {
        BolaBillar blanca = BolaBillar.blanca;
        mesa.meterBola(blanca);
        assertTrue(mesa.bolasMesa().contains(blanca));
    }

    @Test
    public void testMeterBolaNegra() {
        BolaBillar negra = BolaBillar.b8;
        mesa.iniciarPartida();
        mesa.meterBola(negra);
        assertTrue(mesa.bolasCajetin().contains(negra));
        assertFalse(mesa.esPartidaIniciada());
    }

    @Test
    public void testMeterBolaOtra() {
        BolaBillar bola = BolaBillar.b1;
        mesa.iniciarPartida();
        mesa.meterBola(bola);
        assertFalse(mesa.bolasMesa().contains(bola));
        assertTrue(mesa.bolasCajetin().contains(bola));
    }

    @Test
    public void testObtenerGanadorVaGanandoLisas() {
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.b4);
        mesa.meterBola(BolaBillar.b3);
        mesa.meterBola(BolaBillar.b1);
        mesa.meterBola(BolaBillar.b2);
        mesa.meterBola(BolaBillar.b3);
        assertEquals("Va ganando el jugador de las bolas lisas.", mesa.obtenerGanador());
    }

    @Test
    public void testObtenerGanadorVaGanandoRayadas() {
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.b9);
        mesa.meterBola(BolaBillar.b10);
        mesa.meterBola(BolaBillar.b11);
        mesa.meterBola(BolaBillar.b12);
        mesa.meterBola(BolaBillar.b15);
        assertEquals("Va ganando el jugador de las bolas rayadas.", mesa.obtenerGanador());
    }

    @Test
    public void testObtenerGanadorVanEmpate() {
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.b1);
        mesa.meterBola(BolaBillar.b2);
        mesa.meterBola(BolaBillar.b11);
        mesa.meterBola(BolaBillar.b12);
        assertEquals("Ambos jugadores tienen las mismas bolas metidas.", mesa.obtenerGanador());
    }

    @Test
    public void testObtenerGanadorGananLisas() {
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.b1);
        mesa.meterBola(BolaBillar.b8);
        assertEquals("Ha ganado el jugador de las bolas lisas.", mesa.obtenerGanador());
    }

    @Test
    public void testObtenerGanadorGananRayadas() {
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.b11);
        mesa.meterBola(BolaBillar.b8);
        assertEquals("Ha ganado el jugador de las bolas rayadas.", mesa.obtenerGanador());
    }

    @Test
    public void testObtenerGanadorEmpate() {
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.b11);
        mesa.meterBola(BolaBillar.b1);
        mesa.meterBola(BolaBillar.b8);
        assertEquals("Empate, ambos jugadores tienen las mismas bolas metidas.", mesa.obtenerGanador());
    }

    @Test
    public void testMeterBolaFueraDePartida() {
        BolaBillar bola = BolaBillar.b4;
        mesa.meterBola(bola);
        assertFalse(mesa.bolasMesa().contains(bola));
        assertTrue(mesa.bolasCajetin().contains(bola));
    }
}
