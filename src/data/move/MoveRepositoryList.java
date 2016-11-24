package data.move;

import interfaces.MoveRepository;
import abstracts.Move;

public class MoveRepositoryList implements MoveRepository {
	
	private Node nodo;
	
	public MoveRepositoryList() {
		this.nodo=null;
	}

	// Insere um novo nodo
	public void insert(Move attack) {
		if (this.nodo == null) {
			Node aux = new Node(attack);
			this.nodo = aux;
		} else {
			Node aux = new Node(attack);
			this.nodo.add(aux);
		}
	}

	// remove o nodo
	public void remove(String attack) {
		if (this.nodo.attack.getName().equalsIgnoreCase(attack)) {
			Node aux = this.nodo.prox;
			this.nodo = aux;
		} else {
			this.nodo.remove(attack);
		}
	}

	//procura o move no nodo
	public Move search(String name) {
		return this.nodo.search(name);
	}

	// atualiza o move na lista
	public void update(Move attack) {
		if (this.nodo.attack == attack) {
			Node aux = new Node(attack);
			aux.prox = this.nodo.prox;
			this.nodo = aux;
		} else {
			this.nodo.update(attack);
		}
	}

	// checa se o nodo existe
	public boolean exist(String attack) {
		return this.nodo.exist(attack);
	}

	// classe que carrega as informações, o metodo de subclasse serve para evitar um nodo inútil no final da lista
	class Node {
		
		private Move attack;
		private Node prox;
		
		public Node() {
			this.attack = null;
			this.prox = null;
		}
		
		public Node(Move attack) {
			this.attack = attack;
			this.prox = null;
		}

		// usa o nodo do metodo insert para adicionar nesta lista
		public void add(Node nodo) {
			if (this.prox == null) {
				this.prox = nodo;
			} else {
				this.prox.add(nodo);
			}
		}

		// remove o nodo desejado da lista
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

		// procura o movimento desejado na lista
		public Move search(String name) {
			Move aux = null;
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

		// faz a atualização na lista
		public void update(Move attack) {
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

		// checa se o movimento existe
		public boolean exist(String attack) {
			boolean exists = false;
			if (this.prox == null) {
				if (this.attack.getName().equalsIgnoreCase(attack)) {
					exists = true;
				}
			} else {
				if (this.attack.getName().equalsIgnoreCase(attack)) {
					exists = true;
				} else {
					this.prox.exist(attack);
				}
			}
			return exists;
		}
		
	}
}
