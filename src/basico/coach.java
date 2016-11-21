package basico;

/**
 * Created by mario on 21/11/16.
 */
public abstract class coach {
    private String name;

    public coach(String name) {
        this.name = name;
    }

    public abstract String getName();

    public abstract void setName(String name);
}
