package exceptions;

public class AttackExistenteException extends Exception {
    public AttackExistenteException() {
        super("Esse Ataque j� existe");
    }
}
