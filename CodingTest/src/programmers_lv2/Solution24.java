package CodingTest.src.programmers_lv2;

public class Solution24 {
	public int solution(int storey) {
		int answer = 0;
		// �ڸ������ ���ڸ� ��� ���ͼ� �׸�ŭ �����ָ� ��
		// �ڱ⺸�� �տ� �ִ� �ڸ����� +1 �� �ϸ� ��
		// �迭�� ����� ���
		String numToString = String.valueOf(storey);
		int[] nums = new int[numToString.length()];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = numToString.charAt(i) - '0';
		}

		// ���ڸ�����
		for (int i = nums.length - 1; i >= 0; i--) {

			if (nums[i] > 5) {
				answer += (10 - nums[i]);
				// �ٷ� ���ڸ� ���� �ϳ� ���������
				if (i == 0) {
					// �ٷ� ���ڸ��� ���� ���
					answer++;
					// 0�� �ϳ� �� ���� �� �ѹ��� �߰��ϸ� ��
				} else {
					nums[i - 1]++;
				}

			} else if (nums[i] == 5 && nums[i-1]>=5) {
				// ���� ���� 5 �̻��� ��쿡
				nums[i-1]++;
				// �տ��� �ѹ��� ������ �Ʒ��� �������� �� ���� 
				answer += nums[i];

			} else {
				answer += nums[i];

			}
		}

		return answer;
	}
}
