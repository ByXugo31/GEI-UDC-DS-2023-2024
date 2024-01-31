package e2.CODIGO.Nodos.Tipos.RutaFija;

import e2.CODIGO.Flota;
import e2.CODIGO.Nodos.Nodo;
import e2.CODIGO.Nodos.NodoOperaciones;

public class TormentaMarina extends NodoRutaFija {
    private final int fuerza;
    public TormentaMarina(String nombre, Nodo n1, int fuerza) {
        super(nombre,"TORMENTA MARINA" ,n1);
        this.fuerza = fuerza;
    }

    @Override
    public String avanzar(Flota f){
        if(f.getLineaVision()<fuerza) f.setVida(f.getVida()-10);
        if(f.getVida()<=0) return "FALLO\nULTIMO NODO VISITADO: " + getNombre() + "\nHP FINAL: " + f.getVida();
        else return nodosHijos.get(0).avanzar(f);
    }
}
