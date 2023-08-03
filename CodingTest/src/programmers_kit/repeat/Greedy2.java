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
					// startIdx ~ ������ Ž����
					// i+k �ڸ����� �������� ��ĭ�� �з���
					// �׸�ŭ �������� ���� ū ���� ���ϰ�,
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
