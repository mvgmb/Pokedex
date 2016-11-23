package exceptions;

/**
 * Created by mathe on 23/11/2016.
 */
public class PokemonNumberInvalidoException extends Exception {
    public PokemonNumberInvalidoException(){
        super("Número do pokémon inválido");
    }
}
