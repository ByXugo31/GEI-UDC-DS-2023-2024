package e2.CODIGO.Nodos.Tipos.Bufurcacion;

import e2.CODIGO.Flota;
import e2.CODIGO.Nodos.Nodo;

public class NodoBifurcacion extends Nodo {
    public NodoBifurcacion(String nombre,String tipo,Nodo n1, Nodo n2) {
        super(nombre,tipo);
        addHijos(n1);
        addHijos(n2);
    }

    @Override
    public int rutaMasCorta(){
        int ruta1 = 1 + nodosHijos.get(0).rutaMasCorta();
        int ruta2 = 1 + nodosHijos.get(1).rutaMasCorta();
        if(ruta1<ruta2 || ruta1==ruta2) return ruta1;
        return ruta2;
    }

    @Override
    public String avanzar(Flota f) {
        return null;
    }

    @Override
    public String imprimirRuta() {
        return "( " + getNombre() + " " + getTipo() + " " + nodosHijos.get(0).imprimirRuta() + nodosHijos.get(1).imprimirRuta() + " )";
    }
}
