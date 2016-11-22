package exceptions;

/**
 * Created by mario on 22/11/16.
 */
public class ProfessorInexistenteException extends Exception {
    public ProfessorInexistenteException() {
        super("Professor não existe");
    }
}
