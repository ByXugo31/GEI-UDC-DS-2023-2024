package e2.Objects.Attack;

public class FireBallSpell extends ClassicAtackObject {
    private String code;
    public FireBallSpell() {
        super(9,3,5);
        setCode();
    }
    @Override
    public int getMinMana() {
        return minMana;
    }
    @Override
    public int getDano() {
        if (usos != 0){
            if(usos == 1){
                usos = 0;
                return dano-1;
            }
            else{
                usos--;
                return dano;
            }
        } return 0;
    }
    @Override
    public int getUsos() {
        return usos;
    }
    @Override
    public void setCode() {
        code = "fball";
    }
    @Override
    public String getCode() {
        return code;
    }
}
