package data.trainerrepository;

import negocio.Coach;

/**
 * Created by mario on 21/11/16.
 */
public class coachRepositoryArray {
    private Coach[] coachArray = new Coach[0];

    //  Insere um novo coach na array
    public void insert(Coach coach) {
        Coach[] aux = new Coach[this.coachArray.length + 1];
        for (int i = 0; i < this.coachArray.length; i++) {
            aux[i] = this.coachArray[i];
        }
        aux[this.coachArray.length + 1] = coach;
        this.coachArray = aux;
    }

    //  Metodo auxiliar de Procurar, checa se o nome existe
    private boolean exist(String name) {
        for (int i = 0; i < this.coachArray.length; i++) {
            if (name.equals(this.coachArray[i].getName()))
                return true;
        }
        return false;
    }

    //  Procura se o coach existe, caso exista, retorna a quantidade de badges
    public int search(String name) {
        for (int i = 0; i < coachArray.length; i++) {
            if (exist(name)) {
                return coachArray[i].getBadge();
            }
        }
        throw new RuntimeException("Treinador não encontrado");
    }

    //  Atualiza a quatidade de badges de um treinador, caso ele exista
    public void update(String name, int badge) {
        if (exist(name)) {
            for (int i = 0; i < coachArray.length; i++) {
                if (name.equals(coachArray[i].getName()))
                    coachArray[i].setBadge(badge);
            }
            System.out.println("Treinador atualizado com sucesso!");
        } else throw new RuntimeException("Treinador não encontrado");
    }

    //  Remove o objeto treinador, caso ele exista
    public void remove(String name) {
        if (exist(name)) {
            for (int i = 0; i < coachArray.length; i++) {
                if (name.equals(coachArray[i].getName())) {
                    coachArray[i] = coachArray[coachArray.length - 1];
                    Coach[] aux = new Coach[coachArray.length - 1];
                    for (int j = 0; j < coachArray.length - 1; j++) {
                        aux[i] = coachArray[i];
                    }
                    coachArray = aux;
                }
            }
            System.out.println("Treinador removido com sucesso");
        } else throw new RuntimeException("Treinador não encontrado");
    }

}
