package negocio.professor;

import data.professor.ProfessorRepositorioArray;
import data.professor.ProfessorRepositorioList;
import exceptions.ProfessorExistenteException;
import exceptions.ProfessorInexistenteException;
import exceptions.RepositorioInvalidoException;
import interfaces.ProfessorRepositorio;

/**
 * Created by mario on 22/11/16.
 */
public class ProfessorNegocios {

    private ProfessorRepositorio trainerRepository;

    public ProfessorNegocios(String tipo) throws RepositorioInvalidoException {
        // Construtor recebe a string que define o tipo de repositório
        // o mesmo é então inicializado.
        if (tipo.equals("array")) {
            ProfessorRepositorio = new ProfessorRepositorioArray();

        } else if (tipo.equals("lista")) {
            trainerRepository = new ProfessorRepositorioList();

        } else {
            throw new RepositorioInvalidoException();
        }
    }

    //  Checa se o objeto existe, caso sim , retorna true
    public boolean exist(String nome) {
        return trainerRepository.exist(nome);
    }

    // Insere um novo objeto, caso ele na não exista
    public void insert(Professor trainer) throws ProfessorExistenteException {
        if (!exist(trainer.getName())) {
            trainerRepository.insert(trainer);
        } else
            throw new ProfessorExistenteException();
    }

    //  Procura um objeto pelo nome e retorna o nome do laboratório caso ele exista
    public Professor search(String name) throws ProfessorInexistenteException {
        if (exist(name)) {
            return trainerRepository.search(name);
        } else
            throw new ProfessorInexistenteException();
    }

    //  Atualiza um objeto, caso ele exista
    public void update(Professor professor) throws ProfessorInexistenteException {
        if (exist(professor.getName())) {
            trainerRepository.update(professor);
        } else
            throw new ProfessorInexistenteException();
    }

    //  Remove um objeto caso ele exista
    public void remove(String name) throws ProfessorInexistenteException {
        if (exist(name)) {
            trainerRepository.remove(name);
        } else
            throw new ProfessorInexistenteException();
    }
}
