package e2.CODIGO.Nodos.Tipos.RutaFija;

import e2.CODIGO.Flota;
import e2.CODIGO.Nodos.Nodo;

public class AtaqueAereo extends NodoRutaFija {
    private final int poderAereo;
    public AtaqueAereo(String nombre, Nodo n1, int poderAereo) {
        super(nombre, "ATAQUE AEREO" ,n1);
        this.poderAereo = poderAereo;
    }

    @Override
    public String avanzar(Flota f){
        int poderFinal = poderAereo-(2*f.getAntiaereos()+f.getBlindaje());
        if(poderFinal<0) poderFinal = 0;
        f.setVida(f.getVida()-poderFinal);
        if(f.getVida()<=0) return "FALLO\nULTIMO NODO VISITADO: " + getNombre() + "\nHP FINAL: " + f.getVida();
        else return nodosHijos.get(0).avanzar(f);
    }
}
