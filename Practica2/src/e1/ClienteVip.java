package e1;

public class ClienteVip extends Cliente{
    public ClienteVip(String DNI, Cuenta cuenta) {
        super(DNI, cuenta, -999999999, 0, 0, 0);
    }
}
