package queue;

import list.LinkedList;

public class InheritedQueue<E> extends LinkedList<E> implements QueueInterface<E> {

	public InheritedQueue() {
		super();
	}
	
	public void enqueue(E newItem) {
		super.append(newItem);
	}
	
	public E dequeue() {
		return super.remove(0);
	}
	
	public E front() {
		return super.get(0);
	}
	
	public boolean isEmpty() {
		return super.isEmpty();
	}
	
	public void dequeueAll() {
		super.clear();
	}
}