package stack;

public class Start {
	public static void main(String[] args) {
		LinkedStack<String> s = new LinkedStack<>();
		s.push("hello");
		s.push("SNU");
		s.push("Java is fuck");
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
