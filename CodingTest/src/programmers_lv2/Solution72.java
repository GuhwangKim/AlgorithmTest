package programmers_lv2;

import java.util.*;

public class Solution72 {

	public String[] solution(String[] files) {
		String[] answer = new String[files.length];
		// number를 기준으로 나뉨

		String[][] list = new String[files.length][3]; // 행렬

		int idx = 0;
		for (String file : files) {
			// 숫자가 나오는 시작과 끝 인덱스를 찾자
			int startIdx = -1;
			int endIdx = -1;
			// 처음을 표시하는 태그
			boolean first = true;
			// 마지막 인덱스를 찾기 위한 size
			int size = 0;

			for (int i = 0; i < file.length(); i++) {
				if (Character.isDigit(file.charAt(i))) {
					// 현재 값이 숫자라면
					if (first) {
						// 시작 값이 초기 상태
						startIdx = i;
						first = false;
					}
					size++;
				} else {
					// 숫자가 아님
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
				// 소문자로 바꿔서 오름차순
				return 1;
			} else if (o1[0].toLowerCase().compareTo(o2[0].toLowerCase(Locale.ROOT)) < 0) {
				return -1;
			} else {
				// 그 다음은 숫자로 정렬
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
