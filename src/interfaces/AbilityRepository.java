package interfaces;

import negocio.ability.Ability;
public interface AbilityRepository {
    //Inseri uma habilidade
    void insert (Ability ability);
    //Remove uma habilidade
    void remove (String name);
    //Atualiza uma habilidade
    void update (Ability ability);
    //Procura uma habilidade
    Ability search (String name);
}