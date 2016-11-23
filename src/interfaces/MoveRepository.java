package interfaces;

import abstracts.Move;

public interface MoveRepository {
	
	public void insert(Move attack);

    public void remove(String name);

    public Move search(String name);

    public void update(Move attack);

    public boolean exist(String attack);
	
}
