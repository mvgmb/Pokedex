package exceptions;

/**
 * Created by mario on 22/11/16.
 */
public class TrainerInexistenteException extends Exception {
    public TrainerInexistenteException() {
        super("Treinador não existe");
    }
}
