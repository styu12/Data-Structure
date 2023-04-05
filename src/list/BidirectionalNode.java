package list;

public class BidirectionalNode<E> {
	BidirectionalNode<E> prev;
	E item;
	BidirectionalNode<E> next;
	
	BidirectionalNode() {
		prev = next = null;
		item = null;
	}
	BidirectionalNode(E item) {
		prev = next = null;
		this.item = item;
	}
	BidirectionalNode(BidirectionalNode<E> prev, E item, BidirectionalNode<E> next) {
		this.prev = prev;
		this.item = item;
		this.next = next;
	}
}
