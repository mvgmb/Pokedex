package data.pokemon;

import interfaces.PokemonRepositorio;
import negocio.pokemon.Pokemon;

public class PokemonRepositorioArray implements PokemonRepositorio
{
    private Pokemon[] array = new Pokemon[0];

    public boolean exist(String name) {
        for (int i = 0; i < array.length; i++)
            if (array[i].getName().equals(name))
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
    public void remove(String name)
    {
        Pokemon[] aux = new Pokemon[array.length - 1];
        for (int i = 0; i < array.length; i++)
            if (array[i].getName() == name)
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
    public Pokemon search(String name)
    {
        for (int i = 0; i < array.length; i++)
            if (array[i].getName() == name)
                return array[i];
        return null;
    }
}
