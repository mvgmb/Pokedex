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

    public boolean exist(Pokemon pokemon) {
        return pokemonRepositorio.exist(pokemon);
    }

    public void insert(Pokemon pokemon) throws PokemonExistenteException, TipoInvalidoException {
        if (!arrayTipos.exist(pokemon.getType())) {
            throw new TipoInvalidoException();
        } else if (!exist(pokemon))
            pokemonRepositorio.insert(pokemon);
        else
            throw new PokemonExistenteException();
    }

    public void remove(Pokemon pokemon) throws PokemonInexistenteException
    {
        if (!exist(pokemon))
            pokemonRepositorio.remove(pokemon);
        else
            throw new PokemonInexistenteException();
    }

    public Pokemon search(Pokemon pokemon) throws PokemonInexistenteException
    {
        if (!exist(pokemon))
           return pokemonRepositorio.search(pokemon);
        else
            throw new PokemonInexistenteException();
    }

    public void update(Pokemon pokemon) throws PokemonInexistenteException
    {
        if (!exist(pokemon))
            pokemonRepositorio.update(pokemon);
        else
            throw new PokemonInexistenteException();
    }
}
