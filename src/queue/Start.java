package queue;

public class Start {
	public static void main(String[] args) {
		ListQueue<String> q = new ListQueue<>();
		
		q.enqueue("HELLO");
		q.enqueue("JAVA");
		q.enqueue("Can I go to NAVER?");
		while(!q.isEmpty()) {
			System.out.println(q.dequeue());			
		}
	}
}
