package programmers_kit.repeat;

import java.util.Collections;
import java.util.PriorityQueue;

public class StackQueue3 {

	public int solution(int[] priorities, int location) {
		int answer = 0;

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		// queue �� ���� ���
		for (int i = 0; i < priorities.length; i++) {
			queue.add(priorities[i]);
		}

		// stream �̾Ƴ���
//        int maxNum = Arrays.stream(priorities).max().getAsInt();
		while (!queue.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {
				if (priorities[i] == queue.peek()) {
					// �ִ� ���̶� ���� ��
					if (i == location) {
						// ã�� ���� �� ���� 
						answer++;
						return answer;
					} else {
						// �ƴ϶�� queue ���� �������ְ� ���� �ϳ� ���� 
						queue.poll();
						answer++;
					}

				}
			}
		}

		return answer;
	}
}
