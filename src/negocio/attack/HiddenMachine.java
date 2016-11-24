package negocio.attack;

import abstracts.Move;

/**
 * Created by mathe on 22/11/2016.
 */

public class HiddenMachine extends Move {
    private String name;
    private String type;
    private int pp;
    private String effect;
    private String outsideEffect;

    public HiddenMachine() {

        this.name = null;
        this.type = null;
        this.pp = 0;
        this.outsideEffect = null;
        this.effect = null;

    }

    public HiddenMachine(String name, String type, int pp, String outSideEffect, String effect) {

        this.name = name;
        this.type = type;
        this.pp = pp;
        this.outsideEffect = outSideEffect;
        this.effect = effect;

    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getEffect() { return this.effect; }

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

    public String getOutEffect() {
        return this.outsideEffect;
    }

    public void setOutEffect(String outEffect) {
        this.outsideEffect = outEffect;
    }
}
