package exceptions;

import sun.reflect.annotation.ExceptionProxy;

/**
 * Created by mario on 24/11/16.
 */
public class LocalRotaInvalidaException extends Exception {
    public LocalRotaInvalidaException(){
        super("Número da rota inválido");
    }
}
