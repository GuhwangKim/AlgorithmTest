

package programmers_lv2;

import java.util.Stack;

public class Solution18 {
	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		
		
		/**
		 * stack 에 인덱스를 집어 넣는다.  
		 * */
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = numbers.length-1; i >=0 ; i--) {
			// 1. 거꾸로 시작함 
			while(!stack.isEmpty()) {
				if(stack.peek()>numbers[i]) {
					// 4. stack 에 저장되어 있는 수가 기준이 되는 수보다 크다면 조건에 만족한 경우 
					answer[i] = stack.peek();
					// 5 그 때 정답으로 넣어주고 
					break;
				}
				stack.pop();
				//6 뒤에있는 수 부터 비교하기 때문에 조건에 안 맞는 값이면 지워도 됨, 
				// 어차피 기준 값 보다 작은 값이면 앞에 있는 값의 큰 값이 기준 값이 되기 때문
			}
			
			if(stack.isEmpty()) {
				// 2. stack 이 비었다면 자기 보다 큰 수가 없다는 것 
				// 자기보다 큰 수가 없을 때 pop()를 진행함 
				answer[i]=-1;
			}
			
			stack.add(numbers[i]);
			// 3. 현재의 수가 기준이 됨 
			
		}
		
		return answer;
	}

}
