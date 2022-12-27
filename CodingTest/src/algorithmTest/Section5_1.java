package algorithmTest;

import java.util.Scanner;
import java.util.Stack;

public class Section5_1 {

	private String T(String str) {
		String answer = "YES";
		Stack<Character> stack = new Stack<>();
		for(char x : str.toCharArray()) {
			if(x=='(') { // 여는 괄호 
				stack.push(x);
			} else { // 닫는 괄호 
				// 1) 빈 경우 -> 거짓
				if(stack.isEmpty())	answer = "NO";
				// 2) 여는 괄호가 있는 경우
				stack.pop();
			}
		}
		// 비어있지 않은 경우 
		if(!stack.isEmpty()) {
			answer = "NO";
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Section5_1 section = new Section5_1();
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println(section.T(str));
	}
}
