package e4;

import java.util.ArrayList;
import java.util.Arrays;
public class MesaBillar {

    private ArrayList<BolaBillar> BolasMesa;
    private ArrayList<BolaBillar> BolasCajetin;
    private boolean enPartida;

    public MesaBillar() {
        this.BolasMesa = new ArrayList<>();
        this.BolasCajetin = new ArrayList<>(Arrays.asList(BolaBillar.values()));
        this.enPartida = false;
    }

    public void iniciarPartida(){
        this.BolasMesa.addAll(this.BolasCajetin);
        this.BolasCajetin.clear();
        this.enPartida = true;
    }

    public void meterBola(BolaBillar bola){
        if(bola.getColor().equals("blanco")) return;
        if(bola.getColor().equals("negro")){
            this.BolasCajetin.add(bola);
            this.enPartida = false;
            return;
        }
        this.BolasMesa.remove(bola);
        this.BolasCajetin.add(bola);
    }

    public ArrayList<BolaBillar> bolasMesa(){return this.BolasMesa;}

    public ArrayList<BolaBillar> bolasCajetin(){return this.BolasCajetin;}

    public boolean esPartidaIniciada(){return this.enPartida;}

    public String obtenerGanador() {
        int lisaCount = 0, rayaCount = 0;

        for (BolaBillar bola : this.BolasCajetin) {
            if (bola.getTipo().equals("lisa")) lisaCount++;
            else if (bola.getTipo().equals("rayada")) rayaCount++;
        }

        if (!this.enPartida) {
            if (rayaCount > lisaCount) {
                return "Ha ganado el jugador de las bolas rayadas.";
            } else if (lisaCount > rayaCount) {
                return "Ha ganado el jugador de las bolas lisas.";
            } else {
                return "Empate, ambos jugadores tienen las mismas bolas metidas.";
            }
        }

        if (rayaCount > lisaCount) {
            return "Va ganando el jugador de las bolas rayadas.";
        } else if (lisaCount > rayaCount) {
            return "Va ganando el jugador de las bolas lisas.";
        } else {
            return "Ambos jugadores tienen las mismas bolas metidas.";
        }
    }

}

