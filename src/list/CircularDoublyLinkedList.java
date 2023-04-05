package list;

public class CircularDoublyLinkedList<E> implements ListInterface<E> {
	private BidirectionalNode<E> head;
	private int numItems;
	
	public CircularDoublyLinkedList() {
		numItems = 0;
		head = new BidirectionalNode<>();
		head.prev = head.next = head;
	}
	
	public void add(int index, E x) {
		if(0 <= index && index <= numItems) {
			BidirectionalNode<E> prevNode = getNode(index - 1);
			BidirectionalNode<E> newNode = new BidirectionalNode(prevNode, x, prevNode.next);
			prevNode.next.prev = newNode;
			prevNode.next = newNode;
			numItems++;
		}	else {
			System.out.println("[add] index out ouf bound exception");
		}
	}
	
	public void append(E x) {
		BidirectionalNode<E> lastNode = head.prev;
		BidirectionalNode<E> newNode = new BidirectionalNode<>(lastNode, x, head);
		lastNode.next = newNode;
		head.prev = newNode;
		numItems++;
	}
	
	public E remove(int index) {
		if(0 <= index && index <= numItems - 1) {
			BidirectionalNode<E> curNode = getNode(index);
			curNode.prev.next = curNode.next;
			curNode.next.prev = curNode.prev;
			numItems--;
			return curNode.item;
		}	else {
			System.out.println("[remove] index out of bound exception");
			return null;
		}
	}
	
	public boolean removeItem(E x) {
		BidirectionalNode<E> curNode = head;
		for(int i = 0; i < numItems; i++) {
			curNode = curNode.next;
			if( ((Comparable)(curNode.item)).compareTo(x) == 0 ) {
				curNode.prev.next = curNode.next;
				curNode.next.prev = curNode.prev;
				numItems--;
				return true;
			}
		}
		System.out.println("[removeItem] item not found exception");
		return false;
	}
	
	public E get(int index) {
		if(0 <= index && index <= numItems - 1) {
			return getNode(index).item;
		}	else {
			System.out.println("[get] index out of bound exception");
			return null;
		}
	}
	
	public void set(int index, E x) {
		if(0 <= index && index <= numItems - 1) {
			getNode(index).item = x;
		}	else {
			System.out.println("[set] index out of bound exception");
		}
	}
	
	public BidirectionalNode<E> getNode(int index) {
		if(-1 <= index && index <= numItems - 1) {
			BidirectionalNode<E> curNode = head;
			
			if(index < numItems / 2) {
				for(int i = 0; i <= index; i++) {
					curNode = curNode.next;
				}
			}	else {
				for(int i = numItems-1; i >= index; i--) {
					curNode = curNode.prev;
				}
			}
			
			return curNode;
			
		}	else {
			System.out.println("[getNode] index out of bound exception");
			return null; 
		}
	}
	
	public final int NOT_FOUND = -12345;
	public int indexOf(E x) {
		BidirectionalNode<E> curNode = head;
		for(int i = 0; i < numItems; i++) {
			curNode = curNode.next;
			if ( ((Comparable)(curNode.item)).compareTo(x) == 0 ) {
				return i;
			}
		}
		System.out.println("[indexOf] item not found exception");
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
		head.prev = head.next = head;
	}
}
