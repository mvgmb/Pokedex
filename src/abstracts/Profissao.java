package abstracts;

/**
 *  Created by mario on 22/11/16.
 */
public abstract class Profissao {
    private String name;

    public Profissao(String name) {
        this.name = name;
    }

    public abstract String getName();

    public abstract void setName(String name);

}

