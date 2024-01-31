package e2.CODIGO.Nodos.Tipos.Bufurcacion;

import e2.CODIGO.Flota;
import e2.CODIGO.Nodos.Nodo;

public class Batalla extends NodoBifurcacion {
    private final Flota flotaRival;
    public Batalla(String nombre, Nodo n1, Nodo n2, Flota flotaRival) {
        super(nombre,"BATALLA", n1, n2);
        this.flotaRival = flotaRival;
    }

    @Override
    public String avanzar(Flota f) {
        int danoARival = flotaRival.getBlindaje()-f.getPoderFuego();
        int danoAFlota = f.getBlindaje()-flotaRival.getPoderFuego();
        if(danoARival>0) danoARival=0;
        if(danoAFlota>0) danoAFlota=0;
        f.setVida(f.getVida()+danoAFlota);
        if(f.getVida()<=0) return "FALLO\nULTIMO NODO VISITADO: " + getNombre() + "\nHP FINAL: " + f.getVida();
        if(flotaRival.getVida()-danoARival>0) return nodosHijos.get(1).avanzar(f);
        return nodosHijos.get(0).avanzar(f);
    }
}
