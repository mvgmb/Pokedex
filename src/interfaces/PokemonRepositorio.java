package interfaces;

import negocio.pokemon.Pokemon;

public interface PokemonRepositorio {
    void insert(Pokemon pokemon);

    void remove(String name);

    Pokemon search(String name);

    void update(Pokemon pokemon);

    boolean exist(String name);

    Pokemon[] returnContent();
}
