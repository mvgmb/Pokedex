package exceptions;

/**
 * Created by mathe on 22/11/2016.
 */
public class PokemonInvalidoException extends Exception {
    public PokemonInvalidoException() {
        super("Tipo de Pokemon inválido");
    }
}
