package fachada;

import exceptions.*;
import negocio.ability.AbilityNegocios;
import negocio.attack.MoveNegocios;
import negocio.local.LocalNegocios;
import negocio.pokemon.Pokemon;
import negocio.pokemon.PokemonNegocios;
import negocio.trainer.TrainerNegocios;
import tipo.Tipos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

    public void cadastrarPokemon(Pokemon pokemon) throws PokemonIDHabilidadeInexistenteException, PokemonNumberInexistenteException, LocalInexistenteException,AttackInexistenteException,InvalidoException, PokemonExistenteException, TipoInvalidoException {
        if (pokemon != null)
        {
                if (!pokemonNegocios.exist(pokemon))
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
                       throw new PokemonNumberInvalidoException;
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

    public void atualizar(Pokemon pokemon) throws PokemonNumberInexistenteException, PokemonIDHabilidadeInexistenteException, LocalInexistenteException, AttackInexistenteException, InvalidoException, PokemonInexistenteException, TipoInvalidoException, PokemonExistenteException {
        if (pokemon != null)
        {
            if (pokemonNegocios.exist(pokemon))
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
                        throw new PokemonNumberInvalidoException;
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
    public void remove(String name) throws PokemonNumberInexistenteException, PokemonIDHabilidadeInexistenteException, LocalInexistenteException, AttackInexistenteException, InvalidoException, PokemonInexistenteException, TipoInvalidoException, PokemonExistenteException {
        if (name != null)
        {
            if (pokemonNegocios.exist(name))
            {
                pokemonNegocios.remove(name);
            }
            else
                throw new PokemonExistenteException();
        }
        else
            throw new InvalidoException();
    }



}
