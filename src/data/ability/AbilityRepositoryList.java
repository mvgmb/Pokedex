package data.ability;

import negocio.ability.Ability;
import interfaces.AbilityRepository;
public class AbilityRepositoryList implements AbilityRepository {

    private Node head;

    public AbilityRepositoryList(){}

    public boolean isEmpty() {

        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insert (Ability ability) {
        if (isEmpty()) {
            head = new Node();
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next.add(ability);
        }
    }
    public void remove (String name) {
        this.head.delete(name, head);
    }
    public void update (String name, String newDescription) {
        Node current = head;

    }
    public Ability search (String name) {
    }

    class Node {
        private Ability ability;
        private Node next;

        public void add (Ability ability) {
            if (this.next == null) {
                this.next = new Node();
                this.next.ability = ability;
            } else {
                this.next.add(ability);
            }
        }

        public void delete (String name, Node deleted) {
            if (deleted.ability.getName().equals(name)) {
                Node node = new Node();
                node = deleted.next;
                deleted = node;
            } else {
                deleted.next.delete(name, deleted.next);
            }
        }
    }
}