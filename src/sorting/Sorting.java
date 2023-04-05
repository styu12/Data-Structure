package sorting;

public class Sorting {
	int A[];
	
	public Sorting(int[] B) {
		A = B;
	}
	
	public void selectionSort() {
		int k, tmp;
		for(int last=A.length-1; last>=1; last--) {
			k = theLargest(last);
			tmp = A[last];
			A[last] = A[k];
			A[k] = tmp;
		}
	}
	
	public int theLargest(int last) {
		int index = 0;
		for(int i=0; i<=last; i++) {
			if(A[i] > A[index]) index = i;
		}
		return index;
	}
	
	public void bubbleSort() {
		int tmp;
		boolean swapped;
		
		
		for(int last=A.length-1; last>=1; last--) {
			swapped = false;
			for(int i=0; i<last; i++) {
				if(A[i] > A[i+1]) {
					tmp = A[i+1];
					A[i+1] = A[i];
					A[i] = tmp;
					swapped = true;
				}
			}
			if(!swapped) break;
		}
	}
	
	public void insertionSort() {
		for(int i=1; i<A.length; i++) {
			int newItem = A[i];
			int loc = i-1;
			while(loc >= 0 && A[loc] > newItem) {
				A[loc+1] = A[loc];
				loc--;
			}
			A[loc+1] = newItem;
		}
	}
	
	public void mergeSort() {
		int[] B = new int[A.length];
		mSort(0, A.length-1, B);
	}
	
	private void mSort(int p, int r, int[] B) {
		if(p < r) {
			int q = (p+r) / 2;
			mSort(p, q, B);
			mSort(q+1, r, B);
			merge(p, q, r, B);
		}
	}
	
	private void merge(int p, int q, int r, int[] B) {
		int i = p;
		int j = q+1;
		int t = p;
		while(i <= q && j <= r) {
			if(A[i] < A[j]) B[t++] = A[i++];
			else B[t++] = A[j++];
		}
		
		while(i <= q) {
			B[t++] = A[i++];
		}
		
		while(j <= r) {
			B[t++] = A[j++];
		}
		
		for(i=p; i<=r; i++) {
			A[i] = B[i];
		}
	}
	
	// implement qSort
	public void quickSort() {
		qSort(0, A.length-1);
	}
	
	// recursively call qsort
	private void qSort(int p, int r) {
		if(p < r) {
			int q = partition(p, r);
			qSort(p, q-1);
			qSort(q+1, r);
		}
	}
	
	// sorting and return partition
	private int partition(int p, int r) {
		int x = A[r];
		int i = p-1;
		int tmp;
		
		for(int j=p; j<r; j++) {
			if(A[j] < x) {
				tmp = A[++i];
				A[i] = A[j];
				A[j] = tmp;
			}
		}
		tmp = A[++i];
		A[i] = A[r];
		A[r] = tmp;
		return i;
	}
	
	public void heapSort() {
		buildHeap();
		int tmp;
		for(int i=A.length-1; i>=0; i--) {
			tmp = A[i];
			A[i] = A[0];
			A[0] = tmp;
			percolateDown(0, i);
		}
	}
	
	private void buildHeap() {
		if(A.length >= 2) {
			for(int i = (A.length-2)/2; i>=0; i--) {
				percolateDown(i, A.length);
			}
		}
	}
	
	// index i & array length n 
	private void percolateDown(int i, int n) {
		int child = 2*i + 1;
		int right = 2*i + 2;
		if(child < n) {
			if(right < n && A[right] > A[child]) {
				child = right;
			}
			if(A[child] > A[i]) {
				int tmp = A[i];
				A[i] = A[child];
				A[child] = tmp;
				percolateDown(child, n);
			}
		}
	}
	
	public void shellSort() {
		for(int h=A.length/7; h>5; h=h/5-1) {
			for(int k=0; k<h; k++) {
				stepInsertionSort(k, h);
			}
		}
		stepInsertionSort(0,1);
	}
	
	// k group & h space
	public void stepInsertionSort(int k, int h) {
		int j, insItem;
		for(int i=k+h; i<A.length; i+=h) {
			insItem = A[i];
			for(j=i-h; j>=0 && A[j]>insItem; j-=h) {
				A[j+h] = A[j];
			}
			A[j+h] = insItem;
		}
	}
	
	// 	A[0...n-1] belong to integers 0~K-1	
	public int[] countingSort(int K) {
		int[] cnt = new int[K];
		for(int i=0; i<K; i++) cnt[i] = 0;
		for(int i=0; i<A.length; i++) cnt[A[i]]++;
		cnt[0]--; 
		for(int i=1; i<K; i++) cnt[i] += cnt[i-1];
		int[] B = new int[A.length];
		for(int j=A.length-1; j>=0; j--) {
			B[cnt[A[j]]] = A[j];
			cnt[A[j]]--;
		}
		
		return B;
	}
	
	// 최대 numDigits 자리수의 양의 정수 
	public void radixSort() {
		int[] cnt = new int[10], start = new int[10];
		int[] B = new int[A.length];
		int max = -1;
		for(int i=0; i<A.length; i++) {
			if(A[i] > max) max = A[i];
		}
		int numDigits = (int)Math.log10(max)+1;
		
		for(int digit=1; digit<=numDigits; digit++) {
			for(int d=0; d<10; d++) cnt[d] = 0;
			for(int i=0; i<A.length; i++) {
				cnt[(A[i]/(int)Math.pow(10, digit-1)) % 10]++;
			}
			start[0] = 0;
			for(int d=1; d<10; d++) {
				start[d] = start[d-1] + cnt[d-1];
			}
			for(int i=0; i<A.length; i++) {
				B[start[(A[i]/(int)Math.pow(10, digit-1)) % 10]++] = A[i];
			}
			
			for(int i=0; i<A.length; i++) {
				A[i] = B[i];
			}
		}
	}
	
//	public void bucketSort() {
//		//A[0..] 음이 아닌 정수 범위에서 균등 분포 배열 
//		intLinkedList B[];
//		int numLists = A.length;
//		B = new intLinkedList[numLists];
//	}
	
}
