package e2.CODIGO;

import e2.CODIGO.Nodos.Nodo;

public class Flota {
    int vida;
    int blindaje;
    int poderFuego;
    int antiaereos;
    int lineaVision;

    public Flota(int vida, int blindaje, int poderFuego, int antiaereos, int lineaVision) {
        this.vida = vida;
        this.blindaje = blindaje;
        this.poderFuego = poderFuego;
        this.antiaereos = antiaereos;
        this.lineaVision = lineaVision;
    }
    public int getVida() {
        return vida;
    }

    public int getBlindaje() {
        return blindaje;
    }

    public int getPoderFuego() {
        return poderFuego;
    }

    public int getAntiaereos() {
        return antiaereos;
    }

    public int getLineaVision() {
        return lineaVision;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
