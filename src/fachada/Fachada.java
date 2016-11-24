package fachada;

import exceptions.*;
import negocio.ability.Ability;
import negocio.ability.AbilityNegocios;
import negocio.attack.MoveNegocios;
import negocio.local.Local;
import negocio.local.LocalNegocios;
import negocio.pokemon.Pokemon;
import negocio.pokemon.PokemonNegocios;
import negocio.trainer.Trainer;
import negocio.trainer.TrainerNegocios;
import tipo.Tipos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.IncompleteAnnotationException;

/**
 * Created by mathe on 23/11/2016.
 */
public class Fachada
{
    private static final Fachada ourInstance = new Fachada();
    public boolean repInvalido = false;

    private PokemonNegocios pokemonNegocios;
    private Tipos type;
    private TrainerNegocios trainerNegocios;
    private MoveNegocios moveNegocios;
    private LocalNegocios localNegocios;
    private AbilityNegocios abilityNegocios;

    private Fachada()
    {
        try
        {
            BufferedReader in = new BufferedReader(new FileReader("config.txt"));
            String tipo = in.readLine();

            if (tipo.equals("array") || tipo.equals("lista"))
            {
                pokemonNegocios = new PokemonNegocios(tipo);
                trainerNegocios = new TrainerNegocios(tipo);
                moveNegocios = new MoveNegocios(tipo);
                localNegocios = new LocalNegocios(tipo);
                abilityNegocios = new AbilityNegocios(tipo);
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

    public void cadastrarPokemon(Pokemon pokemon) throws PokemonIDHabilidadeInexistenteException, PokemonNumberInexistenteException, LocalInexistenteException, AttackInexistenteException, InvalidoException, PokemonExistenteException, TipoInvalidoException, PokemonNumberInvalidoException {
        if (pokemon != null)
        {
                if (!pokemonNegocios.exist(pokemon.getName()))
            {
                if (pokemon.existNumber())
                {
                    if (pokemon.getNumber() > 0)
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
                                throw new AttackInexistenteException();
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

    public void atualizarPokemon(Pokemon pokemon) throws PokemonNumberInexistenteException, PokemonIDHabilidadeInexistenteException, LocalInexistenteException, AttackInexistenteException, InvalidoException, PokemonInexistenteException, TipoInvalidoException, PokemonExistenteException, PokemonNumberInvalidoException {
        if (pokemon != null)
        {
            if (pokemonNegocios.exist(pokemon.getName()))
            {
                if (pokemon.existNumber())
                {
                    if (pokemon.getNumber() > 0)
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
                                throw new AttackInexistenteException();
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

    public Trainer procurar(String name) throws InvalidoException, TrainerInexistenteException {
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

    //Local

    public void cadastrarLocal(Local local) throws InvalidoException, LocalInexistenteException, LocalRotaInvalidaException, LocalCidadeInvalidaException, LocalExistenteException {
        if (local != null)
        {
            if (!localNegocios.exist(local.getName()))
            {
                if (local.getRoute() >= 0)
                {
                    if (!local.getCity().equals(null))
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
                if (local.getRoute() >= 0)
                {
                    if (!local.getCity().equals(null))
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
                if (!ability.getDescription().equals(null))
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
                if(!ability.getDescription().equals(null))
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
}
