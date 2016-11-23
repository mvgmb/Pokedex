package interfaces;

import negocio.local.Local;
/**
 * Created by gevd on 22/11/2016.
 */
public interface LocalRepository {

    public void insert(Local local);

    public void remove(String name);

    public Local search(String name);

    public void update(Local local);

    public boolean exist(String name);
}
