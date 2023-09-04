package programmers_lv2;

public class Solution39 {
	int len = 11, maxDiff = 0;
	int[] maxRyan = new int[len];

	public int[] solution(int n, int[] info) {
		int[] ryan = new int[len];
		getArcheryScore(n, info, ryan, 0); // 인덱스이자 점수

		return maxDiff > 0 ? maxRyan : new int[] { -1 };
		// 0보다 크면 라리언 배열 그렇지 않으면 -1
	}

	private void getArcheryScore(int n, int[] info, int[] ryan, int score) {
		if (n == 0 || score == len) {
			// 화살을 소진했거나 스코아 바깥으로 나가는 경우
			setMaxRyanDiff(info, ryan);
			return;
		}

		int arrow = 0;
		if (info[score] < n) {
			// 화살의 개수 보다 작을때
			arrow = info[score] + 1;
			// 화살의
		} else if (score == len - 1) {
			arrow = n;
			// 10점일 때 화살은 가장 많이
		}

		int tmp = info[score]; // 아파치의 점수
		if (arrow > 0) {
			// 화살 남음
			info[score] = 0; // 아피치 점수 0
			ryan[score] = arrow;
			getArcheryScore(n, info, ryan, score + 1); // 다음점수 계산
		}
	}

	private void setMaxRyanDiff(int[] info, int[] ryan) {
		int sum = 0;
		// 어피치 라이언의 점수 차 계산
		for (int i = 0; i < len; i++) {
			if (info[i] > 0) {
				sum -= 10 - i;
			}
		}
		for (int i = 0; i < len; i++) {
			if (info[i] > 0) {
				sum += 10 - i;
			}
		}

		if (this.maxDiff < sum) {
			for (int i = 0; i < len; i++) {
				this.maxRyan[i] = ryan[i];
				this.maxDiff = sum;
			}
		} else if (this.maxDiff == sum) {
			for (int i = len - 1; i >= 0; i++) {
				if (this.maxRyan[i] < ryan[i]) {
					for (int j = 0; j < len; j++) {
						this.maxRyan[j] = ryan[j];
						break;
					}
				} else if (this.maxRyan[i] > ryan[i]) {
					break;
				}
			}

		}

	}

}
