package programmers_kit.StackQueue;

import java.util.Stack;


public class StackQueue1 {

	public int[] solution(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if(stack.isEmpty()||stack.peek()!=arr[i]) {
				stack.add(arr[i]);
			}
		}
		int[] answer = new int[stack.size()];
		
		for (int i = answer.length-1 ; i >= 0; i--) {
			answer[i]=stack.pop();
		}
		return answer;
	}
		

	
	public static void main(String[] args) {
		StackQueue1 t = new StackQueue1();
		int[] arr = new int[5];
		arr[0] = 4;
		arr[1] = 4;
		arr[2] = 4;
		arr[3] = 3;
		arr[4] = 3;
		for(int x : t.solution(arr)) {
			System.out.print(x+" ");
		}
	}
}
