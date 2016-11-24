import exceptions.*;
import negocio.pokemon.Pokemon;
import fachada.Fachada;
import negocio.local.Local;

/**
 * Created by mario on 23/11/16.
 */
public class Testes
{

    public static void testar() throws InvalidoException, PokemonInexistenteException
    {
        Fachada fachada = Fachada.getInstance();
        if (fachada.repInvalido) {
            // <<<POKEMON>>>

            // CADASTRO>>

            // Tipo invalido
            try {
                Pokemon test = new Pokemon(123, "Pikachu", "Amor", "Static");
                test.setArrayMoveID("ElectroBall");
                test.setArrayLocalID("Kanto");
                fachada.cadastrarPokemon(test);
            } catch (PokemonNumberInexistenteException | AtaqueInexistenteException | TipoInvalidoException | LocalInexistenteException | PokemonExistenteException | InvalidoException | PokemonIDHabilidadeInexistenteException | PokemonNumberInvalidoException e) {
                e.printStackTrace();
            }
            // Sem ataque
            try {
                Pokemon test = new Pokemon(123, "Pikachu", "Eletrico", "Static");
                test.setArrayLocalID("Kanto");
                fachada.cadastrarPokemon(test);
            } catch (AtaqueInexistenteException | TipoInvalidoException | LocalInexistenteException | PokemonExistenteException | InvalidoException | PokemonNumberInexistenteException | PokemonIDHabilidadeInexistenteException | PokemonNumberInvalidoException e) {
                e.printStackTrace();
            }
            // Sem região
            try {
                Pokemon test = new Pokemon(123, "Pikachu", "Eletrico", "Static");
                test.setArrayMoveID("ElectroBall");
                fachada.cadastrarPokemon(test);
            } catch (AtaqueInexistenteException | TipoInvalidoException | LocalInexistenteException | PokemonExistenteException | InvalidoException | PokemonNumberInexistenteException | PokemonIDHabilidadeInexistenteException | PokemonNumberInvalidoException e) {
                e.printStackTrace();
            }
            // Pokemon existente
            try {
                Pokemon test = new Pokemon(123, "Pikachu", "Amor", "Static");
                test.setArrayMoveID("ElectroBall");
                test.setArrayLocalID("Kanto");
                fachada.cadastrarPokemon(test);
                fachada.cadastrarPokemon(test);
            } catch (AtaqueInexistenteException | TipoInvalidoException | LocalInexistenteException | PokemonExistenteException | InvalidoException | PokemonNumberInexistenteException | PokemonIDHabilidadeInexistenteException | PokemonNumberInvalidoException e) {
                e.printStackTrace();
            }
            // Pokemon null
            try {
                Pokemon test = null;
                fachada.cadastrarPokemon(test);
            } catch (AtaqueInexistenteException | TipoInvalidoException | LocalInexistenteException | PokemonExistenteException | InvalidoException | PokemonNumberInexistenteException | PokemonIDHabilidadeInexistenteException | PokemonNumberInvalidoException e) {
                e.printStackTrace();
            }
            //Move nulo
            try {
                Pokemon test = new Pokemon(123, "Pikachu", "Eletrico", "Static");
                test.setArrayMoveID("");
                test.setArrayLocalID("Kanto");
                fachada.cadastrarPokemon(test);
            } catch (AtaqueInexistenteException | TipoInvalidoException | LocalInexistenteException | PokemonExistenteException | InvalidoException | PokemonNumberInexistenteException | PokemonIDHabilidadeInexistenteException | PokemonNumberInvalidoException e) {
                e.printStackTrace();
            }
            //Local nulo
            try {
                Pokemon test = new Pokemon(123, "Pikachu", "Eletrico", "Static");
                test.setArrayMoveID("ElectroBall");
                test.setArrayLocalID("");
                fachada.cadastrarPokemon(test);
            } catch (PokemonIDHabilidadeInexistenteException | PokemonNumberInexistenteException | LocalInexistenteException | AtaqueInexistenteException | InvalidoException | PokemonExistenteException | TipoInvalidoException | PokemonNumberInvalidoException e) {
                e.printStackTrace();
            }
            //REMOVER>>

            // Pokemon Inexistente
            try {
                Pokemon test = new Pokemon(123, "Charmander", "Fogo", "Static");
                test.setArrayMoveID("Ember");
                test.setArrayLocalID("Kanto");
                fachada.removerPokemon("Pidgey");
            } catch (PokemonInexistenteException | InvalidoException e) {
                e.printStackTrace();
            }

            //PROCURAR>>

            //Pokemon Inexistente
            try {
                Pokemon test = new Pokemon(123, "Charmander", "Fogo", "Static");
                test.setArrayMoveID("Ember");
                test.setArrayLocalID("Kanto");
                fachada.atualizarPokemon(test);
            } catch (PokemonNumberInvalidoException | TipoInvalidoException | PokemonExistenteException | PokemonNumberInexistenteException | AtaqueInexistenteException | LocalInexistenteException | PokemonIDHabilidadeInexistenteException e) {
                e.printStackTrace();
            }

            //LOCAL>>

            //CADASTRAR

            //Local existente
            try {
                Local local = new Local();
                local.setName("area");
                local.setRoute(12);
                local.setCity("Pallet");
                fachada.cadastrarLocal(local);
                fachada.cadastrarLocal(local);
            } catch (InvalidoException | LocalInexistenteException | LocalRotaInvalidaException | LocalCidadeInvalidaException | LocalExistenteException e){
                e.printStackTrace();
            }

            //Local nulo
            try {
                Local local = new Local();
                local.setRoute(0);
                local.setName(null);
                local.setCity(null);
                fachada.cadastrarLocal(local);
            } catch (InvalidoException | LocalInexistenteException | LocalRotaInvalidaException | LocalCidadeInvalidaException | LocalExistenteException e){
                e.printStackTrace();
            }

            //Local sem nome
            try {
                Local local = new Local();
                local.setName
            }


        }

    }
}
