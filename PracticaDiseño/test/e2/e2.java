package e2;

import e2.CODIGO.Flota;
import e2.CODIGO.Nodos.Tipos.Bufurcacion.Avistamiento;
import e2.CODIGO.Nodos.Tipos.Bufurcacion.Batalla;
import e2.CODIGO.Nodos.Tipos.Fin;
import e2.CODIGO.Nodos.Tipos.RutaFija.AtaqueAereo;
import e2.CODIGO.Nodos.Tipos.RutaFija.TormentaMarina;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class e2 {
    private static Flota fl2;
    private static Fin f6;
    private static AtaqueAereo R1;
    private static Fin f5;
    private static Fin f4;
    private static TormentaMarina R2;
    private static Batalla B3;
    private static AtaqueAereo R4;
    private static Batalla B4;
    private static AtaqueAereo R6;
    private static TormentaMarina R7;
    private static Fin f3;
    private static Fin f2;
    private static Fin f1;
    private static Avistamiento B1;
    private static Avistamiento B2;
    private static TormentaMarina R3;
    private static Avistamiento B5;

    @BeforeAll
    public static void setUpBeforeAll() {
        fl2 = new Flota(25,12,20,12,2);
        f6 = new Fin("Q");
        R1 = new AtaqueAereo("P", f6, 13);
        f5 = new Fin("O");
        f4 = new Fin("N");
        R2 = new TormentaMarina("M", f4, 12);
        B3 = new Batalla("L", R2, f5, fl2);
        R4 = new AtaqueAereo("K", B3, 20);
        B4 = new Batalla("J", R4, R1, fl2);
        R6 = new AtaqueAereo("I", B4, 30);
        R7 = new TormentaMarina("H", R6, 10);
        f3 = new Fin("G");
        f2 = new Fin("F");
        f1 = new Fin("E");
        B1 = new Avistamiento("D", f1, f2, 4);
        B2 = new Avistamiento("C", B1, f3, 12);
        R3 = new TormentaMarina("B", B2, 2);
        B5 = new Avistamiento("A", R3, R7, 4);
    }

    @Test
    public void Ruta(){
        assertEquals("( A AVISTAMIENTO ( B TORMENTA MARINA ( C AVISTAMIENTO ( D AVISTAMIENTO ( E FIN )( F FIN ) )( G FIN ) ) )( H TORMENTA MARINA ( I ATAQUE AEREO ( J BATALLA ( K ATAQUE AEREO ( L BATALLA ( M TORMENTA MARINA ( N FIN ) )( O FIN ) ) )( P ATAQUE AEREO ( Q FIN ) ) ) ) ) )",B5.imprimirRuta());
    }

    @Test
    public void CaminoMinimo(){
        assertEquals(4,B5.rutaMasCorta());
    }

    @Test
    public void FlotaTieneExito1(){
        Flota fl1 = new Flota(2,12,12,12,12);
        assertEquals("EXITO\nULTIMO NODO VISITADO: E\nHP FINAL: 2",B5.avanzar(fl1));
    }

    @Test
    public void FlotaTieneExito2(){
        Flota fl1 = new Flota(20,12,12,12,1);
        assertEquals("EXITO\nULTIMO NODO VISITADO: Q\nHP FINAL: 2",B5.avanzar(fl1));
    }

    @Test
    public void FlotaSinExitoNodoTormentaMarina(){
        Flota fl1 = new Flota(2,12,12,12,1);
        assertEquals("FALLO\nULTIMO NODO VISITADO: H\nHP FINAL: -8",B5.avanzar(fl1));
    }

    @Test
    public void FlotaSinExitoNodoAtaqueAereo(){
        Flota fl1 = new Flota(12,0,12,0,1);
        assertEquals("FALLO\nULTIMO NODO VISITADO: I\nHP FINAL: -28",B5.avanzar(fl1));
    }

    @Test
    public void FlotaSinExitoNodoBatalla(){
        Flota fl1 = new Flota(42,0,12,0,1);
        assertEquals("FALLO\nULTIMO NODO VISITADO: J\nHP FINAL: -18",B5.avanzar(fl1));
    }
}
