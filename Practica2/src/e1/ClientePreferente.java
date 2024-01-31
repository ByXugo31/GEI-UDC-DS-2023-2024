package e1;

public class ClientePreferente extends  Cliente{
    public ClientePreferente(String DNI, Cuenta cuenta) {
        super(DNI, cuenta, -1000, 0.02, 1, 500);
    }
}
