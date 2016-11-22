package exceptions;

/**
 * Created by mathe on 22/11/2016.
 */
public class PokemonInexistenteException extends Exception {
    public PokemonInexistenteException() {
        super("Pokemon Inexistente");
    }
}
