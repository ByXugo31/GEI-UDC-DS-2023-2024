package e2.Objects.Mixed;
import e2.Objects.Attack.Attack;
import e2.Objects.Defense.Defense;

public class Wand implements Attack, Defense {
    private String code;
    private final int defensa;
    private final int fuerza;
    private final int dano;
    private final int minMana;
    private int usos;
    public Wand() {
        this.defensa = 1;
        this.fuerza = 1;
        this.dano = 8;
        this.minMana = 4;
        this.usos = 7;
        setCode();
    }
    @Override
    public int getMinMana() {
        return minMana;
    }
    @Override
    public int getDano() {
        if (usos != 0){
            if (usos == 7){
                usos--;
                return dano*2;
            }
            else{
                usos--;
                return dano;
            }
        }
        else return 0;
    }
    @Override
    public int getMinFuerza() {
        return fuerza;
    }
    @Override
    public int getDefensa() {
        return defensa;
    }
    @Override
    public int getUsos(){
        return usos;
    }
    @Override
    public void setCode() {
        this.code = "wand";
    }
    @Override
    public String getCode() {
        return code;
    }
}
