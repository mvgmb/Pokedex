package interfaces;

import negocio.professor.Professor;

/**
 * Created by mario on 22/11/16.
 */
public interface ProfessorRepositorio {
    public void insert(Professor trainer);

    public boolean exist(String name);

    public Professor search(String name);

    public void update(Professor trainer);

    public void remove(String name);
}
