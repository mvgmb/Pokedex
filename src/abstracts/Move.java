package abstracts;

/**
 * Created by assf on 23/11/16.
 */
public abstract class Move {

    private String name;
    private int pp;
    private String effect;
    private String type;

    public abstract void setName(String name);

    public abstract String getName();

    public abstract void setPP(int pp);

    public abstract int getPP();

    public abstract void setEffect(String effect);

    public abstract String getEffect();

    public abstract void setType(String type);

    public abstract String getType();

}
