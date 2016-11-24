package negocio.trainer;

import data.trainer.TrainerRepositoryArray;
import data.trainer.TrainerRepositoryList;
import exceptions.RepositorioInvalidoException;
import interfaces.TrainerRepository;

/**
 * Created by mario on 22/11/16.
 */
public class TrainerNegocios {
    private TrainerRepository trainerRepository;

    public TrainerNegocios(String tipo) throws RepositorioInvalidoException {
        // Construtor recebe a string que define o tipo de repositório
        // o mesmo é então inicializado.
        if (tipo.equals("array")) {
            trainerRepository = new TrainerRepositoryArray();

        } else if (tipo.equals("lista")) {
            trainerRepository = new TrainerRepositoryList();

        } else {
            throw new RepositorioInvalidoException();
        }
    }

    //  Checa se o objeto existe, caso sim , retorna true
    public boolean exist(String nome) {
            return trainerRepository.exist(nome);
    }

    // Insere um novo objeto, caso ele não exista
    public void insert(Trainer trainer) {
        trainerRepository.insert(trainer);
    }

    //  Procura um objeto pelo nome e retorna a quantidade de badges, caso ele exista
    public Trainer search(String name) {
        return trainerRepository.search(name);
    }

    //  Atualiza um objeto, caso ele exista
    public void update(Trainer trainer) {
        trainerRepository.update(trainer);
    }

    //  Remove um objeto caso ele exista
    public void remove(String name){
            trainerRepository.remove(name);
    }
    public Trainer[] returnContent(){
        return trainerRepository.returnContent();
    }
}
