package stack;

import list.Node;

public class LinkedStack<E> implements StackInterface<E> {
	private Node<E> topNode;
	private final E ERROR = null;
	
	LinkedStack() {
		topNode = null;
	}
	
	public void push(E newItem) {
		topNode = new Node<E>(newItem, topNode);
	}
	
	public E pop() {
		if(isEmpty()) {
			System.out.println("[pop] stack is empty exception");
			return ERROR;
		}	else {
			Node<E> temp = topNode;
			topNode = topNode.next;
			return temp.item;
		}
	}
	
	public E top() {
		if(isEmpty()) {
			System.out.println("[top] stack is empty exception");
			return ERROR;
		}
		return topNode.item;
	}
	
	public boolean isEmpty() {
		return topNode == null;
	}
	
	public void popAll() {
		topNode = null;
	}
}
