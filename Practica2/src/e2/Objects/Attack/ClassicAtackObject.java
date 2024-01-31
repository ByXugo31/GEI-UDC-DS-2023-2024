package e2.Objects.Attack;

public abstract class ClassicAtackObject implements Attack {
    protected int dano;
    protected int minMana;
    protected int usos;
    public ClassicAtackObject(int dano, int minMana, int usos) {
        this.dano = dano;
        this.minMana = minMana;
        this.usos = usos;
    }
    public void setUsos(int usos) {
        this.usos = usos;
    }
}
