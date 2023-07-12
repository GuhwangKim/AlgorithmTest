package programmers_kit.repeat;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap2 {
	public int solution(int[][] jobs) {

		/**
		 * 끝 수로 정렬 앞수와 끝수를 비교해서 기준값을 바꿔주기
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
//		// 오름차순 정렬 
		int answer = 0;
		while (!queue.isEmpty()) {
			if (answer <= queue.peek()[0]) {
				// 전끝 <= 후앞
				answer += queue.poll()[1];
				// 후 끝을 더함
			} else {
				// 전끝 > 후앞 (= 전 프로세스가 작동하는 순간 시작하는 게 있음)
				answer += (queue.peek()[1] - queue.poll()[0]);

			}
		}
		

		return answer / jobs.length;;
	}
}
