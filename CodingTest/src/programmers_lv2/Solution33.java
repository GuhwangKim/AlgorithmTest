package programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution33 {
	public static void main(String[] args) {

		Solution33 s = new Solution33();
		int[] arr = { 5, 4, 3, 2, 1 };

		s.solution(arr);

	}

	public int solution(int[] order) {
		int answer = 0;
		/**
		 * 보조 컨테이너 = stack 자료형 1 ~ order의 길이 만큼
		 */

		int originOrder = 1;
		int orderIdx = 0;

		Stack<Integer> stack =  new Stack<Integer>();

		while (true) {
			if (!stack.isEmpty() && order[orderIdx] == stack.peek()) {
				// stack 에 집어넣은 수와 같을 때
				stack.pop();
				// stack 에서 뽑아냄
				orderIdx++;
				// 집어넣었기 때문에 증가
				answer++;
				continue;
			}
			if (originOrder > order.length) {
				break;
				// 순서의 수 > 배열의 수 일 때 stop
			}

			
			if (order[orderIdx] == originOrder) {
				// 원래 순서와 같을 때
				originOrder++;
				orderIdx++;
				answer++;
				continue;

			}

		
			stack.push(originOrder);
			// 해당하는 것이 없으면 stack 에 집어넣음
			originOrder++;
			// 순서는 증가함
		}

		return answer;
	}
}
