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

    // Checa se o pokemon existe na lista
    public boolean exist(String name) {
        if (this.pokemon.getName().equals(name))
            return true;
        else if (this.node == null)
            return false;
        else
            return this.node.exist(name);
    }

    // Inseri um pokemon na lista
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

    // Remove um pokemon da lista
    public void remove(String name) {
        if (this.pokemon != null) {
            if (this.pokemon.getName().equals(name)) {
                this.pokemon = this.node.pokemon;
                this.node = this.node.node;
            } else
                this.node.remove(name);
        }
    }

    // Procura um pokemon na lista
    public Pokemon search(String name) {
        if (this.pokemon.getName().equals(name))
            return this.pokemon;
        else if (this.node == null) {
            return null;
        } else
            return this.node.search(name    );
    }

    // Atualiza um pokemon na lista
    public void update(Pokemon pokemon) {
        if (this.pokemon.equals(pokemon))
            this.pokemon = pokemon;
        else
            this.node.update(pokemon);
    }

    //Retorna uma array com os objetos Pokémons
    public Pokemon[] returnContent(){
        if (this.node == null){
            Pokemon[] aux = new Pokemon[1];
            aux[0] = this.pokemon;
            return aux;
        }
        else{
            Pokemon[] aux = new Pokemon[returnContent().length+1];
            aux[0] = this.pokemon;
            for (int i = 1; i < aux.length; i++){
                aux[i] = returnContent()[i];
            }
            return aux;
        }
    }

}
