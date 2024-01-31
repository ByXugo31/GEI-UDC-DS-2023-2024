package e2.CODIGO.Nodos.Tipos;

import e2.CODIGO.Flota;
import e2.CODIGO.Nodos.Nodo;
import e2.CODIGO.Nodos.NodoOperaciones;

public class Fin extends Nodo {
    public Fin(String nombre) {
        super(nombre,"FIN");
    }
    @Override
    public String imprimirRuta() {
        return "( " + getNombre() + " " + getTipo() + " " + ")";
    }

    @Override
    public String avanzar(Flota f) {
        return "EXITO\nULTIMO NODO VISITADO: " + getNombre() + "\nHP FINAL: " + f.getVida();
    }
}
