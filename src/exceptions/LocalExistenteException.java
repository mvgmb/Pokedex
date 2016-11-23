package exceptions;

/**
 * Created by gevd on 23/11/2016.
 */
public class LocalExistenteException extends Exceptions {
    public LocalExistenteException(){
        super("Esse local já existe");
    }
}
