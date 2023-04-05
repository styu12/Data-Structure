package list;

import java.util.Arrays;

public class IntegerArrayList implements IntegerListInterface {
	private Integer[] item;
	private int numItems;
	private static final int DEFAULT_CAPACITY = 64;
	
	IntegerArrayList() {
		this(DEFAULT_CAPACITY);
	}
	IntegerArrayList(int n) {
		item = new Integer[n];
	}
	
	
	public void add(int index ,Integer x) {
		// index out of bound
		if(numItems >= item.length || index < 0 || index > numItems) {
			System.out.println("[add] Index Out Of Bound Exception");
			return;
		}	else {
			// right move and insert
			for(int i = numItems; i > index; i--) {
				item[i] = item[i-1];
			}
			item[index] = x;
			numItems++;
		}
	}
	
	public void append(Integer x) {
		// if list is full -> return
		if(numItems >= item.length) {
			System.out.println("[append] List is already full Exception");
			return;
		}	else {
			// insert item and increase numItems
			item[numItems++] = x;
		}
	}
	
	public Integer remove(int index) {
		// index out of bound
		if(isEmpty() || index < 0 || index > numItems - 1) {
			System.out.println("[remove] Index Out Of Boudn Exception");
			return null;
		}	else {
			Integer tmp = item[index];
			// left move and decrease numItems
			for(int i = index; i < numItems-1; i++) {
				item[i] = item[i+1];
			}
			numItems--;
			return tmp;
		}
	}
	
	public boolean removeItem(Integer x) {
		// find index of the item
		int k = 0;
		while(k < numItems && item[k].compareTo(x) != 0) {
			k++;
		}
		
		if(k == numItems) {
			System.out.println("[removeItem] That Item Not Existing Exception");
			return false;
		}	else {
			//left move and decrease numItems
			for(int i = k; i < numItems-1; i++) {
				item[i] = item[i+1];
			}
			numItems--;
			return true;
		}
		
		
	}
	
	public Integer get(int index) {
		// index out of bound
		if(index < 0 || index > numItems -1) {
			System.out.println("[get] Index Out Of Bound Exception");
			return null;
		}	else {
			return item[index];			
		}
	}
	
	public void set(int index, Integer x) {
		// index out of bound
		if(index < 0 || index > numItems -1) {
			System.out.println("[set] Index Out Of Bound Exception");
			return;
		}	else {
			item[index] = x;
		}
	}
	
	private final int NOT_FOUND = -12345;
	public int indexOf(Integer x) {
		// find x
		int k = 0;
		while(k < numItems && item[k].compareTo(x) != 0) {
			k++;
		}
		if(k == numItems) {
			System.out.println("[indexOf] That Item Not Existing Exception");
			return NOT_FOUND;
		}	else {
			return k;
		}
	}
	
	public int len() {
		return numItems;
	}
	
	public boolean isEmpty() {
		return numItems == 0;
	}
	
	public void clear() {
		item = new Integer[item.length];
		numItems = 0;
	}
	
	public String summary() {
		return Arrays.toString(item);
	}
}
