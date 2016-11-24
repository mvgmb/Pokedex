package data.pokemon;

import interfaces.PokemonRepositorio;
import negocio.pokemon.Pokemon;

public class PokemonRepositorioArray implements PokemonRepositorio
{
    private Pokemon[] pokemonArray = new Pokemon[0];

    // Checa se o Pokemon existe no pokemonArray
    public boolean exist(String name) {
        for (int i = 0; i < pokemonArray.length; i++)
            if (pokemonArray[i].getName().equals(name))
                return true;
        return false;
    }

    // inserir um pokemon no pokemonArray
    public void insert(Pokemon pokemon)
    {
        Pokemon[] aux = new Pokemon[pokemonArray.length + 1];
        for (int i = 0; i < pokemonArray.length; i++)
            aux[i] = pokemonArray[i];
        aux[pokemonArray.length] = pokemon;
        pokemonArray = aux;
    }

    // remover um pokemon no pokemonArray
    public void remove(String name)
    {
        Pokemon[] aux = new Pokemon[pokemonArray.length - 1];
        for (int i = 0; i < pokemonArray.length; i++)
            if (pokemonArray[i].getName() == name)
                pokemonArray[i] = pokemonArray[pokemonArray.length - 1];
        for (int i = 0; i < (pokemonArray.length - 1); i++)
            aux[i] = pokemonArray[i];
        this.pokemonArray = aux;
    }

    // atualizar um pokemon no pokemonArray
    public void update(Pokemon pokemon)
    {
        for (int i = 0; i < pokemonArray.length; i++)
            if (pokemonArray[i].getNumber() == pokemon.getNumber())
                pokemonArray[i] = pokemon;
    }

    // procurar um pokemon no pokemonArray
    public Pokemon search(String name)
    {
        for (int i = 0; i < pokemonArray.length; i++)
            if (pokemonArray[i].getName() == name)
                return pokemonArray[i];
        return null;
    }

    //Retorna uma pokemonArray contendo os objeto Pokémons
    public Pokemon[] returnContent(){
        return this.pokemonArray;
    }
}
