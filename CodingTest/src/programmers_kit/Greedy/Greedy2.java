package programmers_kit.Greedy;

public class Greedy2 {
	public String solution(String number, int k) {
		int startIdx = 0;
		int maxIdx = 0;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < number.length() - k; i++) {
			// 1. �ڸ��� (�ε����� �ϳ� �����ϹǷ� ���� ����)
			int max = 0;
			if (startIdx < number.length()) {
				for (int j = startIdx; j <= i + k; j++) {
					int current = number.charAt(j) - '0';
					// 2. i ~ k ������ �� �� ���� ū �� ���� ����, ��ĭ�� �з���
					// 3. �׷��� �� ������ ���� ū ���� �ε��� �� ����

					if (max < current) {
						max = current;
						maxIdx = j;
						// ���� ū ���� �־��� ���ؽ��� ��ġ�� ��Ƶ�
					}
				}
				str.append(max);
				// �ε��� ~ k �� ���� ū ���� ���ۿ� �������
				startIdx = maxIdx + 1;
				// 4. �� ���� �� ���� ���� ������ ������ idx �� +1
			}

		}
		return str.toString();
	}

}
