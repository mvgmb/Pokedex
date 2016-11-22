package data.attack;

import interfaces.AttackRepository;
import negocio.attack.Attack;

public class AttackRepositoryArray implements AttackRepository {
    private Attack[] array;

    public AttackRepositoryArray() {
        array = new Attack[0];
    }

    public void insert(Attack attack) {
        Attack[] aux = new Attack[this.array.length + 1];
        for (int i = 0; i < this.array.length; i++) {
            aux[i] = this.array[i];
        }
        aux[this.array.length] = attack;
        this.array = aux;
    }

    public void remove(String name) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].getName() == name) {
                Attack[] aux = new Attack[this.array.length - 1];
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

    public void update(Attack attack) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].getName().equals(attack.getName())) {
                this.array[i] = attack;
                break;
            }
        }
    }

    public Attack search(String name) {
        Attack aux = null;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].getName().equals(name)) {
                aux = this.array[i];
            }
        }
        return aux;
    }

    public boolean exist(Attack attack) {
        boolean exists = false;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == attack) {
                exists = true;
            }
        }
        return exists;
    }
}
