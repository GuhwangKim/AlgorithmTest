package CodingTest.src.programmers_kit.repeat;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Greedy3 {
	public int solution(int[] people, int limit) {
		int answer = 0;

		Arrays.sort(people);
		int max = people.length - 1;
		int min = 0;
		for (int i = max; i >= min; i--) {
			int peopleCount = people[i]+people[min];
			answer++;
			if(peopleCount<=limit) {
				min++;
				// 여기서 더 태울 수 있을 때 어떻게 되는 거지?  한 번에 최대 2명씩
			}
		}

		return answer;
	}
}
