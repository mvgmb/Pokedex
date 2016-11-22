package interfaces;

import negocio.pokemon.Pokemon;

public interface PokemonRepositorio {
    public void insert(Pokemon pokemon);

    public void remove(Pokemon pokemon);

    public Pokemon search(Pokemon pokemon);

    public void update(Pokemon pokemon);

    public boolean exist(Pokemon pokemon);
}
