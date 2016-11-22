package data.trainer;

import interfaces.TrainerRepository;
import negocio.Trainer;

/**
 * Created by mario on 21/11/16.
 */
public class TrainerRepositotyList implements TrainerRepository{
    private Trainer trainer;
    private TrainerRepositotyList next;

    public TrainerRepositotyList(){
        this.trainer = null;
        this.next = null;
    }
    //  Insere um novo objeto no final da lista
    public void insert(Trainer trainer){
        if (this.next == null){
            this.trainer.setName(trainer.getName());
            this.trainer.setBadge(trainer.getBadge());
            this.next = new TrainerRepositotyList();
        }
        else insert(trainer);
    }
    //  Metodo auxiliar, checa se o nome existe
    public boolean exist(String name){
        if (name.equals(trainer.getName()))
            return true;
        else if (this.next == null)
            return false;
        else
            return this.next.exist(name);
    }
    //  Procura o treinador pelo nome e retorna a quatidade de badges, caso ele exista
    public int search(String name){
        if (exist(name)){
            if (name.equals(this.trainer.getName()))
                return this.trainer.getBadge();
            else return search(name);
        }
        else throw new RuntimeException("Treinador não encontrado");
    }
    //  Atualiza o valor da quantidade de badges de um treinador
    public void update(Trainer trainer){
        if (exist(trainer.getName())){
            if (trainer.getName().equals(this.trainer.getName())){
                this.trainer.setBadge(trainer.getBadge());
            }
        }
        else throw new RuntimeException("Treinador não encontrado");
    }
    //  Remove o objeto treinador, caso ele exista
    public void remove(String name){
        if (exist(name)){
            if (name.equals(this.next.trainer.getName())){
                this.next = this.next.next;
            }
        }
        else throw new RuntimeException("Treinador não encontrado");
    }

}