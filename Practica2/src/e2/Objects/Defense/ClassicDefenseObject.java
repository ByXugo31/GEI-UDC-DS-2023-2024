package e2.Objects.Defense;
public abstract class ClassicDefenseObject implements Defense {
    protected int defensa;
    protected int fuerza;
    public ClassicDefenseObject(int defensa, int fuerza) {
        this.defensa = defensa;
        this.fuerza = fuerza;
    }
}
