package exceptions;

/**
 * Created by assf on 23/11/16.
 */
public class AtaqueDanoInvalidoException extends Exception {
    public AtaqueDanoInvalidoException() {
        super("Valor de dano inválido");
    }
}
