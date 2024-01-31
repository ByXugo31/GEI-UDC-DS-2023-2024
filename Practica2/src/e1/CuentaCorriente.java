package e1;

public class CuentaCorriente extends Cuenta{
    public CuentaCorriente(String ISBN) {super(ISBN);}
    @Override
    public void retirar(long cantidad, long maxDescubierto, double impuesto, long comision) {
        if(saldo - cantidad < maxDescubierto) throw new IllegalArgumentException("Máximo de descubierto alcanzado, cantidad de retirada no válida.");
        else saldo = saldo - cantidad;
    }

    @Override
    public void ingresar(long cantidad, long minRetirada) {
        saldo = saldo + cantidad;
    }

}