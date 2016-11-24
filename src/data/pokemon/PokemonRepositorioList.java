package data.pokemon;

import interfaces.PokemonRepositorio;
import negocio.pokemon.Pokemon;
public class PokemonRepositorioList implements PokemonRepositorio
{
    private PokemonRepositorioList node;
    private Pokemon pokemon;

    public PokemonRepositorioList()
    {
        this.node = null;
        this.pokemon = null;
    }

    public boolean exist(String name) {
        if (this.pokemon.getName().equals(name))
            return true;
        else if (this.node == null)
            return false;
        else
            return this.node.exist(name);
    }

    public void insert(Pokemon pokemon)
    {
        if (this.node == null)
        {
            this.pokemon = pokemon;
            this.node = new PokemonRepositorioList();
        }
        else
            this.node.insert(pokemon);
    }

    public void remove(String name) {
        if (this.pokemon != null) {
            if (this.pokemon.getName().equals(name)) {
                this.pokemon = this.node.pokemon;
                this.node = this.node.node;
            } else
                this.node.remove(name);
        }
    }

    public Pokemon search(String name) {
        if (this.pokemon.getName().equals(name))
            return this.pokemon;
        else if (this.node == null) {
            return null;
        } else
            return this.node.search(name    );
    }

    public void update(Pokemon pokemon) {
        if (this.pokemon.equals(pokemon))
            this.pokemon = pokemon;
        else
            this.node.update(pokemon);
    }

}
