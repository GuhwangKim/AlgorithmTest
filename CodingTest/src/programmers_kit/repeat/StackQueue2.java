package programmers_kit.repeat;

import java.util.Stack;
/**
 * !stack.isEmpty() && �ش� �κ��� �������� ���ԵǸ鼭 ��Ÿ�� ������ ������ 
 * => �ƹ��͵� ���� ��Ȳ���� ) �� ���� false�� �����ϱ� ���� 
 * */

public class StackQueue2 {
	boolean solution(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		if(s.charAt(0)==')' || s.length()%2!=0) {
			return false;
		} else {
			stack.add(s.charAt(0));
		}
		
		for (int i = 1; i < s.length(); i++) {
			if(!stack.isEmpty() && s.charAt(i)==')') {
				stack.pop();
			} else {
				stack.add(s.charAt(i));
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		}
		
		return false;
	}
}
