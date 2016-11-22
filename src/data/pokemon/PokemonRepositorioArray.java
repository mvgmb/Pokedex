package data.pokemon;
import classesprimarias.*;
public class PokemonRepositorioArray
{
    private Pokemon[] array = new Pokemon[0];

    public void insert(Pokemon pokemon)
    {
        Pokemon[] aux = new Pokemon[array.length + 1];
        for (int i = 0; i < array.length; i++)
            aux[i] = array[i];
        aux[array.length] = pokemon;
        array = aux;
    }

    public void remove(Pokemon number)
    {
        Pokemon[] aux = new Pokemon[array.length - 1];
        for (int i = 0; i < array.length; i++)
            if (array[i].getNumber() == number.getNumber())
                array[i] = array[array.length - 1];
        for (int i = 0; i < (array.length - 1); i++)
            aux[i] = array[i];
        this.array = aux;
    }

    public void update(Pokemon pokemon)
    {
        for (int i = 0; i < array.length; i++)
            if (array[i].getNumber() == pokemon.getNumber())
            {
                array[i] = pokemon;
                return;
            }
    }
    public Pokemon search(Pokemon pokemon)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i].getNumber() == pokemon.getNumber())
                return array[i];
        }
        return null;
    }
    public boolean findet(Pokemon pokemon)
    {
        return search(pokemon) != null;
    }

}
