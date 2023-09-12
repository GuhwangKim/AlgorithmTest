package programmers_kit.repeat;

import java.util.Arrays;

public class Greedy5 {
	public int solution(int[][] routes) {
		Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
		int answer = 1;
		int standard = routes[0][1];
		for (int i = 0; i < routes.length; i++) {
			if (standard >= routes[i][0]) {
				continue;
			} else {
				standard = routes[i][1];
				answer++;
			}
		}
		return answer;
	}
}
