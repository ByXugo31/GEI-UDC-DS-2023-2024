package e2;
import e2.Personajes.Personaje;

public class Game {
    private final int maxTurnos;
    private final Personaje p1;
    private final Personaje p2;
    public Game(int maxTurnos, Personaje p1, Personaje p2) {
        this.maxTurnos = maxTurnos;
        this.p1 = p1;
        this.p2 = p2;
    }
    public int game1(Personaje ataca,Personaje defiende){
        return Math.max(ataca.getDano() - defiende.getDefensa(), 0);
    }
    public Personaje game2(){
        int turno;
        for (turno = 0; turno <= maxTurnos; turno++){
            p2.setVida(p2.getVida()-(game1(p1,p2)));
            if(p2.getVida() <= 0) return p1;
            p1.setVida(p1.getVida()-game1(p2,p1));
            if(p1.getVida() <= 0) return p2;
        }
        return null;
    }
}