package exceptions;

public class AttackInexistenteException extends Exception {
    public AttackInexistenteException() {
        super("Esse Ataque não existe");
    }
}
