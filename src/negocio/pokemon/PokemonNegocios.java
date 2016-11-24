package negocio.pokemon;

import data.pokemon.PokemonRepositorioArray;
import data.pokemon.PokemonRepositorioList;
import exceptions.PokemonExistenteException;
import exceptions.PokemonInexistenteException;
import exceptions.RepositorioInvalidoException;
import exceptions.TipoInvalidoException;
import interfaces.PokemonRepositorio;
import tipo.Tipos;

/**
 * Created by mathe on 22/11/2016.
 */
public class PokemonNegocios {
    private PokemonRepositorio pokemonRepositorio;
    private Tipos arrayTipos;

    public PokemonNegocios(String tipo) throws RepositorioInvalidoException {
        if (tipo.equals("array"))
            pokemonRepositorio = new PokemonRepositorioArray();
        else if (tipo.equals("lista"))
            pokemonRepositorio = new PokemonRepositorioList();
        else
            throw new RepositorioInvalidoException();
    }

    public boolean exist(String name) {
        return pokemonRepositorio.exist(name);
    }

    public void insert(Pokemon pokemon) throws PokemonExistenteException, TipoInvalidoException {
        if (!arrayTipos.exist(pokemon.getName())) {
            throw new TipoInvalidoException();
        } else if (!exist(pokemon.getName()))
            pokemonRepositorio.insert(pokemon);
        else
            throw new PokemonExistenteException();
    }

    public void remove(String name) throws PokemonInexistenteException
    {
        if (exist(name))
            pokemonRepositorio.remove(name);
        else
            throw new PokemonInexistenteException();
    }

    public Pokemon search(String name) throws PokemonInexistenteException
    {
        if (exist(name))
           return pokemonRepositorio.search(name);
        else
            throw new PokemonInexistenteException();
    }

    public void update(Pokemon pokemon) throws PokemonInexistenteException
    {
        if (exist(pokemon.getName()))
            pokemonRepositorio.update(pokemon);
        else
            throw new PokemonInexistenteException();
    }
}
