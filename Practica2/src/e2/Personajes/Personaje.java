package e2.Personajes;
import e2.Objects.Attack.Attack;
import e2.Objects.Defense.Defense;

import java.util.ArrayList;

public abstract class Personaje {
    private final String nombre;
    private int vida;
    private final int fuerza;
    private final int mana;
    private final ArrayList<Attack> objetosAtaque;
    private final ArrayList<Defense> objetosDefensa;
    public Personaje(String nombre, int vida, int fuerza, int mana) {
        if (vida <= 0 | vida >= 20 | fuerza <= 0 | fuerza > 10 | mana <= 0 | mana > 10) throw new IllegalArgumentException("Personaje no valido");
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.mana = mana;
        this.objetosAtaque = new ArrayList<>();
        this.objetosDefensa = new ArrayList<>();
    }
    public void addObjetoAtaque(Attack item){
        if (objetosAtaque.size() == 5) throw new IllegalArgumentException("Too much items");
        else objetosAtaque.add(item);
    }
    public void addObjetoDefensa(Defense item){
        if (objetosDefensa.size() == 5) throw new IllegalArgumentException("Too much items");
        else objetosDefensa.add(item);
    }
    public int getDefensa(){
        int defense = 0;
        for (Defense item:objetosDefensa){
            if(fuerza >= item.getMinFuerza()) defense+=item.getDefensa();
        }
        return defense;
    }
    public int getDano(){
        int damage = 0;
        if (objetosAtaque.isEmpty()){
            return damage;
        }
        if(mana>=objetosAtaque.get(0).getMinMana()){
            damage = objetosAtaque.get(0).getDano();
            if(objetosAtaque.get(0).getUsos() == 0) objetosAtaque.remove(0);
        }
        return damage;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public String getNombre() {
        return nombre;
    }
}
