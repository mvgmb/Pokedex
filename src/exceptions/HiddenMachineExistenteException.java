package exceptions;

/**
 * Created by mario on 24/11/16.
 */
public class HiddenMachineExistenteException extends Exception {
    public HiddenMachineExistenteException(){
        super("Essa Hidden Machina já existe");
    }
}
