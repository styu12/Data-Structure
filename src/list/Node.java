package list;

public class Node<E> {
	public E item;
	public Node<E> next;
	
	public Node(E newItem) {
		this.item = newItem;
		this.next = null;
	}
	
	public Node(E newItem, Node<E> nextNode) {
		this.item = newItem;
		this.next = nextNode;
	}
}
