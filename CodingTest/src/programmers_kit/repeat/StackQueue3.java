package programmers_kit.repeat;

import java.util.Collections;
import java.util.PriorityQueue;

public class StackQueue3 {

	public int solution(int[] priorities, int location) {
		int answer = 0;

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		// queue 에 값을 담기
		for (int i = 0; i < priorities.length; i++) {
			queue.add(priorities[i]);
		}

		// stream 뽑아내기
//        int maxNum = Arrays.stream(priorities).max().getAsInt();
		while (!queue.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {
				if (priorities[i] == queue.peek()) {
					// 최대 값이랑 같은 셈
					if (i == location) {
						// 찾던 값일 때 리턴 
						answer++;
						return answer;
					} else {
						// 아니라면 queue 에서 제거해주고 순서 하나 증가 
						queue.poll();
						answer++;
					}

				}
			}
		}

		return answer;
	}
}
