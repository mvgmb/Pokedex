package exceptions;

/**
 * Created by mario on 22/11/16.
 */
public class TrainerExistenteException extends Exception {

    public TrainerExistenteException() {
        super("Treinador já existe");
    }
}
