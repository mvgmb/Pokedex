package negocio.trainer;

import data.trainer.TrainerRepositoryArray;
import data.trainer.TrainerRepositoryList;
import exceptions.RepositorioInvalidoException;
import exceptions.TrainerExistenteException;
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
    public boolean exists(String nome) {
        return trainerRepository.exist(nome);
    }

    //
    public void insert(Trainer trainer) throws TrainerExistenteException {
        if (!exists(trainer.getName())) {
            trainerRepository.insert(trainer.getName());
        } else
            throw new TrainerExistenteException();

    }
}
