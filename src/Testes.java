import exceptions.*;
import negocio.pokemon.Pokemon;

/**
 * Created by mario on 23/11/16.
 */
public class Testes {

    public static void testar() {
        Fachada fachada = Fachada.getInstance();
        if (fachada.repInvalido) {
            // Tipo invalido
            try {
                Pokemon test = new Pokemon(123, "Pikachu", "Amor", "Static");
                test.setArrayMoveID("ElectroBall");
                test.setArrayLocalID("Kanto");
                fachada.cadastrarPokemon(test);
            } catch (AttackInexistenteException | TipoInvalidoException | LocalInexistenteException | PokemonExistenteException | InvalidoException e) {
                e.printStackTrace();
            }
            // Sem ataque
            try {
                Pokemon test = new Pokemon(123, "Pikachu", "Eletrico", "Static");
                test.setArrayLocalID("Kanto");
                fachada.cadastrarPokemon(test);
            } catch (AttackInexistenteException | TipoInvalidoException | LocalInexistenteException | PokemonExistenteException | InvalidoException e) {
                e.printStackTrace();
            }
            // Sem região
            try {
                Pokemon test = new Pokemon(123, "Pikachu", "Eletrico", "Static");
                test.setArrayMoveID("ElectroBall");
                fachada.cadastrarPokemon(test);
            } catch (AttackInexistenteException | TipoInvalidoException | LocalInexistenteException | PokemonExistenteException | InvalidoException e) {
                e.printStackTrace();
            }
            // Pokemon existente
            try {
                Pokemon test = new Pokemon(123, "Pikachu", "Amor", "Static");
                test.setArrayMoveID("ElectroBall");
                test.setArrayLocalID("Kanto");
                fachada.cadastrarPokemon(test);
                fachada.cadastrarPokemon(test);
            } catch (AttackInexistenteException | TipoInvalidoException | LocalInexistenteException | PokemonExistenteException | InvalidoException e) {
                e.printStackTrace();
            }
            // Pokemon null
            try {
                Pokemon test = null;
                fachada.cadastrarPokemon(test);
            } catch (AttackInexistenteException | TipoInvalidoException | LocalInexistenteException | PokemonExistenteException | InvalidoException e) {
                e.printStackTrace();
            }


        }
    }
}
