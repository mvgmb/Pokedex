package exceptions;

/**
 * Created by mathe on 22/11/2016.
 */
public class PokemonExistenteException extends Exception {
    public PokemonExistenteException() {
        super("Esse Pokémon já existe");
    }
}
