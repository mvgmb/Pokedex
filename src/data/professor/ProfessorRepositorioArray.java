package data.professor;

import interfaces.ProfessorRepositorio;
import negocio.professor.Professor;

/**
 * Created by mario on 22/11/16.
 */
public class ProfessorRepositorioArray implements ProfessorRepositorio {
    private Professor[] trainerArray = new Professor[0];

    //  Insere um novo coach na array
    @Override
    public void insert(Professor professor) {
        Professor[] aux = new Professor[this.trainerArray.length + 1];
        for (int i = 0; i < this.trainerArray.length; i++) {
            aux[i] = this.trainerArray[i];
        }
        aux[this.trainerArray.length + 1] = professor;
        this.trainerArray = aux;
    }

    //  Metodo auxiliar de Procurar, checa se o nome existe
    @Override
    public boolean exist(String name) {
        for (int i = 0; i < this.trainerArray.length; i++) {
            if (name.equals(this.trainerArray[i].getName()))
                return true;
        }
        return false;
    }

    //  Procura se o coach existe, caso exista, retorna a quantidade de badges
    @Override
    public Professor search(String name) {
        for (int i = 0; i < trainerArray.length; i++) {
            if (exist(name)) {
                return trainerArray[i];
            }
        }
        return null;
    }

    //  Atualiza a quatidade de badges de um treinador, caso ele exista
    @Override
    public void update(Professor professor) {
        if (exist(professor.getName())) {
            for (int i = 0; i < trainerArray.length; i++) {
                if (professor.getName().equals(trainerArray[i].getName()))
                    trainerArray[i].setLab(professor.getLab());
            }
        }
    }

    //  Remove o objeto treinador, caso ele exista
    @Override
    public void remove(String name) {
        if (exist(name)) {
            for (int i = 0; i < trainerArray.length; i++) {
                if (name.equals(trainerArray[i].getName())) {
                    trainerArray[i] = trainerArray[trainerArray.length - 1];
                    Professor[] aux = new Professor[trainerArray.length - 1];
                    for (int j = 0; j < trainerArray.length - 1; j++) {
                        aux[i] = trainerArray[i];
                    }
                    trainerArray = aux;
                }
            }
        }
    }

}