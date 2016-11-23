package exceptions;

/**
 * Created by gevd on 23/11/2016.
 */
public class LocalInexistenteException extends Exception {
    public LocalInexistenteException(){
        super("Esse local não existe");
    }
}
