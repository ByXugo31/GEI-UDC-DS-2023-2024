package e2.Objects.Mixed;
import e2.Objects.Attack.Attack;
import e2.Objects.Defense.Defense;

public class Sword implements Attack, Defense {
    private String code;
    private final int defensa;
    private final int fuerza;
    private final int dano;
    private final int minMana;
    private int usos;
    public Sword() {
        this.defensa = 2;
        this.fuerza = 2;
        this.dano = 6;
        this.minMana = 2;
        this.usos = 10;
        setCode();
    }
    @Override
    public int getMinMana() {
        return minMana;
    }
    @Override
    public int getDano() {
        if (usos!=0){
            usos = usos-1;
            return dano;
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
        this.code = "sword";
    }
    @Override
    public String getCode() {
        return code;
    }
}
