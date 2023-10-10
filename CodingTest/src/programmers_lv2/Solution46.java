package programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution46 {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
        	// 1. 총 5번을 진행함, 첫번째수를 가장 끝으로 보내는 일 
        	Stack<Character> stack = new Stack<Character>();
            
            for (int j = 0; j < s.length(); j++) {
            	// 3. 처음부터 돌면서 조건에 만족하는지 확인함 
            	char compare = s.charAt(j);
            	if(stack.isEmpty()) {
            		if(compare==')' || compare=='}' || compare== ']') {
            			break; // 조건에 만족하지 않는 경우, 조건문 탈출 
            		} else {
                        // 2. 가장 첫번째 수를 집어넣음 
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
			// 4. 0번쨰 있는 것을 가장 마지막으로 이동시킴
			s = s.substring(1, s.length()) + s.charAt(0);
			
        }
        return answer;
    }


}
