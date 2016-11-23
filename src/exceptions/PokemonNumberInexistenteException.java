package exceptions;

/**
 * Created by mathe on 23/11/2016.
 */
public class PokemonNumberInexistenteException extends Exception {
    public PokemonNumberInexistenteException(){
        super("Numero do pokémon não informado, tente digitar um número diferente e maior que zero");
    }
}
