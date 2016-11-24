package exceptions;

/**
 * Created by assf on 23/11/16.
 */
public class AtaqueEfeitoInvalidoException extends Exception {
    public AtaqueEfeitoInvalidoException() {
        super("Descrição do efeito inválida");
    }
}
