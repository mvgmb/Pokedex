package exceptions;

public class AttackInexistenteException extends Exception {
    public AttackInexistenteException() {
        super("Esse Ataque n�o existe");
    }
}
