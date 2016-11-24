package fachada;

import exceptions.*;
import negocio.ability.Ability;
import negocio.ability.AbilityNegocios;
import negocio.attack.Attack;
import negocio.attack.HiddenMachine;
import negocio.attack.MoveNegocios;
import negocio.local.Local;
import negocio.local.LocalNegocios;
import negocio.pokemon.Pokemon;
import negocio.pokemon.PokemonNegocios;
import negocio.trainer.Trainer;
import negocio.trainer.TrainerNegocios;
import tipo.Tipos;

import java.io.*;

/**
 * Created by mathe on 23/11/2016.
 */
public class Fachada
{
    public static final Fachada ourInstance = new Fachada();
    public boolean repInvalido = false;

    private PokemonNegocios pokemonNegocios;
    private Tipos type;
    private TrainerNegocios trainerNegocios;
    private MoveNegocios attackNegocios;
    private MoveNegocios hiddenMachineNegocios;
    private LocalNegocios localNegocios;
    private AbilityNegocios abilityNegocios;

    public Fachada()
    {
        try
        {
            File file = new File("config.txt");
            FileInputStream in = new FileInputStream(file);
            char tipo = (char) in.read();
            in.close();

            if (tipo == 'a' || tipo == 'l')
            {
                pokemonNegocios = new PokemonNegocios(tipo == 'a' ? "array" : "lista");
                trainerNegocios = new TrainerNegocios(tipo == 'a' ? "array" : "lista");
                attackNegocios = new MoveNegocios(tipo == 'a' ? "array" : "lista");
                hiddenMachineNegocios = new MoveNegocios(tipo == 'a' ? "array" : "lista");
                localNegocios = new LocalNegocios(tipo == 'a' ? "array" : "lista");
                abilityNegocios = new AbilityNegocios(tipo == 'a' ? "array" : "lista");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RepositorioInvalidoException e) {
            e.printStackTrace();
        }
    }

    //acessar o singleton
    public static Fachada getInstance() {
        return ourInstance;
    }

    //Pokémon

    public void cadastrarPokemon(Pokemon pokemon) throws PokemonIDHabilidadeInexistenteException, PokemonNumberInexistenteException, LocalInexistenteException, AtaqueInexistenteException, InvalidoException, PokemonExistenteException, TipoInvalidoException, PokemonNumberInvalidoException {
        if (pokemon != null)
        {
            if (!pokemonNegocios.exist(pokemon.getName()))
            {
                if (pokemon.existNumber())
                {
                    if (Integer.parseInt(pokemon.getNumber()) > 0)
                    {
                        if (type.exist(pokemon.getType()))
                        {
                            if (pokemon.existMove())
                            {
                                if (pokemon.existLocal())
                                {
                                    if (pokemon.existAbilityID())
                                    {
                                        pokemonNegocios.insert(pokemon);
                                    }
                                    else
                                        throw new PokemonIDHabilidadeInexistenteException();
                                }
                                else
                                    throw new LocalInexistenteException();
                            }
                            else
                                throw new AtaqueInexistenteException();
                        }
                        else
                            throw new TipoInvalidoException();
                   }
                   else
                       throw new PokemonNumberInvalidoException();
                }
                else
                    throw new PokemonNumberInexistenteException();
            }
            else
                throw new PokemonExistenteException();
        }
        else
            throw new InvalidoException();
    }

    public void atualizarPokemon(Pokemon pokemon) throws PokemonNumberInexistenteException, PokemonIDHabilidadeInexistenteException, LocalInexistenteException, AtaqueInexistenteException, InvalidoException, PokemonInexistenteException, TipoInvalidoException, PokemonExistenteException, PokemonNumberInvalidoException {
        if (pokemon != null)
        {
            if (pokemonNegocios.exist(pokemon.getName()))
            {
                if (pokemon.existNumber())
                {
                    if (Integer.parseInt(pokemon.getNumber()) > 0)
                    {
                        if (type.exist(pokemon.getType()))
                        {
                            if (pokemon.existMove())
                            {
                                if (pokemon.existLocal())
                                {
                                    if (pokemon.existAbilityID())
                                    {
                                        pokemonNegocios.update(pokemon);
                                    }
                                    else
                                        throw new PokemonIDHabilidadeInexistenteException();
                                }
                                else
                                    throw new LocalInexistenteException();
                            }
                            else
                                throw new AtaqueInexistenteException();
                        }
                        else
                            throw new TipoInvalidoException();
                    }
                    else
                        throw new PokemonNumberInvalidoException();
                }
                else
                    throw new PokemonNumberInexistenteException();
            }
            else
                throw new PokemonExistenteException();
        }
        else
            throw new InvalidoException();
    }

    public void removerPokemon(String name) throws PokemonInexistenteException, InvalidoException {
        if (name != null)
        {
            if (pokemonNegocios.exist(name))
            {
                pokemonNegocios.remove(name);
            }
            else
                throw new PokemonInexistenteException();
        }
        else
            throw new InvalidoException();
    }

    public Pokemon procurarPokemon(String name) throws InvalidoException, PokemonInexistenteException {
        if (name != null)
        {
            if (pokemonNegocios.exist(name))
            {
                return pokemonNegocios.search(name);
            }
            else
                throw new PokemonInexistenteException();
        }
        else
            throw new InvalidoException();
    }

    public Pokemon[] retornarConteudoPokemons() throws PokemonNenhumCadastradoException, InvalidoException {
        if (pokemonNegocios.returnConten() != null)
        {
            if (pokemonNegocios.returnConten().length == 0)
            {
                return pokemonNegocios.returnConten();
            }
            else
                throw new PokemonNenhumCadastradoException();
        }
        else
            throw new InvalidoException();
    }

    //Trainer

    public void cadastrarTreinador(Trainer trainer) throws InvalidoException, TrainerExistenteException, TrainerBadgeInvalidoException {
        if (trainer != null)
        {
            if (!trainerNegocios.exist(trainer.getName()))
            {
                if (trainer.getBadge() >= 0)
                {
                    trainerNegocios.insert(trainer);
                }
                else
                    throw new TrainerBadgeInvalidoException();
            }
            else
                throw new TrainerExistenteException();
        }
        else
            throw new InvalidoException();
    }

    public void atualizarTreinador(Trainer trainer) throws InvalidoException, TrainerInexistenteException, TrainerBadgeInvalidoException {
        if (trainer != null)
        {
            if (trainerNegocios.exist(trainer.getName()))
            {
                if (trainer.getBadge() >= 0)
                {
                    trainerNegocios.update(trainer);
                }
                else
                    throw new TrainerBadgeInvalidoException();
            }
            else
                throw new TrainerInexistenteException();
        }
        else
            throw new InvalidoException();
    }

    public void removerTreinador(String name) throws InvalidoException, TrainerInexistenteException {
        if (name != null)
        {
            if (trainerNegocios.exist(name))
            {
                trainerNegocios.remove(name);
            }
            else
                throw new TrainerInexistenteException();
        }
        else throw new InvalidoException();
    }

    public Trainer procurarTreinador(String name) throws InvalidoException, TrainerInexistenteException {
        if (name != null)
        {
            if (trainerNegocios.exist(name))
            {
                return trainerNegocios.search(name);
            }
            else throw new TrainerInexistenteException();
        }
        else throw new InvalidoException();
    }

    public Trainer[] retonarConteudoTreinador() throws InvalidoException, TreinadorNenhumTreinadorCadastradoException {
        if (trainerNegocios.returnContent() != null)
        {
            if (trainerNegocios.returnContent().length == 0)
            {
                return trainerNegocios.returnContent();
            }
            else
                throw new TreinadorNenhumTreinadorCadastradoException();
        }
        else
            throw new InvalidoException();
    }

    //Local

    public void cadastrarLocal(Local local) throws InvalidoException, LocalInexistenteException, LocalRotaInvalidaException, LocalCidadeInvalidaException, LocalExistenteException {
        if (local != null)
        {
            if (!localNegocios.exist(local.getName()))
            {
                if (Integer.parseInt(local.getRoute()) >= 0)
                {
                    if (local.getCity() != null)
                    {
                        localNegocios.insert(local);
                    }
                    else throw new LocalCidadeInvalidaException();
                }
                else
                    throw new LocalRotaInvalidaException();
            }
            else
                throw new LocalInexistenteException();
        }
        else
            throw new InvalidoException();
    }

    public void atualizarLocal(Local local) throws InvalidoException, LocalInexistenteException, LocalRotaInvalidaException, LocalCidadeInvalidaException {
        if (local != null)
        {
            if (localNegocios.exist(local.getName()))
            {
                if (Integer.parseInt(local.getRoute()) >= 0)
                {
                    if (local.getCity() != null)
                    {
                        localNegocios.update(local);
                    }
                    else
                        throw new LocalCidadeInvalidaException();
                }
                else
                    throw new LocalRotaInvalidaException();
            }
            else
                throw new LocalInexistenteException();
        }
        else
            throw new InvalidoException();
    }

    public void removerLocal(String name) throws InvalidoException, LocalInexistenteException {
        if (name != null)
        {
            if (localNegocios.exist(name))
            {
                localNegocios.remove(name);
            }
            else
                throw new LocalInexistenteException();
        }
        else
            throw new InvalidoException();
    }

    public Local procurarLocal(String name) throws InvalidoException, LocalInexistenteException {
        if (name != null)
        {
            if (localNegocios.exist(name))
            {
                return localNegocios.search(name);
            }
            else
                throw new LocalInexistenteException();
        }
        else
            throw new InvalidoException();
    }

    //Ability

    public void cadastrarHabilidade(Ability ability) throws InvalidoException, HabilidadeExistenteException, HabilidadeDescricaoInexistenteException {
        if (ability != null)
        {
            if (!abilityNegocios.exist(ability.getName()))
            {
                if (ability.getDescription() != null)
                {
                    abilityNegocios.insert(ability);
                }
                else
                    throw new HabilidadeDescricaoInexistenteException();
            }
            else
                throw new HabilidadeExistenteException();
        }
        else
            throw new InvalidoException();
    }

    public void atualizarHabilidade(Ability ability) throws InvalidoException, HabilidadeDescricaoInexistenteException, HabilidadeInexistenteException {
        if (ability != null)
        {
            if (abilityNegocios.exist(ability.getName()))
            {
                if(ability.getDescription() != null)
                {
                    abilityNegocios.update(ability);
                }
                else
                    throw new HabilidadeDescricaoInexistenteException();
            }
        }
        else
            throw new InvalidoException();
    }

    public void removerHabilidade(String name) throws InvalidoException, HabilidadeInexistenteException {
        if (name != null)
        {
            if (abilityNegocios.exist(name))
            {
                abilityNegocios.remove(name);
            }
            else
                throw new HabilidadeInexistenteException();
        }
        else
            throw new InvalidoException();
    }

    public Ability procurarHabilidade(String name) throws InvalidoException, HabilidadeInexistenteException {
         if (name != null)
         {
             if (abilityNegocios.exist(name))
             {
                 return abilityNegocios.search(name);
             }
             else
                 throw new HabilidadeInexistenteException();
         }
         else throw new InvalidoException();
     }

    //Attack

    public void cadastrarAtaque(Attack attack) throws InvalidoException, AtaqueExistenteException, TipoInvalidoException, AtaquePPInvalidoException, AtaqueEfeitoInvalidoException, AtaqueDanoInvalidoException {
        if (attack != null)
        {
            if (!attackNegocios.exists(attack.getName()))
            {
                if (type.exist(attack.getType()))
                {
                    if (Integer.parseInt(attack.getPP()) > 0)
                    {
                        if (attack.getEffect() != null)
                        {
                            if (Integer.parseInt(attack.getDamage()) >= 0)
                            {
                                attackNegocios.insert(attack);
                            }
                            else
                                throw new AtaqueDanoInvalidoException();
                        }
                        else
                            throw new AtaqueEfeitoInvalidoException();
                    }
                    else
                        throw new AtaquePPInvalidoException();
                }
                else
                    throw new TipoInvalidoException();
            }
            else
                throw new AtaqueExistenteException();
        }
        else
            throw new InvalidoException();
    }

    public void atualizarAtaque(Attack attack) throws InvalidoException, AtaqueExistenteException, TipoInvalidoException, AtaquePPInvalidoException, AtaqueEfeitoInvalidoException, AtaqueDanoInvalidoException, AtaqueInexistenteException {
        if (attack != null)
        {
            if (attackNegocios.exists(attack.getName()))
            {
                if (type.exist(attack.getType()))
                {
                    if (Integer.parseInt(attack.getPP()) > 0)
                    {
                        if (attack.getEffect() != null)
                        {
                            if (Integer.parseInt(attack.getDamage()) >= 0)
                            {
                                attackNegocios.update(attack);
                            }
                            else
                                throw new AtaqueDanoInvalidoException();
                        }
                        else
                            throw new AtaqueEfeitoInvalidoException();
                    }
                    else
                        throw new AtaquePPInvalidoException();
                }
                else
                    throw new TipoInvalidoException();
            }
            else
                throw new AtaqueExistenteException();
        }
        else
            throw new InvalidoException();
    }

    public void removerAtaque(String name) throws InvalidoException, AtaqueInexistenteException {
        if (name != null)
        {
            if(attackNegocios.exists(name))
            {
                attackNegocios.remove(name);
            }
            else
                throw new AtaqueInexistenteException();
        }
        else
            throw new InvalidoException();
    }

    public Attack procurarAtaque(String name) throws InvalidoException, AtaqueInexistenteException {
        if (name != null)
        {
            if (attackNegocios.exists(name))
            {
                return (Attack) attackNegocios.search(name);
            }
            else
                throw new AtaqueInexistenteException();
        }
        else
            throw new InvalidoException();
    }

    //HiddenMachine

    public void cadastrarHiddenMachine(HiddenMachine hiddenMachine) throws InvalidoException, HiddenMachineExistenteException, TipoInvalidoException, HiddenMachinePPException, HiddenMachineEfeitoInvalidoException, HiddenMachineEfeitoExteriorInvalidoException {
        if (hiddenMachine != null)
        {
            if (!hiddenMachineNegocios.exists(hiddenMachine.getName()))
            {
                if (type.exist(hiddenMachine.getType()))
                {
                    if (Integer.parseInt(hiddenMachine.getPP()) > 0)
                    {
                        if (hiddenMachine.getEffect() != null)
                        {
                            if (hiddenMachine.getOutEffect() != null)
                            {
                                hiddenMachineNegocios.insert(hiddenMachine);
                            }
                            else
                                throw new HiddenMachineEfeitoExteriorInvalidoException();
                        }
                        else
                            throw new HiddenMachineEfeitoInvalidoException();
                    }
                    else
                        throw new HiddenMachinePPException();
                }
                else
                    throw new TipoInvalidoException();
            }
            else
                throw new  HiddenMachineExistenteException();
        }
        else
            throw new InvalidoException();
    }

    public void atualizarHiddenMachine(HiddenMachine hiddenMachine) throws InvalidoException, HiddenMachineExistenteException, TipoInvalidoException, HiddenMachinePPException, HiddenMachineEfeitoInvalidoException, HiddenMachineEfeitoExteriorInvalidoException, HiddenMachineInexistenteException {
        if (hiddenMachine != null)
        {
            if (hiddenMachineNegocios.exists(hiddenMachine.getName()))
            {
                if (type.exist(hiddenMachine.getType()))
                {
                    if (Integer.parseInt(hiddenMachine.getPP()) > 0)
                    {
                        if (hiddenMachine.getEffect() != null)
                        {
                            if (hiddenMachine.getOutEffect() != null)
                            {
                                hiddenMachineNegocios.update(hiddenMachine);
                            }
                            else
                                throw new HiddenMachineEfeitoExteriorInvalidoException();
                        }
                        else
                            throw new HiddenMachineEfeitoInvalidoException();
                    }
                    else
                        throw new HiddenMachinePPException();
                }
                else
                    throw new TipoInvalidoException();
            }
            else
                throw new  HiddenMachineInexistenteException();
        }
        else
            throw new InvalidoException();
    }

    public void removerHiddenMachine(String name) throws InvalidoException, HiddenMachineInexistenteException {
        if (name != null)
        {
            if (hiddenMachineNegocios.exists(name))
            {
                hiddenMachineNegocios.remove(name);
            }
            else
                throw new HiddenMachineInexistenteException();
        }
        else
            throw new InvalidoException();
    }

    public HiddenMachine procurarHiddenMachine(String name) throws InvalidoException, HiddenMachineInexistenteException {
        if (name != null)
        {
            if (hiddenMachineNegocios.exists(name))
            {
                return (HiddenMachine) hiddenMachineNegocios.search(name);
            }
            else
                throw new HiddenMachineInexistenteException();
        }
        else
            throw new InvalidoException();
    }
}
