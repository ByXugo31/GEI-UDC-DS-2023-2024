package e1;

public abstract class Cliente {
    private final String DNI;
    private final Cuenta cuenta;
    private final long maxDescubierto;
    private final double impuesto;
    private final long comision;
    private final long minIngreso;

    public Cliente(String DNI, Cuenta cuenta, long maxDescubierto, double impuesto, long comision, long minIngreso) {
        this.DNI = DNI;
        this.cuenta = cuenta;
        this.maxDescubierto = maxDescubierto;
        this.impuesto = impuesto;
        this.comision = comision;
        this.minIngreso = minIngreso;
    }

    public long getSaldo() {
        return cuenta.saldo;
    }

    public void retiro (long cantidad) {
        cuenta.retirar(cantidad,maxDescubierto,impuesto,comision);
    }

    public void ingreso (long cantidad){
        cuenta.ingresar(cantidad,minIngreso);
    }

}
