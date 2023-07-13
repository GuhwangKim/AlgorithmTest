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
		 * 끝 수로 정렬 앞수와 끝수를 비교해서 기준값을 바꿔주기
		 * 
		 */
		
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1, o2) -> o1[1]-o2[1]);

		for (int[] arr : jobs) {
			queue.add(arr);
		}

//		Arrays.asList(jobs).sort((o1, o2) ->o1[1]-o2[1]);
//		// 오름차순 정렬 
		int answer = 0;
		int standNum = 0;
		int cnt = 0;
//		while (!queue.isEmpty()) {
//			int num = queue.peek()[1];
//			if (standNum <= queue.peek()[0]) {
//				// 전끝 <= 후앞
//				answer += queue.poll()[1];
//				// 후 끝을 더함
//			} else {
//				// 전끝 > 후앞 (= 전 프로세스가 작동하는 순간 시작하는 게 있음)
//				answer += (standNum-queue.peek()[0])+queue.poll()[1];
//
//			}
//			standNum += num;
//		}
		while(cnt < jobs.length) {
			if(queue.isEmpty()) {
				// 처음
			}
		}

		return answer / jobs.length;
	}
}
