package ds.stackqueue;

import java.util.Stack;

public class BalancedBrackets {

	public static void main(String[] args) {
		String string = "((())(()))";
		Stack<String> stack = new Stack<String>();
		int balanced = 0;
		
		for (int i = 0; i < string.length(); i++) {
			String s = Character.toString(string.charAt(i));
			if ("(".equals(s)) {
				stack.push(s);
				++balanced;
			} else if (!stack.empty()) {
				stack.pop();
				--balanced;
			}
		}

		System.out.println("Balanced: " + balanced);
	}
}
