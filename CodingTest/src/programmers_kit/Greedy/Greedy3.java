package programmers_kit.Greedy;

import java.util.Arrays;

public class Greedy3 {

	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);

		int min = 0;
		for (int max = people.length - 1; max >= min; max--) {
			// 최대값부터 더해주고

			if (people[max] + people[min] <= limit) {
				// 최대값과 최소값이 타게되므로 가장 작은 값도 한칸 뒤로 물러나야함
				min++;
			}
			// 한번 로직을 탈 때마다 보트는 1개씩 늘어남
			answer++;

		}

		return answer;
	}

}