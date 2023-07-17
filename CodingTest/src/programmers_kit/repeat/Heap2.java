package programmers_kit.repeat;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap2 {
	public int solution(int[][] jobs) {

		/**
		 * �� ���� ���� �ռ��� ������ ���ؼ� ���ذ��� �ٲ��ֱ�
		 * 
		 */
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});

		for (int[] arr : jobs) {
			queue.add(arr);
		}

//		Arrays.asList(jobs).sort((o1, o2) ->o1[1]-o2[1]);
//		// �������� ���� 
		int answer = 0;
		while (!queue.isEmpty()) {
			if (answer <= queue.peek()[0]) {
				// ���� <= �ľ�
				answer += queue.poll()[1];
				// �� ���� ����
			} else {
				// ���� > �ľ� (= �� ���μ����� �۵��ϴ� ���� �����ϴ� �� ����)
				answer += (queue.peek()[1] - queue.poll()[0]);

			}
		}
		

		return answer / jobs.length;;
	}
}
