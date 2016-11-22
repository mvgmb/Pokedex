package data.trainer;

import interfaces.TrainerRepository;
import negocio.Trainer;

/**
 * Created by mario on 21/11/16.
 */
public class TrainerRepositoryArray implements TrainerRepository{
    private Trainer[] trainerArray = new Trainer[0];

    //  Insere um novo coach na array
    public void insert(Trainer coach) {
        Trainer[] aux = new Trainer[this.trainerArray.length + 1];
        for (int i = 0; i < this.trainerArray.length; i++) {
            aux[i] = this.trainerArray[i];
        }
        aux[this.trainerArray.length + 1] = coach;
        this.trainerArray = aux;
    }

    //  Metodo auxiliar de Procurar, checa se o nome existe
    public boolean exist(String name) {
        for (int i = 0; i < this.trainerArray.length; i++) {
            if (name.equals(this.trainerArray[i].getName()))
                return true;
        }
        return false;
    }

    //  Procura se o coach existe, caso exista, retorna a quantidade de badges
    public Trainer search(String name) {
        for (int i = 0; i < trainerArray.length; i++) {
            if (exist(name)) {
                return trainerArray[i];
            }
        }
        return null;
    }

    //  Atualiza a quatidade de badges de um treinador, caso ele exista
    public void update(Trainer trainer) {
        if (exist(trainer.getName())) {
            for (int i = 0; i < trainerArray.length; i++) {
                if (trainer.getName().equals(trainerArray[i].getName()))
                    trainerArray[i].setBadge(trainer.getBadge());
            }
        }
    }

    //  Remove o objeto treinador, caso ele exista
    public void remove(String name) {
        if (exist(name)) {
            for (int i = 0; i < trainerArray.length; i++) {
                if (name.equals(trainerArray[i].getName())) {
                    trainerArray[i] = trainerArray[trainerArray.length - 1];
                    Trainer[] aux = new Trainer[trainerArray.length - 1];
                    for (int j = 0; j < trainerArray.length - 1; j++) {
                        aux[i] = trainerArray[i];
                    }
                    trainerArray = aux;
                }
            }
        }
    }

}
