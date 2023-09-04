package programmers_lv2;

public class Solution39 {
	int len = 11, maxDiff = 0;
	int[] maxRyan = new int[len];

	public int[] solution(int n, int[] info) {
		int[] ryan = new int[len];
		getArcheryScore(n, info, ryan, 0); // �ε������� ����

		return maxDiff > 0 ? maxRyan : new int[] { -1 };
		// 0���� ũ�� �󸮾� �迭 �׷��� ������ -1
	}

	private void getArcheryScore(int n, int[] info, int[] ryan, int score) {
		if (n == 0 || score == len) {
			// ȭ���� �����߰ų� ���ھ� �ٱ����� ������ ���
			setMaxRyanDiff(info, ryan);
			return;
		}

		int arrow = 0;
		if (info[score] < n) {
			// ȭ���� ���� ���� ������
			arrow = info[score] + 1;
			// ȭ����
		} else if (score == len - 1) {
			arrow = n;
			// 10���� �� ȭ���� ���� ����
		}

		int tmp = info[score]; // ����ġ�� ����
		if (arrow > 0) {
			// ȭ�� ����
			info[score] = 0; // ����ġ ���� 0
			ryan[score] = arrow;
			getArcheryScore(n, info, ryan, score + 1); // �������� ���
		}
	}

	private void setMaxRyanDiff(int[] info, int[] ryan) {
		int sum = 0;
		// ����ġ ���̾��� ���� �� ���
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
