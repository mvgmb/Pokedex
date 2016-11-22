package negocio.attack;

import negocio.attack.Attack;
import interfaces.AttackRepository;
import data.attack.*;
import exceptions.*;
import tipo.Tipos;

/**
 * Created by assf on 22/11/2016.
 */
public class AttackNegocios {

    private AttackRepository attackRepositorio;
    private Tipos arrayTipos;

    public AttackNegocios(String name) throws RepositorioInvalidoException {
        if (name.equals("array")) {
            this.attackRepositorio = new AttackRepositoryArray();
        } else if (name.equals("lista")) {
            this.attackRepositorio = new AttackRepositoryList();
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
