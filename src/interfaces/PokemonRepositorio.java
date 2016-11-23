package interfaces;

import negocio.pokemon.Pokemon;

public interface PokemonRepositorio {
    void insert(Pokemon pokemon);

    void remove(Pokemon pokemon);

    Pokemon search(Pokemon pokemon);

    void update(Pokemon pokemon);

    boolean exist(Pokemon pokemon);
}
