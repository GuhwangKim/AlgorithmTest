package algorithmTest;

import java.util.Scanner;
import java.util.Stack;

public class Section5_1 {

	private String T(String str) {
		String answer = "YES";
		Stack<Character> stack = new Stack<>();
		for(char x : str.toCharArray()) {
			if(x=='(') { // ���� ��ȣ 
				stack.push(x);
			} else { // �ݴ� ��ȣ 
				// 1) �� ��� -> ����
				if(stack.isEmpty())	answer = "NO";
				// 2) ���� ��ȣ�� �ִ� ���
				stack.pop();
			}
		}
		// ������� ���� ��� 
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
