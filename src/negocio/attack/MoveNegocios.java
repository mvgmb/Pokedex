package negocio.attack;

import interfaces.MoveRepository;
import data.move.*;
import exceptions.*;
import abstracts.Move;
import negocio.tipos.Tipos;

/**
 * Created by assf on 22/11/2016.
 */
public class MoveNegocios {

    private MoveRepository moveRepositorio;
    private Tipos arrayTipos;

    public MoveNegocios(String name) throws RepositorioInvalidoException {
        if (name.equals("array")) {
            this.moveRepositorio = new MoveRepositoryArray();
        } else if (name.equals("lista")) {
            this.moveRepositorio = new MoveRepositoryList();
        } else {
            throw new RepositorioInvalidoException();
        }
    }

    public boolean exists(String attack) {
        return this.moveRepositorio.exist(attack);
    }

    public void insert(Move move) {
            this.moveRepositorio.insert(move);
    }

    public void remove(String name) {
            this.moveRepositorio.remove(name);
    }

    public void update(Move move) {
            this.moveRepositorio.update(move);
    }

    public Move search(String name) {
            return this.moveRepositorio.search(name);
    }

}
