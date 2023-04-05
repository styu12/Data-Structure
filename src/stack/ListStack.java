package stack;

import list.ListInterface;
import list.LinkedList;

public class ListStack<E> implements StackInterface<E> {
	private ListInterface<E> list;
	
	public ListStack() {
		list = new LinkedList<E>();
	}
	
	public void push(E newItem) {
		list.add(0, newItem);
	}
	
	public E pop() {
		if(!isEmpty()) return list.remove(0);
		return null;
	}
	
	public E top() {
		return list.get(0);
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void popAll() {
		list.clear();
	}
}
