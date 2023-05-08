package programmers_kit.StackQueue;

import java.util.Stack;

public class StackQueue2 {
	public static void main(String[] args) {
		StackQueue2 s = new StackQueue2();
		s.solution("(())()");
	}
	boolean solution(String s) {
		Stack<Character> stack = new Stack<Character>();
		if (')' == s.charAt(0) || s.length()%2!=0) {
			return false;
		} else {
			stack.push(s.charAt(0));
		}

		for (int i = 1; i < s.length(); i++) {
			if (!stack.isEmpty() &&')' == s.charAt(i)) {
				stack.pop();
			} else if (stack.isEmpty() && ')' == s.charAt(i)) {
				return false;
			} else {
				stack.push(s.charAt(i));
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
