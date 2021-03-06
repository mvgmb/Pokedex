package data.move;

import interfaces.MoveRepository;
import abstracts.Move;

public class MoveRepositoryArray implements MoveRepository {

    private Move[] array;

    public MoveRepositoryArray() {
        array = new Move[0];
    }

    //Insere uma nova Move no array
    public void insert(Move attack) {
        Move[] aux = new Move[this.array.length + 1];
        for (int i = 0; i < this.array.length; i++) {
            aux[i] = this.array[i];
        }
        aux[this.array.length] = attack;
        this.array = aux;
    }

    //Remove uma Move do array
    public void remove(String name) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].getName().equalsIgnoreCase(name)) {
                Move[] aux = new Move[this.array.length - 1];
                for (int x = 0; x < this.array.length; x++) {
                    if (x < i) {
                        aux[x] = this.array[x];
                    } else if (x > i) {
                        aux[x - 1] = this.array[x];
                    }
                }
                this.array = aux;
            }
        }
    }

    //Atualiza um Move no array
    public void update(Move attack) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].getName().equalsIgnoreCase(attack.getName())) {
                this.array[i] = attack;
                //break;
            }
        }
    }

    //Procura um Move no array
    public Move search(String name) {
        Move aux = null;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].getName().equalsIgnoreCase(name)) {
                aux = this.array[i];
            }
        }
        return aux;
    }

    //Verifica se um Move existe
    public boolean exist(String attack) {
        boolean exists = false;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].getName().equalsIgnoreCase(attack)) {
                exists = true;
            }
        }
        return exists;
    }
}
