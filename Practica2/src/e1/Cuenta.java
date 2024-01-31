package e1;

public abstract class Cuenta {
    protected long saldo;
    private final String ISBN;
    public Cuenta(String ISBN) {
        this.ISBN = ISBN;
        this.saldo = 0;
    }
    public abstract void retirar(long cantidad, long maxDescubierto, double impuesto, long comision);
    public abstract void ingresar(long cantidad, long minimo);
}
