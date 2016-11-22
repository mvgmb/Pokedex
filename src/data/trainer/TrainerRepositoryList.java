package data.trainer;

import interfaces.TrainerRepository;
import negocio.trainer.Trainer;

/**
 * Created by mario on 21/11/16.
 */
public class TrainerRepositoryList implements TrainerRepository {
    private Trainer trainer;
    private TrainerRepositoryList next;

    public TrainerRepositoryList() {
        this.trainer = null;
        this.next = null;
    }

    //  Insere um novo objeto no final da lista
    @Override
    public void insert(Trainer trainer) {
        if (this.next == null) {
            this.trainer.setName(trainer.getName());
            this.trainer.setBadge(trainer.getBadge());
            this.next = new TrainerRepositoryList();
        } else insert(trainer);
    }

    //  Metodo auxiliar, checa se o nome existe
    @Override
    public boolean exist(String name) {
        if (name.equals(trainer.getName()))
            return true;
        else if (this.next == null)
            return false;
        else
            return this.next.exist(name);
    }

    //  Procura o treinador pelo nome e retorna a quatidade de badges
    @Override
    public Trainer search(String name) {
        if (exist(name)) {
            if (name.equals(this.trainer.getName()))
                return this.trainer;
            else return search(name);
        }
        return null;
    }

    //  Atualiza o valor da quantidade de badges de um treinador
    @Override
    public void update(Trainer trainer) {
        if (exist(trainer.getName())) {
            if (trainer.getName().equals(this.trainer.getName())) {
                this.trainer.setBadge(trainer.getBadge());
            }
        }
    }

    //  Remove o objeto treinador
    @Override
    public void remove(String name) {
        if (exist(name)) {
            if (name.equals(this.next.trainer.getName())) {
                this.next = this.next.next;
            }
        }
    }

}