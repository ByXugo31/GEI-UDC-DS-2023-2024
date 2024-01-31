package e1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test1 {
    private static ClienteNormal clienteNC;
    private static ClienteNormal clienteNLP;
    private static ClientePreferente clientePC;
    private static ClientePreferente clientePLP;
    private static ClienteVip clienteVC;
    private static ClienteVip clienteVLP;

    @BeforeAll
    public static void inicializar() {
        clienteNC = new ClienteNormal("24782472424", new CuentaCorriente("87489724897"));
        clienteNLP = new ClienteNormal("2874987129874", new CuentaLargoPlazo("4789273487"));
        clientePC = new ClientePreferente("847289374897", new CuentaCorriente("28748914287"));
        clientePLP = new ClientePreferente("8378932874", new CuentaLargoPlazo("73879879w789798"));
        clienteVC = new ClienteVip("832798327947", new CuentaCorriente("83278937498"));
        clienteVLP = new ClienteVip("8923749879", new CuentaLargoPlazo("832749827894"));
    }

    @Test
    public void testClienteNormalCorriente() {
        //INGRESO NORMAL
        clienteNC.ingreso(500);
        assertEquals(500, clienteNC.getSaldo());

        //RETIRO NORMAL
        clienteNC.retiro(500);
        assertEquals(0, clienteNC.getSaldo());

        //RETIRO HACIENDO QUE SALDO < 0
        assertThrows(IllegalArgumentException.class, () -> {
            clienteNC.retiro(500);
        });
    }

    @Test
    public void testClienteNormalLargoPlazo(){
        //INGRESO MINIMO 1000
        clienteNLP.ingreso(1000);
        assertEquals(1000,clienteNLP.getSaldo());

        //INGRESO MENOR A MINIMO
        assertThrows(IllegalArgumentException.class, () -> {
            clienteNLP.ingreso(500);});

        //RETIRO HACIENDO QUE SALDO < 0
        assertThrows(IllegalArgumentException.class, () -> {
            clienteNLP.retiro(2500);});

        //RETIRADA APLICANDO COMISIÓN
        clienteNLP.retiro(2);
        assertEquals(995,clienteNLP.getSaldo());

        //RETIRADA APLICANDO IMPUESTO
        clienteNLP.retiro(100);
        assertEquals(891,clienteNLP.getSaldo());
    }

    @Test
    void testClientePreferenteCorriente(){
        //RETIRO DEJANDO LA CUENTA < 0 PERO MAYOR O IGUAL A -1000
        clientePC.retiro(1000);
        assertEquals(-1000,clientePC.getSaldo());

        //RETIRO DEJANDO LA CUENTA < -1000
        assertThrows(IllegalArgumentException.class, () -> {
            clientePC.retiro(2500);});

        //INGRESO
        clientePC.ingreso(1000);
        assertEquals(0,clientePC.getSaldo());
    }

    @Test
    void testClientePreferenteLargoPLazo(){

        //RETIRO DEJANDO LA CUENTA < 0 PERO MAYOR O IGUAL A -1000
        clientePLP.retiro(980);
        assertEquals(-999,clientePLP.getSaldo());

        //RETIRO DEJANDO LA CUENTA < -1000
        assertThrows(IllegalArgumentException.class, () -> {
            clientePLP.retiro(2500);});

        //INGRESO MENOR A MINIMO (500)
        assertThrows(IllegalArgumentException.class, () -> {
            clientePLP.ingreso(200);});

        //INGRESO
        clientePLP.ingreso(101000);
        assertEquals(100001,clientePLP.getSaldo());

        //RETIRO APLICANDO COMISION
        clientePLP.retiro(2);
        assertEquals(99998,clientePLP.getSaldo());

        //RETIRO APLICANDO IMPUESTO
        clientePLP.retiro(100);
        assertEquals(99896,clientePLP.getSaldo());
    }

    @Test
    void testClienteVipCorriente(){

        //RETIRO HACIENDO QUE SALDO < 0
        clienteVC.retiro(800000);
        assertEquals(-800000,clienteVC.getSaldo());

        //INGRESO SIN NINGUN MINIMO
        clienteVC.ingreso(1);
        assertEquals(-799999,clienteVC.getSaldo());
    }

    @Test
    void testClienteVipLargoPlazo(){
        //RETIRO HACIENDO QUE SALDO < 0
        clienteVLP.retiro(800000);
        assertEquals(-800000,clienteVLP.getSaldo());

        //INGRESO SIN NINGUN MINIMO
        clienteVLP.ingreso(1);
        assertEquals(-799999,clienteVLP.getSaldo());
    }
}