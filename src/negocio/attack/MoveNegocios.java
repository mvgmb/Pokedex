package negocio.attack;

import interfaces.MoveRepository;
import data.move.*;
import exceptions.*;
import tipo.Tipos;
import abstracts.Move;

/**
 * Created by assf on 22/11/2016.
 */
public class MoveNegocios {

    private MoveRepository attackRepositorio;
    private Tipos arrayTipos;

    public MoveNegocios(String name) throws RepositorioInvalidoException {
        if (name.equals("array")) {
            this.attackRepositorio = new MoveRepositoryArray();
        } else if (name.equals("lista")) {
            this.attackRepositorio = new MoveRepositoryList();
        } else {
            throw new RepositorioInvalidoException();
        }
    }

    public boolean exists(String attack) {
        return this.attackRepositorio.exist(attack);
    }

    public void insert(Attack attack) throws AttackExistenteException, TipoInvalidoException {
        if (!arrayTipos.exist(attack.getType())) {
            throw new TipoInvalidoException();
        } else if (exists(attack.getName())) {
            throw new AttackExistenteException();
        } else {
            this.attackRepositorio.insert(attack);
        }
    }

    public void remove(String name) throws AttackInexistenteException {
        if (this.attackRepositorio.exist(name)) {
            this.attackRepositorio.remove(name);
        } else {
            throw new AttackInexistenteException();
        }
    }

    public void update(Attack attack) throws AttackInexistenteException {
        if (this.attackRepositorio.exist(attack.getName())) {
            this.attackRepositorio.update(attack);
        } else {
            throw new AttackInexistenteException();
        }
    }

    public Attack search(String name) throws AttackInexistenteException {
        if (this.attackRepositorio.exist(name)) {
            return this.attackRepositorio.search(name);
        } else {
            throw new AttackInexistenteException();
        }
    }

}
