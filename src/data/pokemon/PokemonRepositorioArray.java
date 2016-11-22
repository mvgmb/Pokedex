package data.pokemon;

import interfaces.PokemonRepositorio;
import negocio.Pokemon;

public class PokemonRepositorioArray implements PokemonRepositorio
{
    private Pokemon[] array = new Pokemon[0];

    public boolean exist(Pokemon pokemon) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == pokemon)
                return true;
        return false;
    }

    // inserir um pokemon no array
    public void insert(Pokemon pokemon)
    {
        Pokemon[] aux = new Pokemon[array.length + 1];
        for (int i = 0; i < array.length; i++)
            aux[i] = array[i];
        aux[array.length] = pokemon;
        array = aux;
    }

    // remover um pokemon no array
    public void remove(int number)
    {
        Pokemon[] aux = new Pokemon[array.length - 1];
        for (int i = 0; i < array.length; i++)
            if (array[i].getNumber() == number)
                array[i] = array[array.length - 1];
        for (int i = 0; i < (array.length - 1); i++)
            aux[i] = array[i];
        this.array = aux;
    }

    // atualizar um pokemon no array
    public void update(Pokemon pokemon)
    {
        for (int i = 0; i < array.length; i++)
            if (array[i].getNumber() == pokemon.getNumber())
                array[i] = pokemon;
    }

    // procurar um pokemon no array
    public Pokemon search(int pokemon)
    {
        for (int i = 0; i < array.length; i++)
            if (array[i].getNumber() == pokemon)
                return array[i];
        return null;
    }
}
