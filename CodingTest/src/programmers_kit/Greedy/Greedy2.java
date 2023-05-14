package programmers_kit.Greedy;

public class Greedy2 {
	public String solution(String number, int k) {
		int startIdx = 0;
		int maxIdx = 0;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < number.length() - k; i++) {
			// 1. 자리수 (인덱스는 하나 빼야하므로 포함 안함)
			int max = 0;
			if (startIdx < number.length()) {
				for (int j = startIdx; j <= i + k; j++) {
					int current = number.charAt(j) - '0';
					// 2. i ~ k 까지의 값 중 가장 큰 것 집어 넣음, 한칸식 밀려감
					// 3. 그러나 그 시작이 가장 큰 값의 인덱스 그 다음

					if (max < current) {
						max = current;
						maxIdx = j;
						// 가장 큰 값이 있었던 인텍스의 위치를 담아둠
					}
				}
				str.append(max);
				// 인덱스 ~ k 중 가장 큰 값을 버퍼에 집어넣음
				startIdx = maxIdx + 1;
				// 4. 그 다음 수 비교의 시작 시점은 마지막 idx 의 +1
			}

		}
		return str.toString();
	}

}
