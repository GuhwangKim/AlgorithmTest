package programmers_lv2;

import java.util.Stack;

public class Solution41 {

	public String solution(int n, int k, String[] cmd) {
		Stack<Integer> removeHistory = new Stack<Integer>();

		int table_size = n;
		for (String each : cmd) {
			char c = each.charAt(0);
			if (c == 'D') {
				// �Ʒ���
				k += Integer.parseInt(each.substring(2));

			} else if (c == 'U') {
				k -= Integer.parseInt(each.substring(2));

			} else if (c == 'C') {
				removeHistory.add(k);
				// ������ �ε��� �������
				table_size--;
				// �ϳ� ������
				if (k == table_size) {
					// ���� ���� ���� ��
					k--;
					// ������ġ���� �Ѵܰ� �ö�
				}

			} else if (c == 'Z') {
				if (removeHistory.pop() <= k) {
					// �����ϴ� �ε����� ���� �ε������� ���� ���� �����
					k++;
				}
				table_size++;
				// ���� ����� Ŀ��
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
