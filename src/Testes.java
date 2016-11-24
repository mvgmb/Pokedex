import exceptions.*;
import negocio.attack.Attack;
import negocio.attack.HiddenMachine;
import negocio.pokemon.Pokemon;
import fachada.Fachada;
import negocio.local.Local;
import negocio.trainer.Trainer;
import negocio.ability.Ability;

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
                test.setArrayLocalID("Kanto");
                fachada.cadastrarPokemon(test);
            } catch (AtaqueInexistenteException | TipoInvalidoException | LocalInexistenteException | PokemonExistenteException | InvalidoException | PokemonNumberInexistenteException | PokemonIDHabilidadeInexistenteException | PokemonNumberInvalidoException e) {
                e.printStackTrace();
            }
            //Local nulo
            try {
                Pokemon test = new Pokemon(123, "Pikachu", "Eletrico", "Static");
                test.setArrayMoveID("ElectroBall");
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

            //Local com rota inválida
            try {
                Local local = new Local();
                local.setName("area");
                local.setRoute(-3);
                Local.setCity("Pallet");
                fachada.cadastrarLocal(local);
            } catch (LocalCidadeInvalidaException | LocalRotaInvalidaException | LocalInexistenteException | LocalExistenteException e) {
                e.printStackTrace();
            }

            //Local nulo
            try {
                Local local = null;
                fachada.cadastrarLocal(local);
            } catch (InvalidoException | LocalInexistenteException | LocalRotaInvalidaException | LocalCidadeInvalidaException | LocalExistenteException e){
                e.printStackTrace();
            }

            //REMOVER
            //Local inexistente
            try {
                Local local = new Local();
                local.setName("area");
                local.setRoute(12);
                local.setCity("Pallet");
                fachada.cadastrarLocal(local);
                fachada.removerLocal("canto");
            } catch (InvalidoException | LocalInexistenteException | LocalCidadeInvalidaException | LocalRotaInvalidaException | LocalExistenteException e){
                e.printStackTrace();
            }

            //PROCURAR
            //Local inexistente
            try {
                Local local = new Local();
                local.setName("area");
                local.setRoute(12);
                local.setCity("Pallet");
                fachada.removerLocal("canto");
            } catch (InvalidoException | LocalInexistenteException e){
                e.printStackTrace();
            }


            //<<TRAINER>>
            //CADASTRAR
            //Treinador já existente
            try {
                Trainer trainer = new Trainer("teacher", 5);
                fachada.cadastrarTreinador(trainer);
                fachada.cadastrarTreinador(trainer);
            } catch (TrainerBadgeInvalidoException | TrainerExistenteException e) {
                e.printStackTrace();
            }

            //Treinador nulo
            try {
                Trainer trainer = null;
                fachada.cadastrarTreinador(trainer);
            } catch (TrainerBadgeInvalidoException | TrainerExistenteException e) {
                e.printStackTrace();
            }

            //Número de badges inválido
            try {
                Trainer trainer = new Trainer("teacher", -3);
                fachada.cadastrarTreinador(trainer);
            } catch (TrainerBadgeInvalidoException | TrainerExistenteException e) {
                e.printStackTrace();
            }

        }
            //REMOVER
            //Treinador inexistente
            try {
                Trainer trainer = new Trainer ("teacher", 5);
                fachada.removerTreinador("mario");
            } catch (TrainerInexistenteException e) {
                e.printStackTrace();
            }

            //PROCURAR
            //Treinador inexistente
            try {
                Trainer trainer = new Trainer ("teacher", 5);
                fachada.procurarTreinador("mario");
            } catch (TrainerInexistenteException e) {
                e.printStackTrace();
            }

            //<<ABILITY>>
            //CADASTRAR
            //Habilidade já existente
            try {
                Ability ability = new Ability ("Fly", "voa");
                fachada.cadastrarHabilidade(ability);
                fachada.cadastrarHabilidade(ability);
            } catch (HabilidadeDescricaoInexistenteException | HabilidadeExistenteException e) {
                e.printStackTrace();
            }

            //Habilidade nula
            try {
                Ability ability = null;
                fachada.cadastrarHabilidade(ability);
            } catch (HabilidadeDescricaoInexistenteException | HabilidadeExistenteException e) {
                e.printStackTrace();
            }

            //REMOVER
            //Remover habilidade inexistente
            try {
                Ability ability = new Ability("Fly", "voa");
                fachada.removerHabilidade("Run");
            } catch (HabilidadeInexistenteException e) {
                e.printStackTrace();
            }

            //PROCURAR
            //Procurar habilidade inexistente
            try{
                Ability ability = new Ability("Fly","voa");
                fachada.procurarHabilidade("Run");
            } catch (HabilidadeInexistenteException e) {
                e.printStackTrace();
            }


            //HIDDENMACHINE
            //REMOVER
            //Remover HiddenMachine inexistente
            try {
                HiddenMachine hiddenMachine = new HiddenMachine();
                hiddenMachine.setName("cut");
                hiddenMachine.setEffect("corta");
                hiddenMachine.setOutEffect("sangra");
                hiddenMachine.setPP(3);
                fachada.removerHiddenMachine(hiddenMachine);
            } catch (HiddenMachineInexistenteException e) {
                e.printStackTrace();
            }

            //PROCURAR
            //Procurar HiddenMachine inexistente
            try {
                HiddenMachine hiddenMachine = new HiddenMachine();
                fachada.procurarHiddenMachine("escondida");
            } catch (HiddenMachineInexistenteException e) {
                e.printStackTrace();
            }

            //CADASTRAR HIDDEN MACHINE nula
            try {
            HiddenMachine hm = null;
            fachada.cadastrarHiddenMachine(hm);
        } catch (HiddenMachineEfeitoExteriorInvalidoException | HiddenMachineEfeitoInvalidoException | HiddenMachineExistenteException | TipoInvalidoException | HiddenMachinePPException e) {
            e.printStackTrace();
        }

            //CADASTRAR ATTACK nulo
        try {
            Attack attack = null;
            fachada.cadastrarAtaque(attack);
        } catch (AtaquePPInvalidoException | AtaqueDanoInvalidoException | AtaqueEfeitoInvalidoException | AtaqueExistenteException | TipoInvalidoException e) {
            e.printStackTrace();
        }

            //CADASTRAR HIDDENMACHINE JA EXISTENTE
        try {
            HiddenMachine hm1 = new HiddenMachine("name", "fogo", 1, "ousideeffect", "effect");
            HiddenMachine hm2 = hm1;
            fachada.cadastrarHiddenMachine(hm1);
            fachada.cadastrarHiddenMachine(hm2);
        } catch (HiddenMachineEfeitoExteriorInvalidoException | HiddenMachineEfeitoInvalidoException | HiddenMachineExistenteException | TipoInvalidoException | HiddenMachinePPException e) {
            e.printStackTrace();
        }

            //CADASTRAR ATTACK JA EXISTENTE
        try {
            Attack attack = new Attack("name", "fogo", 1, 2, "effect");
            Attack attack1 = attack;
            fachada.cadastrarAtaque(attack);
            fachada.cadastrarAtaque(attack1);
        } catch (AtaquePPInvalidoException | AtaqueExistenteException | AtaqueEfeitoInvalidoException | TipoInvalidoException | AtaqueDanoInvalidoException e) {
            e.printStackTrace();
        }

            //Cadastrar hiddenmachine tipo inválido
        try {
            HiddenMachine hm1 = new HiddenMachine("name", "dorgado", 1, "ousideeffect", "effect");
            fachada.cadastrarHiddenMachine(hm1);
        } catch (HiddenMachineEfeitoExteriorInvalidoException | HiddenMachineEfeitoInvalidoException | HiddenMachineExistenteException | TipoInvalidoException e) {
            e.printStackTrace();
        } catch (HiddenMachinePPException e) {
            e.printStackTrace();
        }

            //Cadastrar ataque inválido
        try {
            Attack attack = new Attack("name", "dorgado", 1, 21, "effect");
            fachada.cadastrarAtaque(attack);
        } catch (AtaquePPInvalidoException | AtaqueDanoInvalidoException | AtaqueEfeitoInvalidoException | AtaqueExistenteException | TipoInvalidoException e) {
            e.printStackTrace();
        }

            //Cadastrar PP inválido
        try {
            HiddenMachine hm1 = new HiddenMachine("name", "dorgado", -1, "ousideeffect", "effect");
            fachada.cadastrarHiddenMachine(hm1);
        } catch (HiddenMachineEfeitoExteriorInvalidoException | HiddenMachineEfeitoInvalidoException | HiddenMachineExistenteException | HiddenMachinePPException | TipoInvalidoException e) {
            e.printStackTrace();
        }

            //Cadastrar PP inválido
        try {
            Attack attack = new Attack("name", "fogo", -1, 21, "effect");
            fachada.cadastrarAtaque(attack);
        } catch (AtaquePPInvalidoException | AtaqueDanoInvalidoException | AtaqueEfeitoInvalidoException | AtaqueExistenteException e) {
            e.printStackTrace();
        } catch (TipoInvalidoException e) {
            e.printStackTrace();
        }
            //Cadastrar efeito inválido
        try {
            HiddenMachine hm1 = new HiddenMachine("name", "fogo", 2, "ousideeffect", null);
            fachada.cadastrarHiddenMachine(hm1);
        } catch (HiddenMachineEfeitoExteriorInvalidoException | HiddenMachineEfeitoInvalidoException | HiddenMachineExistenteException | TipoInvalidoException | HiddenMachinePPException e) {
            e.printStackTrace();
        }
            //Cadastrar efeito inválido
        try {
            Attack attack = new Attack("name", "fogo", 2, 12, null);
            fachada.cadastrarAtaque(attack);
        } catch (AtaquePPInvalidoException e) {
            e.printStackTrace();
        } catch (AtaqueDanoInvalidoException e) {
            e.printStackTrace();
        } catch (TipoInvalidoException e) {
            e.printStackTrace();
        } catch (AtaqueEfeitoInvalidoException e) {
            e.printStackTrace();
        } catch (AtaqueExistenteException e) {
            e.printStackTrace();
        }
            //Cadastrar efeito exterior inválido
        try{
            HiddenMachine hm1 = new HiddenMachine("name", "fogo", 2, null, "effect");
            fachada.cadastrarHiddenMachine(hm1);
        } catch (HiddenMachineEfeitoExteriorInvalidoException e) {
            e.printStackTrace();
        } catch (HiddenMachineEfeitoInvalidoException e) {
            e.printStackTrace();
        } catch (TipoInvalidoException e) {
            e.printStackTrace();
        } catch (HiddenMachineExistenteException e) {
            e.printStackTrace();
        } catch (HiddenMachinePPException e) {
            e.printStackTrace();
        }
            //Cadastrar dano inválido
        try{
            Attack attack = new Attack("name", "fogo", 2, -1, "effect");
            fachada.cadastrarAtaque(attack);
        } catch (AtaquePPInvalidoException e) {
            e.printStackTrace();
        } catch (AtaqueDanoInvalidoException e) {
            e.printStackTrace();
        } catch (TipoInvalidoException e) {
            e.printStackTrace();
        } catch (AtaqueEfeitoInvalidoException e) {
            e.printStackTrace();
        } catch (AtaqueExistenteException e) {
            e.printStackTrace();
        }

    }
}
