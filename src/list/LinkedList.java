package list;

public class LinkedList<E> implements ListInterface<E> {
	private Node<E> head;
	private int numItems;
	
	public LinkedList() {
		this.head = new Node<E>(null, null);
		this.numItems = 0;
	}
	
	
	public void add(int index, E x) {
		if(0 <= index && index <= numItems) {
			Node<E> prevNode = getNode(index -1);
			Node<E> newNode = new Node<>(x, prevNode.next);
			prevNode.next = newNode;
			numItems++;
		}	else {
			System.out.println("[add] Index Out Of Bound Exception");
			return;
		}
	}
	
	public void append(E x) {
		Node<E> prevNode = head;
		Node<E> newNode = new Node<>(x, null);
		
		while(prevNode.next != null) {
			prevNode = prevNode.next;
		}
		
		prevNode.next = newNode;
		numItems++;
	}
	
	public E remove(int index) {
		if(0 <= index && index <= numItems - 1) {
			Node<E> prevNode = getNode(index - 1);
			Node<E> curNode = prevNode.next;
			
			prevNode.next = curNode.next;
			numItems--;
			return curNode.item;
		}	else {
			System.out.println("[remove] Index Out Of Bound Exception");
			return null;
		}
	}
	
	public boolean removeItem(E x) {
		Node<E> curNode = head;
		Node<E> prevNode;
		
		for(int i = 0; i < numItems; i++) {
			prevNode = curNode;
			curNode = curNode.next;
			
			if( ((Comparable)(curNode.item)).compareTo(x) == 0 ) {
				prevNode.next = curNode.next;
				numItems--;
				return true;
			}
		}
		System.out.println("[removeItems] Not Found");
		return false;
	}
	
	public E get(int index) {
		if(0 <= index && index <= numItems - 1) {
			Node<E> curNode = getNode(index);
			return curNode.item;
		}	else {
			return null;
		}
	}
	
	public Node<E> getNode(int index) {
		if(-1 <= index && index <= numItems - 1) {
			// index of head = -1
			Node<E> curNode = head;
			// update curNode until targetNode appears
			for(int i = 0; i <= index; i++) {
				curNode = curNode.next;
			}
			return curNode;
		}	else {
			System.out.println("[getNode] Index Out Of Bound Exception");
			return null;
		}
	}
	
	public void set(int index, E x) {
		if(0 <= index && index <= numItems - 1) {
			Node<E> curNode = getNode(index);
			curNode.item = x;
		}	else {
			System.out.println("[set] Index Out Of Bound Exception");
			return;
		}
	}
	
	public final int NOT_FOUND = -12345;
	public int indexOf(E x) {
		Node<E> curNode = head;
		
		int i;
		for(i = 0; i < numItems; i++) {
			curNode = curNode.next;
			if( ((Comparable)(curNode.item)).compareTo(x) == 0 ) {
				return i;
			}
		}
		return NOT_FOUND;
	}
	
	public int len() {
		return numItems;
	}
	
	public boolean isEmpty() {
		return numItems == 0;
	}
	
	public void clear() {
		numItems = 0;
		head = new Node<>(null, null);
	}
}
