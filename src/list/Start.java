package list;

public class Start {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		LinkedListIterator<Integer> iter = new LinkedListIterator(list);
		
		list.add(0, 300);
		list.add(0, 200);
		list.add(0, 100);
		
		list.append(500);
		list.append(600);
		
		list.remove(3);
		list.add(3, 250);
		list.add(1, 50);
		list.add(0, 10);
		
		while(iter.hasNext()) {
			System.out.println(iter.next().item);
		}
		
		list.remove(1);
		list.removeItem(600);
		
		System.out.println();
		System.out.println("--------------------------------------------------------");
		System.out.println();
		
		iter = new LinkedListIterator(list);
		while(iter.hasNext()) {
			System.out.println(iter.next().item);
		}
		
		
	}
}
