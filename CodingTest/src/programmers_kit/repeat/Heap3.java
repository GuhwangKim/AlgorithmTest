package programmers_kit.repeat;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap3 {
	public static int[] solution(String[] operations) {
		/**
		 * 2개의 queue 를 만들어서 각자에서 빼고 더하는 과정을 반복함
		 * 해당 queue 에 대해 최대 최소 값을 구함 
		 * 
		 * */
		int[] answer = new int[2];
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(); // 오름차순
		PriorityQueue<Integer> queueMax = new PriorityQueue<Integer>(Collections.reverseOrder()); // 내림차순

		for (String operation : operations) {
			if (operation.contains("I")) {
				String[] string = operation.split(" ");
				queue.add(Integer.parseInt(string[1]));
				queueMax.add(Integer.parseInt(string[1]));
				continue;
				// I를 포함하면 집어넣음
			}

			if (queue.size() < 1) {
				// 아무것도 없는 경우에는 다음 것부터
				continue;
			} else if (operation.contains("-1")) {
				// 최소값 빼기
				int min = queue.poll();
				queueMax.remove(min);
			} else {
				// 최대값 빼기 : 큐에서 최대값을 어떻게 뺌?
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
