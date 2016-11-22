package classesprimarias;

import abstracts.Coach;

/**
 * Created by mario on 21/11/16.
 */
public class Trainer extends Coach {
    private int badge;

    public Trainer(String name, int bagde) {
        super(name);
        this.badge = badge;
    }

    public String getName() {
        return this.getName();
    }

    public void setName(String name) {
        this.setName(name);
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }
}
