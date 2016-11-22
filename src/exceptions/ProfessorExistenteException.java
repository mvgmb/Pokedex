package exceptions;

/**
 * Created by mario on 22/11/16.
 */
public class ProfessorExistenteException extends Exception {

    public ProfessorExistenteException() {
        super("Professor já existe");
    }
}

