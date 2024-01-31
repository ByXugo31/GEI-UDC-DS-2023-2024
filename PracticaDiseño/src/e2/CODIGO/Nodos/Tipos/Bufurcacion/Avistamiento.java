package e2.CODIGO.Nodos.Tipos.Bufurcacion;

import e2.CODIGO.Flota;
import e2.CODIGO.Nodos.Nodo;

public class Avistamiento extends NodoBifurcacion {
    int distancia;
    public Avistamiento(String nombre, Nodo n1, Nodo n2,int distancia) {
        super(nombre,"AVISTAMIENTO", n1, n2);
        this.distancia = distancia;
    }

    @Override
    public String avanzar(Flota f) {
        if(f.getLineaVision()>=distancia) return nodosHijos.get(0).avanzar(f);
        return nodosHijos.get(1).avanzar(f);
    }
}
