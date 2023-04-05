package list;

import java.util.Iterator;

public class LinkedListIterator<E> implements Iterator<Node<E>> {
	Node<E> current;
	
	LinkedListIterator(LinkedList<E> list) {
		current = list.getNode(-1);
	}
	
	public boolean hasNext() {
		return current.next != null;
	}
	
	public Node next() {
		return current = current.next;
	}
	
}
