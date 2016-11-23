package data.ability;

import negocio.ability.Ability;
import interfaces.AbilityRepository;
public class AbilityRepositoryList implements AbilityRepository {

    private AbilityRepositoryList head;
    private Ability ability;

    public AbilityRepositoryList(){}

    public boolean isEmpty() {

        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean exist (Ability ability) {
        if (this.ability.equals(ability)) {
            return true;
        } else if (this.head == null){
            return false;
        } else {
            return this.head.exist(ability);
        }
    }

    public void insert (Ability ability) {
        if (this.head == null) {
            this.ability = ability;
            this.head = new AbilityRepositoryList();
        } else {
            this.head.insert(ability);
        }
    }
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
    public void update (Ability ability) {
        if (this.ability.equals(ability))
            this.ability = ability;
        else
            this.head.update(ability);

    }
    public Ability search (String name) {
        if (this.ability.getName().equals(name))
            return this.ability;
        else if (this.head == null)
            return null;
        else
            return this.head.search(name);
    }


}