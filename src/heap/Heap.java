package heap;

public class Heap<E extends Comparable> implements PQInterface<E> {
	private E[] A;
	private int numItems;
	
	private static final int DEFAULT_CAPACITY = 64;
	
	public Heap() {
		this(DEFAULT_CAPACITY);
	}
	
	public Heap(int n) {
		A = (E[])new Comparable[n];
		numItems = 0;
	}
	
	public Heap(E[] A, int numItems) {
		this.A = A;
		this.numItems = numItems;
		buildHeap();
	}
	
	public void insert(E newItem) throws PQException {
		if(numItems < A.length) {
			A[numItems] = newItem;
			percolateUp(numItems);
			numItems++;
		}	else throw new PQException("HeapERR: Insert()-Overflow!");
	}
	
	public void percolateUp(int i) {
		int parent = (i-1) / 2;
		if(parent >= 0 && A[i].compareTo(A[parent]) > 0) {
			E tmp = A[i];
			A[i] = A[parent];
			A[parent] = tmp;
			percolateUp(parent);
		}
	}
	
	public E deleteMax() throws PQException {
		if(!isEmpty()) {
			E max = A[0];
			A[0] = A[numItems-1];
			numItems--;
			percolateDown(0);
			return max;
		}	else throw new PQException("HeapERR: DeleteMax()-Underflow!");
		
	}
	
	public void percolateDown(int i) {
		int child = 2*i + 1;
		int right = 2*i + 2;
		if(child <= numItems-1) {
			if(right <= numItems-1 && A[right].compareTo(A[child]) > 0) child = right;
			if(A[i].compareTo(A[child]) < 0) {
				E tmp = A[i];
				A[i] = A[child];
				A[child] = tmp;
				percolateDown(child);
			}
		}
	}
	
	public void buildHeap() {
		if(numItems >= 2) {
			for(int i=(numItems-2)/2; i>=0; i--) percolateDown(i);
		}
	}
	
	public E max() throws PQException {
		if(!isEmpty()) {
			return A[0];
		}	else throw new PQException("HeapERR: Max()-Empty!");
	}
	
	public boolean isEmpty() {
		return numItems == 0;
	}
	
	public void clear() {
		A = (E[])new Comparable[A.length];
		numItems = 0;
	}
	
}
