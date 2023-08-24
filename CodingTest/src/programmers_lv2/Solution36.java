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

		int cnt = 1; // ù°�� 10�ϵ��� �������� ��ӵ� ����

		while (cnt <= 10) {
			if (null == map.get(discount[idx])) {
				idx++;
				cnt++;
				continue;
			}
			if (map.get(discount[idx]) == 0) {
				map.remove(discount[idx]);
				// ���� �� ��ٸ� ���ֹ���
			}
			if (map.containsKey(discount[idx])) {
				// map�� key�� �����ϴ� �� �ִٸ�
				int value = map.get(discount[idx]);

				map.put(discount[idx], value - 1);
				// �ϳ��� ���� put �� �־���
			}
			idx++;
			cnt++;
		}
		if (map.size() == 0) {
			answer++;
			// map�� ���ٸ� �� ����̹Ƿ� ����
			return;
		}

	}

}
