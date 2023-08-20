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
		 * ���� �����̳� = stack �ڷ��� 1 ~ order�� ���� ��ŭ
		 */

		int originOrder = 1;
		int orderIdx = 0;

		Stack<Integer> stack =  new Stack<Integer>();

		while (true) {
			if (!stack.isEmpty() && order[orderIdx] == stack.peek()) {
				// stack �� ������� ���� ���� ��
				stack.pop();
				// stack ���� �̾Ƴ�
				orderIdx++;
				// ����־��� ������ ����
				answer++;
				continue;
			}
			if (originOrder > order.length) {
				break;
				// ������ �� > �迭�� �� �� �� stop
			}

			
			if (order[orderIdx] == originOrder) {
				// ���� ������ ���� ��
				originOrder++;
				orderIdx++;
				answer++;
				continue;

			}

		
			stack.push(originOrder);
			// �ش��ϴ� ���� ������ stack �� �������
			originOrder++;
			// ������ ������
		}

		return answer;
	}
}
