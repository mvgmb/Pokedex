package exceptions;

public class AtaqueExistenteException extends Exception {
    public AtaqueExistenteException() {
        super("Esse ataque já existe");
    }
}
