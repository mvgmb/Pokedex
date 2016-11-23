package exceptions;

/**
 * Created by assf on 23/11/16.
 */
public class AttackNaoFazDanoException extends Exception {
    public AttackNaoFazDanoException() {
        super("Esse ataque não causa dano");
    }
}
