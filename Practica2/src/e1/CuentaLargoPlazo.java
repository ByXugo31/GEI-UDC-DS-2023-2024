package e1;

public class CuentaLargoPlazo extends Cuenta {
    public CuentaLargoPlazo(String IBAN) {super(IBAN);}


    @Override
    public void retirar(long cantidad, long maxDescubierto, double impuesto, long comision) {
        long com = Math.max(cantidad + comision, (int) (cantidad + cantidad*impuesto));
        if (saldo - com <= maxDescubierto) throw new IllegalArgumentException("Máximo de descubierto alcanzado, cantidad de retirada no válida.");
        else saldo-=com;
    }

    @Override
    public void ingresar(long cantidad, long minimo){
        if(cantidad>=minimo) saldo+=cantidad;
        else throw new IllegalArgumentException("Cantidad introducida menor a la permitida por la cuenta.");
    }
}
