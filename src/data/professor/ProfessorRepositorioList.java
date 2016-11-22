package data.professor;

import interfaces.ProfessorRepositorio;
import negocio.professor.Professor;

/**
 * Created by mario on 22/11/16.
 */
public class ProfessorRepositorioList implements ProfessorRepositorio {
    private Professor professor;
    private ProfessorRepositorioList next;

    public ProfessorRepositorioList() {
        this.professor = null;
        this.next = null;
    }

    //  Insere um novo objeto no final da lista
    @Override
    public void insert(Professor trainer) {
        if (this.next == null) {
            this.professor.setName(trainer.getName());
            this.professor.setLab(trainer.getLab());
            this.next = new ProfessorRepositorioList();
        } else insert(trainer);
    }

    //  Metodo auxiliar, checa se o nome existe
    @Override
    public boolean exist(String name) {
        if (name.equals(professor.getName()))
            return true;
        else if (this.next == null)
            return false;
        else
            return this.next.exist(name);
    }

    //  Procura o treinador pelo nome e retorna a quatidade de badges
    @Override
    public Professor search(String name) {
        if (exist(name)) {
            if (name.equals(this.professor.getName()))
                return this.professor;
            else return search(name);
        }
        return null;
    }

    //  Atualiza o valor da quantidade de badges de um treinador
    @Override
    public void update(Professor trainer) {
        if (exist(trainer.getName())) {
            if (trainer.getName().equals(this.professor.getName())) {
                this.professor.setLab(professor.getLab());
            }
        }
    }

    //  Remove o objeto treinador
    @Override
    public void remove(String name) {
        if (exist(name)) {
            if (name.equals(this.next.professor.getName())) {
                this.next = this.next.next;
            }
        }
    }

}