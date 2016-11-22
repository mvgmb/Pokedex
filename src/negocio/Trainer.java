package negocio;

/**
 * Created by mario on 21/11/16.
 */
public class Trainer {
    private String name;
    private int badge;

    public Trainer(String name, int badge) {
        this.name = name;
        this.badge = badge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

}
