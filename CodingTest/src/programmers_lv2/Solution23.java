package CodingTest.src.programmers_lv2;

public class Solution23 {
	int subs = 0;
	int purchase = 0;
	public int[] solution(int[][] users, int[] emoticons) {
		int[] answer = new int[2];

		int[] disPercent = new int[emoticons.length];
		// �������� ����� �̸�Ƽ���� ������ ����� 
		
		comb(disPercent, 0, users, emoticons);

		answer[0] = subs;
		answer[1] = purchase;

		return answer;
	}
	
	private void comb(int[] disPercent, int startIdx, int[][] users, int[] emoticons) {
		if(startIdx == disPercent.length) {
			// 10 10 10 10 ���� ä�����ٸ�, 
			calculate(disPercent, users, emoticons);
			return;
		}
		
		for (int i = 10; i <= 40; i+=10) {
			disPercent[startIdx] = i;
			// 0 ~ 3 ���� ��� 10���� (20, 30, 40) ä���� 
			comb(disPercent, startIdx+1, users, emoticons);
			// 
		}
		
	}

	public void calculate (int[] disPercent, int[][] users, int[] emoticons) {
		int count = 0;
		int earn = 0;
		for (int i = 0; i < users.length; i++) {
			int sum = 0;

			for (int j = 0; j < disPercent.length; j++) {
				if(disPercent[j] >= users[i][0]) {
					// users[i][0] �̻��� ��ǰ�鸸 �����ϱ� ������ 
					sum+=(emoticons[j]/100)*(100-disPercent[j]);
				}
			}

			if (sum >= users[i][1]) {
				count++;
			} else {
				earn += sum;
			}
		}
		if(count>subs) {
			subs= count;
			// �����ڼ��� �� ũ�� ��ȯ�� 
			purchase = earn;
			return;
		}else if (count==subs) {
			if(purchase<earn) {
				// ������ ���� ������ ���̰� �� ū ��� 
				purchase = earn;
			}
		}
	}
}