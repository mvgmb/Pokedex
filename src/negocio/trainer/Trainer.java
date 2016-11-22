package negocio.trainer;

import abstracts.Profissao;

/**
 * Created by mario on 21/11/16.
 */
public class Trainer extends Profissao {
    private String name;
    private int badge;

    public Trainer(String name, int badge) {
        super(name);
        this.badge = badge;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
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
