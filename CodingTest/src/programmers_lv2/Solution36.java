package programmers_lv2;

import java.util.HashMap;

public class Solution36 {

	public static void main(String[] args) {
		String[] want = { "banana", "apple", "rice", "pork", "pot" };
		int[] number = { 3, 2, 2, 2, 1 };
		String[] discount = { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
				"pot", "banana", "apple", "banana" };

		Solution36 s = new Solution36();
		s.solution(want, number, discount);

	}

	int answer;

	public int solution(String[] want, int[] number, String[] discount) {
		answer = 0;

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < want.length; i++) {
			map.put(want[i], number[i]);
		}

		for (int i = 0; i <= discount.length - 10; i++) {
			calculate(discount, i, map);
		}
		return answer;
	}

	private void calculate(String[] discount, int idx, HashMap<String, Integer> map) {

		int cnt = 1; // 첫째날 10일동안 연속으로 계속될 예정

		while (cnt <= 10) {
			if (null == map.get(discount[idx])) {
				idx++;
				cnt++;
				continue;
			}
			if (map.get(discount[idx]) == 0) {
				map.remove(discount[idx]);
				// 값을 다 썼다면 없애버림
			}
			if (map.containsKey(discount[idx])) {
				// map에 key에 존재하는 게 있다면
				int value = map.get(discount[idx]);

				map.put(discount[idx], value - 1);
				// 하나를 빼서 put 에 넣어줌
			}
			idx++;
			cnt++;
		}
		if (map.size() == 0) {
			answer++;
			// map이 없다면 다 산것이므로 더함
			return;
		}

	}

}
