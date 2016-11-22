package data.attack;

import interfaces.AttackRepository;
import negocio.attack.Attack;

public class AttackRepositoryList implements AttackRepository{
	
	private Node nodo;
	
	public AttackRepositoryList() {
		this.nodo=null;
	}
	
	public void insert(Attack attack) {
		if (this.nodo == null) {
			Node aux = new Node(attack);
			this.nodo = aux;
		} else {
			Node aux = new Node(attack);
			this.nodo.add(aux);
		}
	}
	
	public void remove(String attack) {
		if (this.nodo.attack.getName().equalsIgnoreCase(attack)) {
			Node aux = this.nodo.prox;
			this.nodo = aux;
		} else {
			this.nodo.remove(attack);
		}
	}
	
	public Attack search(String name) {
		return this.nodo.search(name);
	}
	
	public void update(Attack attack) {
		if (this.nodo.attack == attack) {
			Node aux = new Node(attack);
			aux.prox = this.nodo.prox;
			this.nodo = aux;
		} else {
			this.nodo.update(attack);
		}
	}
	
	public boolean exist(Attack attack) {
		return this.nodo.exist(attack);
	}
	
	class Node {
		
		private Attack attack;
		private Node prox;
		
		public Node() {
			this.attack = null;
			this.prox = null;
		}
		
		public Node(Attack attack) {
			this.attack = attack;
			this.prox = null;
		}
		
		public void add(Node nodo) {
			if (this.prox == null) {
				this.prox = nodo;
			} else {
				this.prox.add(nodo);
			}
		}
		
		public void remove(String attack) {
			if (this.prox.prox == null) {
				if (this.prox.attack.getName().equalsIgnoreCase(attack)) {
					this.prox = this.prox.prox;
				}
			} else {
				if (this.prox.attack.getName().equalsIgnoreCase(attack)) {
					this.prox = this.prox.prox;
				} else {
					this.prox.remove(attack);
				}
			}
		}
		
		public Attack search(String name) {
			Attack aux = null;
			if (this.prox == null) {
				if (this.attack.getName().equalsIgnoreCase(name)) {
					aux = this.attack;
				}
			} else {
				if (this.attack.getName().equalsIgnoreCase(name)) {
					aux = this.attack;
				} else {
					this.prox.search(name);
				}
			}
			return aux;
		}
		
		public void update(Attack attack) {
			if (this.prox.prox == null) {
				if (this.prox.attack==attack) {
					Node aux = this.prox.prox;
					this.prox = aux;
				}
			} else {
				if (this.prox.attack==attack) {
					Node aux = this.prox.prox;
					this.prox = aux;
				} else {
					this.prox.update(attack);
				}
			}
		}
		
		public boolean exist(Attack attack) {
			boolean exists = false;
			if (this.prox == null) {
				if (this.attack==attack) {
					exists = true;
				}
			} else {
				if (this.attack==attack) {
					exists = true;
				} else {
					this.prox.exist(attack);
				}
			}
			return exists;
		}
		
	}
}
