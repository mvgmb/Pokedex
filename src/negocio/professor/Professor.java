package negocio.professor;

import abstracts.Profissao;

/**
 * Created by mario on 22/11/16.
 */
public class Professor extends Profissao {
    private String name;
    private String lab;

    public Professor(String name, String lab) {
        super(name);
        this.lab = lab;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getLab() {
        return this.lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }
}
