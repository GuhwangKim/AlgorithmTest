package programmers_kit.repeat;

import java.util.Stack;
/**
 * !stack.isEmpty() && 해당 부분이 조건으로 삽입되면서 런타임 에러가 방지됨 
 * => 아무것도 없는 상황에서 ) 가 들어가면 false가 떠야하기 때문 
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
