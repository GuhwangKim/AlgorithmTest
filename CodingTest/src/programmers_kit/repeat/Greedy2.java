package programmers_kit.repeat;

public class Greedy2 {

	public String solution(String number, int k) {
		int startIdx = 0;
		int maxIdx = 0;

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < number.length()-k; i++) {
			int max = 0;

			if(startIdx < number.length()) {
				for (int j = startIdx; j <= i+k; j++) {
					// startIdx ~ 끝까지 탐색함
					// i+k 자리수를 기준으로 한칸씩 밀려남
					// 그만큼 까지에서 가장 큰 수를 구하고,
					int current = number.charAt(j) - '0';

					if(max<current) {
						max = current;
						maxIdx = j;
					}

				}
				stringBuilder.append(max);
				startIdx = maxIdx +1;
			}
		}
		return stringBuilder.toString();

	}
}
