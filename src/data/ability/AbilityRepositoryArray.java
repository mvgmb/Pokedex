package data.ability;

import interfaces.AbilityRepository;
import negocio.ability.Ability;
public class AbilityRepositoryArray implements AbilityRepository{

    private Ability[] abilityArray = new Ability [0];

    public void insert (Ability ability) {
        //Inseri uma nova habilidade no abilityArray
        Ability [] array = new Ability[this.abilityArray.length + 1];
        for (int contador = 0; contador < this.abilityArray.length; contador ++) {
            array [contador] = abilityArray [contador];
        }
        array[abilityArray.length + 1] = ability;
        abilityArray = array;
    }

    public void remove (String name) {
        //Remove uma habilidade do abilityArray
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

    public Ability search (String name) {
        //Procura por uma habilidade no abilityArray
        for (int contador = 0; contador < this.abilityArray.length; contador ++)  {

            if (name.equals(abilityArray[contador].getName())) {
                return abilityArray[contador];
            }
        }
        return null;
    }
    public void update (Ability ability) {
        //Atualiza a descricao de uma habilidade no abilityArray
        for (int contador = 0; contador < this.abilityArray.length; contador ++) {

            if (ability.getName().equals(abilityArray[contador].getName())) {
                abilityArray[contador] = ability;
            }
        }
    }
}