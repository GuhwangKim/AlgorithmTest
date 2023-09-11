package programmers_lv2;

import java.util.Stack;

public class Solution41 {

	public String solution(int n, int k, String[] cmd) {
		Stack<Integer> removeHistory = new Stack<Integer>();

		int table_size = n;
		for (String each : cmd) {
			char c = each.charAt(0);
			if (c == 'D') {
				// 아래로
				k += Integer.parseInt(each.substring(2));

			} else if (c == 'U') {
				k -= Integer.parseInt(each.substring(2));

			} else if (c == 'C') {
				removeHistory.add(k);
				// 현재의 인덱스 집어넣음
				table_size--;
				// 하나 제거함
				if (k == table_size) {
					// 가장 끝에 있을 때
					k--;
					// 현재위치에서 한단계 올라감
				}

			} else if (c == 'Z') {
				if (removeHistory.pop() <= k) {
					// 복구하는 인덱스가 현재 인덱스보다 작을 때는 변경됨
					k++;
				}
				table_size++;
				// 공통 사이즈가 커짐
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < table_size; i++) {
			sb.append("O");
		}
		while (!removeHistory.isEmpty()) {
			sb.insert(removeHistory.pop().intValue(), "X");
		}

		return sb.toString();

	}

}
