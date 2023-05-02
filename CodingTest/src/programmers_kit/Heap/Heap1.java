package programmers_kit.Heap;

import java.util.PriorityQueue;

public class Heap1 {

	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

		for (int num : scoville) {
			queue.add(num);
		}

		while (queue.peek() < K) {
			if (queue.size() == 1) {
				return -1;
			} else {
				queue.add(queue.poll() + (queue.poll() * 2));
				answer++;
			}
		}
		return answer;
	}

}
