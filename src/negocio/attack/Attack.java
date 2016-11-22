package negocio.attack;

/**
 * Created by mathe on 22/11/2016.
 */
public class Attack {
    private String name;
    private String type;
    private int pp;
    private int damage;

    public Attack() {

        this.name = null;
        this.type = null;
        this.pp = 0;
        this.damage = 0;

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPP() {
        return this.pp;
    }

    public void setPP(int pp) {
        this.pp = pp;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
