package negocio.trainer;

import data.trainer.TrainerRepositoryArray;
import data.trainer.TrainerRepositoryList;
import exceptions.RepositorioInvalidoException;
import exceptions.TrainerExistenteException;
import exceptions.TrainerInexistenteException;
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

    // Insere um novo objeto, caso ele na não exista
    public void insert(Trainer trainer) throws TrainerExistenteException {
        if (!exist(trainer.getName())) {
            trainerRepository.insert(trainer);
        } else
            throw new TrainerExistenteException();
    }

    //  Procura um objeto pelo nome e retorna a quantidade de badges, caso ele exista
    public Trainer search(String name) throws TrainerInexistenteException {
        if (exist(name)) {
            return trainerRepository.search(name);
        } else
            throw new TrainerInexistenteException();
    }

    //  Atualiza um objeto, caso ele exista
    public void update(Trainer trainer) throws TrainerInexistenteException {
        if (exist(trainer.getName())) {
            trainerRepository.update(trainer);
        } else
            throw new TrainerInexistenteException();
    }

    //  Remove um objeto caso ele exista
    public void remove(String name) throws TrainerInexistenteException {
        if (exist(name)) {
            trainerRepository.remove(name);
        } else
            throw new TrainerInexistenteException();
    }
}