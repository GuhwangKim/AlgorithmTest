

package programmers_lv2;

import java.util.Stack;

public class Solution18 {
	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		
		
		/**
		 * stack �� �ε����� ���� �ִ´�.  
		 * */
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = numbers.length-1; i >=0 ; i--) {
			// 1. �Ųٷ� ������ 
			while(!stack.isEmpty()) {
				if(stack.peek()>numbers[i]) {
					// 4. stack �� ����Ǿ� �ִ� ���� ������ �Ǵ� ������ ũ�ٸ� ���ǿ� ������ ��� 
					answer[i] = stack.peek();
					// 5 �� �� �������� �־��ְ� 
					break;
				}
				stack.pop();
				//6 �ڿ��ִ� �� ���� ���ϱ� ������ ���ǿ� �� �´� ���̸� ������ ��, 
				// ������ ���� �� ���� ���� ���̸� �տ� �ִ� ���� ū ���� ���� ���� �Ǳ� ����
			}
			
			if(stack.isEmpty()) {
				// 2. stack �� ����ٸ� �ڱ� ���� ū ���� ���ٴ� �� 
				// �ڱ⺸�� ū ���� ���� �� pop()�� ������ 
				answer[i]=-1;
			}
			
			stack.add(numbers[i]);
			// 3. ������ ���� ������ �� 
			
		}
		
		return answer;
	}

}
