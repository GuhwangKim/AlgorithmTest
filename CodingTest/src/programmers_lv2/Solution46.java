package programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution46 {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
        	// 1. �� 5���� ������, ù��°���� ���� ������ ������ �� 
        	Stack<Character> stack = new Stack<Character>();
            
            for (int j = 0; j < s.length(); j++) {
            	// 3. ó������ ���鼭 ���ǿ� �����ϴ��� Ȯ���� 
            	char compare = s.charAt(j);
            	if(stack.isEmpty()) {
            		if(compare==')' || compare=='}' || compare== ']') {
            			break; // ���ǿ� �������� �ʴ� ���, ���ǹ� Ż�� 
            		} else {
                        // 2. ���� ù��° ���� ������� 
                        stack.add(compare);
            		}
            	}
            	
				if(stack.peek()=='(' && compare==')') {
					stack.pop();
					continue;
				} else if (stack.peek()=='{' && compare=='}') {
					stack.pop();
					continue;
				} else if (stack.peek()=='[' && compare==']') {
					stack.pop();
					continue;
				}
			}
			
			if(stack.size()==0) {
				answer++;
			}
			// 4. 0���� �ִ� ���� ���� ���������� �̵���Ŵ
			s = s.substring(1, s.length()) + s.charAt(0);
			
        }
        return answer;
    }


}
