package heap;

public class Start {
	public static void main(String[] args) {
		Integer[] arr = {50, 30, 48, 12, 94};
		
		Heap<Integer> h = new Heap<>(arr, 5);
		
		try {
//			h.insert(1);
//			h.insert(10);
//			h.clear();
//			h.insert(30);
//			h.insert(10);
//			h.insert(20);
//			h.insert(40);
//			h.insert(50);
//			h.deleteMax();
//			h.insert(60);
			
			while(!h.isEmpty()) {
				System.out.print(h.deleteMax() + " ");
			}
			
		}	catch(PQException e) {
			String msg = e.getMessage();
			System.out.println(msg);
		}
	}
}
