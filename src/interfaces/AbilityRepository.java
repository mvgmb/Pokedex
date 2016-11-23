package interfaces;

import negocio.ability.Ability;
public interface AbilityRepository {
    //Inseri uma habilidade
    public void insert (Ability ability);
    //Remove uma habilidade
    public void remove (String name);
    //Atualiza uma habilidade
    public void update (String name, String newDescription);
    //Procura uma habilidade
    public Ability search (String name);
}