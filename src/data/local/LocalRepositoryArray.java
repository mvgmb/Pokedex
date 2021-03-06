package data.local;

import interfaces.LocalRepository;
import negocio.local.Local;

/**
 * Created by gevd on 22/11/2016.
 */
public class LocalRepositoryArray implements LocalRepository {

    private Local[] localArray = new Local [0];

    // Insere um novo local no array
    public void insert(Local local){
        Local[] aux = new Local[this.localArray.length + 1];
        for(int i = 0; i < this.localArray.length; i++){
            aux[i] = this.localArray[i];
        }
        this.localArray = aux;
    }
    // Checa se já existe
    public boolean exist(String name){
        for(int i = 0; i < this.localArray.length; i++){
            if(name.equals(this.localArray[i].getName())){
                return true;
            }
        }
        return false;
    }
    // Procura o local
    public Local search(String name){
        for(int i = 0; i < this.localArray.length; i++){
            if (name.equals(localArray[i].getName())){
                return localArray[i];
            }
        }
        return null;
    }
    // Remove um local
    public void remove(String name){
        for(int i = 0; i < this.localArray.length; i++){
            if (name.equals(localArray[i].getName())) {
                localArray[i] = localArray[localArray.length - 1];
                Local[] aux = new Local[localArray.length - 1];
                for (int j = 0; j < localArray.length - 1; j++) {
                    aux[i] = localArray[i];
                }
                localArray = aux;
            }
        }
    }

    // Atualiza a região
    public void update(Local local){
            for (int i = 0; i < localArray.length; i++) {
                if (local.getName().equals(localArray[i].getName()))
                    localArray[i]=(local);
            }
        }
}


