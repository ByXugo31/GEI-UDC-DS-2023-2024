package e2.CODIGO.Nodos.Tipos.RutaFija;

import e2.CODIGO.Flota;
import e2.CODIGO.Nodos.Nodo;

public class NodoRutaFija extends Nodo {
    public NodoRutaFija(String nombre, String tipo, Nodo n1) {
        super(nombre,tipo);
        addHijos(n1);
    }

    @Override
    public int rutaMasCorta(){
        return 1 + nodosHijos.get(0).rutaMasCorta();
    }

    @Override
    public String avanzar(Flota f) {
        return null;
    }

    @Override
    public String imprimirRuta() {
        return "( " + getNombre() + " " + getTipo() + " " + nodosHijos.get(0).imprimirRuta() + " )";
    }
}
