package data.pokemon;

import interfaces.PokemonRepositorio;
import negocio.Pokemon;

public class PokemonRepositorioList implements PokemonRepositorio
{
    private PokemonRepositorioList node;
    private Pokemon pokemon;

    public PokemonRepositorioList()
    {
        this.node = null;
        this.pokemon = null;
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

    public void remove(int pokemon) {
        if (this.pokemon != null) {
            if (this.pokemon.getNumber() == pokemon) {
                this.pokemon = this.node.pokemon;
                this.node = this.node.node;
            } else
                this.node.remove(pokemon);
        } else
            throw new RuntimeException("Esse pokemon ainda não foi inserido");
    }

    public Pokemon search(int pokemon) {
        if (this.pokemon.getNumber() == pokemon)
            return this.pokemon;
        else if (this.node == null) {
            throw new RuntimeException("PokemonRepositorio não encontrado");
        } else
            return this.node.search(pokemon);
    }

    public void update(Pokemon pokemon) {
        if (this.pokemon.equals(pokemon))
            this.pokemon = pokemon;
        else if (this.node == null)
            throw new RuntimeException("PokemonRepositorio não encontrado");
        else
            this.node.update(pokemon);
    }

}
