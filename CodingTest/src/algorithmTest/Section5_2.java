package algorithmTest;

import java.util.Scanner;
import java.util.Stack;

public class Section5_2 {

	private String T(String str) {
		String answer = "";
		
		Stack<Character> stack = new Stack<>();
		
		for(char x : str.toCharArray()) {
			if(x==')') {
				while(stack.pop()!='(');
			}else {
				stack.push(x);
			}
			
		}
		for(char c : stack) {
			answer+=c+" ";
		}
 		return answer;
	}

	public static void main(String[] args) {
		Section5_2 section = new Section5_2();
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println(section.T(str));
	}

}
