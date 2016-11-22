package interfaces;

import negocio.Pokemon;

public interface PokemonRepositorio {
    public void insert(Pokemon pokemon);

    public void remove(int pokemon);

    public Pokemon search(int pokemon);

    public void update(Pokemon pokemon);

    public boolean exist(Pokemon pokemon);
}
