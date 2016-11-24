package exceptions;

public class AtaqueInexistenteException extends Exception {
    public AtaqueInexistenteException() {
        super("Esse ataque não existe");
    }
}
