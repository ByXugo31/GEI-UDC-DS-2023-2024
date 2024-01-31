package e2.Objects.Defense;
public class Armor extends ClassicDefenseObject {
    private String code;
    public Armor() {
        super(4,4);
        setCode();
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
    public void setCode() {
        code = "armor";
    }
    @Override
    public String getCode() {
        return code;
    }
}
