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

    public PokemonNegocios(String tipo){
        if (tipo.equals("array"))
            pokemonRepositorio = new PokemonRepositorioArray();
        else if (tipo.equals("lista"))
            pokemonRepositorio = new PokemonRepositorioList();
    }

    public boolean exist(String name) {
        return pokemonRepositorio.exist(name);
    }

    public void insert(Pokemon pokemon) {
            pokemonRepositorio.insert(pokemon);
    }

    public void remove(String name) {
            pokemonRepositorio.remove(name);
    }

    public Pokemon search(String name) {
           return pokemonRepositorio.search(name);
    }

    public void update(Pokemon pokemon){
        pokemonRepositorio.update(pokemon);
    }

    public Pokemon[] returnConten(){
        return pokemonRepositorio.returnContent();
    }

}
