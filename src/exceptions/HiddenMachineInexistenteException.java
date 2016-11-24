package exceptions;

/**
 * Created by mario on 24/11/16.
 */
public class HiddenMachineInexistenteException extends Exception {
    public HiddenMachineInexistenteException(){
        super("Essa Hidden Machine já existe");
    }
}
