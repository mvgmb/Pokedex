package data.ability;

import interfaces.AbilityRepository;
import negocio.ability.Ability;
public class AbilityRepositoryArray implements AbilityRepository{

    private Ability[] abilityArray = new Ability [0];

    //Checa se a habilidade existe no abilityArray
    public boolean exist (String name) {
        for (int contador = 0; contador < abilityArray.length; contador ++) {
            if (name.equals(abilityArray[contador].getName())) {
                return true;
            }
        } return false;
    }
    //Insere uma nova habilidade no abilityArray
    public void insert (Ability ability) {
        Ability [] array = new Ability[this.abilityArray.length + 1];
        for (int contador = 0; contador < this.abilityArray.length; contador ++) {
            array [contador] = abilityArray [contador];
        }
        array[abilityArray.length] = ability;
        abilityArray = array;
    }
    //Remove uma habilidade do abilityArray
    public void remove (String name) {
        Ability [] array = new Ability[this.abilityArray.length + 1];
        for (int contador = 0; contador < abilityArray.length; contador ++) {
            if (name.equals(abilityArray[contador].getName())) {
                abilityArray[contador] = abilityArray[this.abilityArray.length - 1];
            }
        }
        for (int contador = 0; contador < abilityArray.length - 1; contador ++) {
            array[contador] = abilityArray[contador];
        }
        this.abilityArray = array;
    }
    //Procura por uma habilidade no abilityArray
    public Ability search (String name) {
        for (int contador = 0; contador < this.abilityArray.length; contador ++)  {

            if (name.equals(abilityArray[contador].getName())) {
                return abilityArray[contador];
            }
        }
        return null;
    }
    //Atualiza a descricao de uma habilidade no abilityArray
    public void update (Ability ability) {
        for (int contador = 0; contador < this.abilityArray.length; contador ++) {

            if (ability.getName().equals(abilityArray[contador].getName())) {
                abilityArray[contador] = ability;
            }
        }
    }
}