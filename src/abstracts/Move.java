package abstracts;

/**
 * Created by assf on 23/11/16.
 */
public abstract class Move {

    private String name;
    private String pp;
    private String effect;
    private String type;

    protected abstract void setName(String name);

    protected abstract String getName();

    protected abstract void setPP(String pp);

    protected abstract String getPP();

    protected abstract void setEffect(String effect);

    protected abstract String getEffect();

    protected abstract void setType(String type);

    protected abstract String getType();

}
