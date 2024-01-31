package e1;

public class ClienteNormal extends Cliente {
    public ClienteNormal(String DNI, Cuenta cuenta) {
        super(DNI, cuenta, 0, 0.04, 3, 1000);
    }
}
