package algorithmTest;

import java.util.Scanner;
import java.util.Stack;

public class Section5_4 {
	private int T(char[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		for(char x : arr) {
			int a = stack.pop();
			int b = stack.pop();
			switch (x) {
			case '+':
				stack.add(b+a);
				break;
			case '-':
				stack.add(b-a);
				break;
			case '*':
				stack.add(b*a);
				break;
			case '/':
				stack.add(b/a);
				break;
			default:
				int num = x-'0';
				stack.push(num);
				break;
			}
		}
		return stack.get(0);
	}

	public static void main(String[] args) {
		Section5_4 section = new Section5_4();
		Scanner in = new Scanner(System.in);
		String str = in.next();
		char[] arr = str.toCharArray();
		System.out.println(section.T(arr));
	}

}
