package sorting;

import java.util.Arrays;

public class Start {
	static final int NUM_SCALE = 10000;
	
	public static void prepare(int A[]) {
		for(int i=0; i<A.length; i++) {
			A[i] = (int)(NUM_SCALE * Math.random());
		}
	}
	
	static final int SIZE = 1000;
	public static void main(String[] args) {
		int[] A = new int[SIZE];
		prepare(A);
		
//		int[] A = {10,25,3,4,7,3,19,27,3};
		System.out.println(Arrays.toString(A));
		
		Sorting s = new Sorting(A);
		
		s.radixSort();
//		int[] B = s.countingSort(NUM_SCALE);
		System.out.println(Arrays.toString(A));
	}
}
