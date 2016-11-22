package data.pokemon;
import negocio.*;
public class PokemonRepositorioList
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

}
