package programmers_lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution36 {
	public int[] solution(int[] arr) {
		int[] answer = {};
		if (arr.length == 1) {
			answer = new int[1];
			answer[0] = -1;
		} else {
			answer = new int[arr.length - 1];
		}

		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list1 = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}

		Collections.sort(list);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < list.size(); j++) {
				if (arr[i] == list.get(j)) {
					list1.add(arr[i]);
				}
			}
		}

		for (int i = 0; i < list1.size(); i++) {
			answer[i] = list1.get(i);
		}

		return answer;
	}

}
