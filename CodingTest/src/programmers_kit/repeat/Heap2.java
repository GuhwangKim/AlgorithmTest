package programmers_kit.repeat;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap2 {
	public static void main(String[] args) {
		
		int[][] example = {{0, 3}, {1, 9}, {2, 6}};
		Heap2 h = new Heap2();
		h.solution(example);
		
	}
	public int solution(int[][] jobs) {

		/**
		 * �� ���� ���� �ռ��� ������ ���ؼ� ���ذ��� �ٲ��ֱ�
		 * 
		 */
		
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1, o2) -> o1[1]-o2[1]);

		for (int[] arr : jobs) {
			queue.add(arr);
		}

//		Arrays.asList(jobs).sort((o1, o2) ->o1[1]-o2[1]);
//		// �������� ���� 
		int answer = 0;
		int standNum = 0;
		int cnt = 0;
//		while (!queue.isEmpty()) {
//			int num = queue.peek()[1];
//			if (standNum <= queue.peek()[0]) {
//				// ���� <= �ľ�
//				answer += queue.poll()[1];
//				// �� ���� ����
//			} else {
//				// ���� > �ľ� (= �� ���μ����� �۵��ϴ� ���� �����ϴ� �� ����)
//				answer += (standNum-queue.peek()[0])+queue.poll()[1];
//
//			}
//			standNum += num;
//		}
		while(cnt < jobs.length) {
			if(queue.isEmpty()) {
				// ó��
			}
		}

		return answer / jobs.length;
	}
}
