package negocio.local;

import data.local.LocalRepositoryArray;
import data.local.LocalRepositoryList;
import exceptions.RepositorioInvalidoException;
import exceptions.LocalExistenteException;
import exceptions.LocalInexistenteException;
import interfaces.LocalRepository;

/**
 * Created by gevd on 23/11/2016.
 */
public class LocalNegocios {
    private LocalRepository localRepository;

    //Recebe o tipo de repositório
    public LocalNegocios(String tipo) throws RepositorioInvalidoException {
        if(tipo.equals("array")){
            localRepository = new LocalRepositoryArray();
        }else if(tipo.equals("lista")){
            localRepository = new LocalRepositoryList();
        }else{
            throw new RepositorioInvalidoException();
        }
    }

    //Verifica se esse local existe, em caso afirmativo, retorna TRUE
    public boolean exist(String nome){
        return localRepository.exist(nome);
    }

    //Adiciona um local novo, se ele já não existir
    public void insert(Local local) throws LocalExistenteException{
        if(!exist(local.getName())){
            localRepository.insert(local);
        }else{
            throw new LocalExistenteException();
        }
    }

    //Procura um local, caso exista, retorna o objetivo
    public Local search(String name) throws LocalInexistenteException{
        if(exist(name)){
            return localRepository.search(name);
        }else{
            throw new LocalInexistenteException();
        }
    }

    //Atualiza o local, se ele existir
    public void update(Local local) throws LocalInexistenteException{
        if(exist(local.getName())){
            localRepository.update(local);
        }else{
            throw new LocalInexistenteException();
        }
    }

    //Remove um local, se ele existir
    public void remove(String name) throws LocalInexistenteException{
        if(exist(name)){
            localRepository.remove(name);
        }else{
            throw new LocalInexistenteException();
        }
    }

}