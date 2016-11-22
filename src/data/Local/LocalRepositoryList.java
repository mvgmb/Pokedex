package data.local;

import interfaces.LocalRepository;
import negocio.local.Local;

/**
 * Created by gevd on 22/11/2016.
 */
public class LocalRepositoryList implements LocalRepository {
    private Local local;
    private LocalRepositoryList next;

    public LocalRepositoryList(){
        this.local = null;
        this.next = null;
    }
    // Insere uma região no final da lista
    public void insert(Local local){
        if(this.next==null){
            this.local.setName(local.getName());
            this.next = new LocalRepositoryList();
        }else insert(local);
    }
    // Checa se a região existe
    public boolean exist(String name){
        if(name.equalsIgnoreCase(this.local.getName())){
            return true;
        }else if(this.next==null){
            if(this.local.getName().equalsIgnoreCase(name));
            return false;
        }else{
            return this.next.exist(name);
        }
    }
    // Procura a região (nome)
    public Local search(String name){
        if(exist(name)){
            if(name.equals(this.local.getName())){
                return this.local;
            }else{
                return search(name);
            }
            return null;
        }
    }
    // Atualiza a região
    public void update(Local local){
        if(exist(name)){
            if(exist(local.getName())){
                if(local.getName().equals(this.local.getName())){
                    this.local.setName(local.setName());
                }
            }
        }
    }
    // Remove uma região
    public void remove(Local local) {
        if (exist(name)) {
            if (name.equals(this.next.local.getName())) {
                this.next = this.next.next;
            }
        }
    }

}

