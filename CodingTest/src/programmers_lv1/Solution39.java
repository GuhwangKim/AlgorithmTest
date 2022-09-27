package programmers_lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution39 {
	class Solution {
		public String[] solution(String[] strings, int n) {
			String[] answer = new String[strings.length];
			Arrays.sort(strings);

			Map<Integer, String> map = new HashMap<Integer, String>();

			for (int i = 0; i < strings.length; i++) {
				map.put(i, String.valueOf(strings[i].charAt(n)));
			}

			List<String> val = new ArrayList<String>(map.values());

			Collections.sort(val);

			for (int i = 0; i < val.size(); i++) {
				for (int j = 0; j < map.size(); j++) {
					if (val.get(i) == map.get(j)) {
						answer[i] = strings[j];
					}
				}
			}

			return answer;
		}

	}

	public static void main(String[] args) {
		String[] strings = { "sun", "bed", "car" };
		String[] answer = new String[strings.length];
		int n = 1;

		Map<Integer, String> map = new HashMap<Integer, String>();

		for (int i = 0; i < strings.length; i++) {
			map.put(i, String.valueOf(strings[i].charAt(n)));
		}

		List<String> val = new ArrayList<String>(map.values());

		Collections.sort(val);

		for (int i = 0; i < val.size(); i++) {
			for (int j = 0; j < map.size(); j++) {
				if (val.get(i) == map.get(j)) {
					answer[i] = strings[j];
				}
			}
		}

	}

}
