package exceptions;

/**
 * Created by mario on 23/11/16.
 */
public class PokemonIDHabilidadeInexistenteException extends Exception {
    public PokemonIDHabilidadeInexistenteException(){
        super("O ID da habilidade do Pokémon não foi constatado na entrada, favor modificá-lo antes de continar");
    }
}
