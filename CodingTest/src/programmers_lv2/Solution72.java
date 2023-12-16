package programmers_lv2;

import java.util.*;

public class Solution72 {

	public String[] solution(String[] files) {
		String[] answer = new String[files.length];
		// number�� �������� ����

		String[][] list = new String[files.length][3]; // ���

		int idx = 0;
		for (String file : files) {
			// ���ڰ� ������ ���۰� �� �ε����� ã��
			int startIdx = -1;
			int endIdx = -1;
			// ó���� ǥ���ϴ� �±�
			boolean first = true;
			// ������ �ε����� ã�� ���� size
			int size = 0;

			for (int i = 0; i < file.length(); i++) {
				if (Character.isDigit(file.charAt(i))) {
					// ���� ���� ���ڶ��
					if (first) {
						// ���� ���� �ʱ� ����
						startIdx = i;
						first = false;
					}
					size++;
				} else {
					// ���ڰ� �ƴ�
					if (!first) {
						break;
					}
				}
			}

			endIdx = startIdx + size - 1;

			String name = file.substring(0, startIdx);
			String number = file.substring(startIdx, endIdx + 1);
			String tail = file.substring(endIdx + 1);

			list[idx][0] = name;
			list[idx][1] = number;
			list[idx][2] = tail;
			idx++;
		}

		Arrays.sort(list, (o1, o2) -> {
			if (o1[0].toLowerCase().compareTo(o2[0].toLowerCase(Locale.ROOT)) > 0) {
				// �ҹ��ڷ� �ٲ㼭 ��������
				return 1;
			} else if (o1[0].toLowerCase().compareTo(o2[0].toLowerCase(Locale.ROOT)) < 0) {
				return -1;
			} else {
				// �� ������ ���ڷ� ����
				if (Integer.parseInt(o1[1]) > Integer.parseInt(o2[1])) {
					return 1;
				} else if (Integer.parseInt(o1[1]) < Integer.parseInt(o2[1])) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		for (int i = 0; i < answer.length; i++) {
			answer[i] = list[i][0] + list[i][1] + list[i][2];
		}

		return answer;
	}
}
