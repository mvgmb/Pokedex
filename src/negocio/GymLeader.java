package negocio;

import abstracts.Coach;

/**
 * Created by mario on 21/11/16.
 */
public class GymLeader extends Coach {
    private String badge;

    public GymLeader(String name, String badge) {
        super(name);
        this.badge = badge;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getName() {
        return this.getName();
    }

    public void setName(String name) {
        this.setName(name);
    }
}
