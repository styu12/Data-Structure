package queue;

public class ArrayQueue<E> implements QueueInterface<E> {
	private E[] queue;
	private int front, tail, numItems;
	
	private static final int DEFAULT_CAPACITY = 64;
	private final E ERROR = null;
	
	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}
	public ArrayQueue(int n) {
		queue = (E[])new Object[n];
		front = 0;
		tail = n - 1;
		numItems = 0;
	}
	
	public void enqueue(E newItem) {
		if(isFull()) System.out.println("[enqueue] queue is already full exception");
		else {
			tail = (tail+1) % queue.length;
			queue[tail] = newItem;
			numItems++;
		}
	}
	
	public E dequeue() {
		if(isEmpty()) {
			System.out.println("[dequeue] queue is empty exception");
			return ERROR;
		}	else {
			E tmp = queue[front];
			front = (front+1) % queue.length;
			numItems--;
			return tmp;
		}
	}
	
	public E front() {
		if(isEmpty()) return ERROR;
		else return queue[front];
	}
	
	public boolean isEmpty() {
		return numItems == 0;
	}
	
	public boolean isFull() {
		return numItems == queue.length;
	}
	
	public void dequeueAll() {
		queue = (E[])new Object[queue.length-1];
		front = 0;
		tail = queue.length - 1;
		numItems = 0;
	}
}
