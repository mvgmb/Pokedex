package exceptions;

/**
 * Created by assf on 23/11/16.
 */
public class AttackEfeitoInvalidoException extends Exception {
    public AttackEfeitoInvalidoException() {
        super("Esse ataque não é HM");
    }
}
