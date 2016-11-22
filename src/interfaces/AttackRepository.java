package Interfaces;

import negocio.Attack;

public interface AttackRepository {
	
	public void insert(Attack attack);

    public void remove(String name);

    public Attack search(String name);

    public void update(Attack attack);

    public boolean exist(Attack attack);
	
}
