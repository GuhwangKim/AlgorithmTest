package programmers_kit.StackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StackQueue3 {

	public static void main(String[] args) {
		StackQueue3 h = new StackQueue3();
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };
		h.solution(progresses, speeds);
	}

	public List<Integer> solution(int[] progresses, int[] speeds) {
		List<Integer> answer = new ArrayList<>();
		/*
		 * 7, 3, 9 5, 10, 1, 1, 20, 1
		 * 
		 */
		Queue<Integer> queue = new LinkedList<>();

		 for (int i = 0; i < progresses.length; i++) {
	            if ((100 - progresses[i]) % speeds[i] == 0) {
	            	queue.add((100 - progresses[i]) / speeds[i]);
	            } else {
	            	queue.add((100 - progresses[i]) / speeds[i] + 1);
	            }
	        }

		int cnt = 1;
		int compare = queue.poll();
		while (!queue.isEmpty()) {
			if (compare>=queue.peek()) {
				cnt++;
				queue.poll();
			}else {
				answer.add(cnt);
				cnt = 1;
				compare = queue.poll();
			}
			
		}
		answer.add(cnt);
		return answer;
	}
}
