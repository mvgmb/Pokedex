package data.ability;

import negocio.ability.Ability;
import interfaces.AbilityRepository;
public class AbilityRepositoryList implements AbilityRepository {

    private AbilityRepositoryList head;
    private Ability ability;
    public AbilityRepositoryList(){}

    //Checa se a lista esta vazia
    public boolean isEmpty() {

        if (head == null) {
            return true;
        } else {
            return false;
        }
    }
    //Checa se a hablidade existe na lista
    public boolean exist (String name) {
        if (this.ability.getName().equals(name)) {
            return true;
        } else if (this.head == null){
            return false;
        } else {
            return this.head.exist(name);
        }
    }
    //Inseri uma habilidade na lista
    public void insert (Ability ability) {
        if (this.head == null) {
            this.ability = ability;
            this.head = new AbilityRepositoryList();
        } else {
            this.head.insert(ability);
        }
    }
    //Remove uma habilidade da lista
    public void remove (String name) {
        if (this.ability != null){
            if (this.ability.equals(name)){
                this.ability = this.head.ability;
                this.head = this.head.head;
            }
            else
                this.head.remove(name);
        }
    }
    //Atualiza uma habilidade na lista
    public void update (Ability ability) {
        if (this.ability.equals(ability))
            this.ability = ability;
        else
            this.head.update(ability);

    }
    //Procura por uma habilidade na lista
    public Ability search (String name) {
        if (this.ability.getName().equals(name))
            return this.ability;
        else if (this.head == null)
            return null;
        else
            return this.head.search(name);
    }


}