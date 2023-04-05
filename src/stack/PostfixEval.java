package stack;

public class PostfixEval {
	public static void main(String[] args) {
		String postfix = "15 25 + 10 2 * -";
		System.out.println("Input string : " + postfix);
		int answer = evaluate(postfix);
		System.out.println("Answer : " + answer);
	}
	
	private static int evaluate(String postfix) {
		int A, B;
		LinkedStack<Integer> s = new LinkedStack<>();
		boolean digitPreviously = false;
		for(int i = 0; i < postfix.length(); i++) {
			char ch = postfix.charAt(i);
			if(Character.isDigit(ch)) {
				if(digitPreviously) {
					int tmp = s.pop();
					tmp = tmp*10 + (ch-'0');
					s.push(tmp);
				}	else s.push(ch - '0');
				digitPreviously = true;
				
			}	else if(isOperator(ch)) {
				A = s.pop();
				B = s.pop();
				int val = operate(A, B, ch);
				s.push(val);
			}	else digitPreviously = false;
		}
		return s.pop();
	}
	
	private static int operate(int A, int B, char ch) {
		int val = 0;
		switch(ch) {
			case '+':
				val = B + A;
				break;
			case '-':
				val = B - A;
				break;
			case '*':
				val = B * A;
				break;
			case '/':
				val = B / A;
				break;
		}
		return val;
	}
	
	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}
}


