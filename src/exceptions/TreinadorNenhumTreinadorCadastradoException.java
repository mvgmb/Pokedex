package exceptions;

/**
 * Created by mario on 24/11/16.
 */
public class TreinadorNenhumTreinadorCadastradoException extends Exception {
    public TreinadorNenhumTreinadorCadastradoException(){
        super("Nenhum treinador cadastrado");
    }
}
