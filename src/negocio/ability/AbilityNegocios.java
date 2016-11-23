package negocio.ability;

import data.ability.AbilityRepositoryArray;
import data.ability.AbilityRepositoryList;
import interfaces.AbilityRepository;
import exceptions.RepositorioInvalidoException;
import exceptions.AbilityInexistenteException;
import exceptions.AbilityExistenteException;

public class AbilityNegocios {
    private AbilityRepository abilityRepository;

    public AbilityNegocios (String tipo) throws RepositorioInvalidoException {
        if (tipo.equals("array")) {
            abilityRepository = new AbilityRepositoryArray();
        } else if (tipo.equals("lista")) {
            abilityRepository = new AbilityRepositoryList();
        } else {
            throw new RepositorioInvalidoException();
        }
    }

    public boolean exist (String name) {
        return abilityRepository.exist(name);
    }

    public void insert (Ability ability) throws AbilityExistenteException {
        if (!exist(ability.getName()))
            abilityRepository.insert(ability);
        else
            throw new AbilityExistenteException();
    }

    public Ability search (String name) throws AbilityInexistenteException {
        if (exist(name))
            return abilityRepository.search(name);
        else
            throw new AbilityInexistenteException();
    }

    public void remove (String name) throws AbilityInexistenteException {
        if (exist(name))
            abilityRepository.remove(name);
        else
            throw new AbilityInexistenteException();
    }

    public void update (Ability ability) throws AbilityInexistenteException {
        if (exist(ability.getName()))
            abilityRepository.update(ability);
        else
            throw new AbilityInexistenteException();

    }

}
