package programmers_kit.repeat;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap3 {
	public static int[] solution(String[] operations) {
		/**
		 * 2���� queue �� ���� ���ڿ��� ���� ���ϴ� ������ �ݺ���
		 * �ش� queue �� ���� �ִ� �ּ� ���� ���� 
		 * 
		 * */
		int[] answer = new int[2];
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(); // ��������
		PriorityQueue<Integer> queueMax = new PriorityQueue<Integer>(Collections.reverseOrder()); // ��������

		for (String operation : operations) {
			if (operation.contains("I")) {
				String[] string = operation.split(" ");
				queue.add(Integer.parseInt(string[1]));
				queueMax.add(Integer.parseInt(string[1]));
				continue;
				// I�� �����ϸ� �������
			}

			if (queue.size() < 1) {
				// �ƹ��͵� ���� ��쿡�� ���� �ͺ���
				continue;
			} else if (operation.contains("-1")) {
				// �ּҰ� ����
				int min = queue.poll();
				queueMax.remove(min);
			} else {
				// �ִ밪 ���� : ť���� �ִ밪�� ��� ��?
				int max = queueMax.poll();
				queue.remove(max);
			}

		}

		if (queueMax.size() > 0) {
			answer[0] = queueMax.poll();
			answer[1] = queue.poll();
		}

		return null;

	}

}
