package programmers_lv2;

public class Solution39 {
	int max;
	int len = 11;
	int[] maxRyan = new int[len];

	public int[] solution(int n, int[] info) {
		DFS(0, n, 0, new int[n], info);
		// max == 0 �̶�� ���̾��� �̱��� ���� 
		
		
		return max == 0? new int[] {-1} : maxRyan;
		
	}

	private void DFS(int start, int rest, int idx, int[] result, int[] info) { // result�� ȭ���� ���� ��ŭ 
		if(idx == rest) {
			// ȭ���� ���� ���� ��ŭ ���� 
			int[] info2 = new int[len];
			for(int score : result) {
				// ���̾��� ȭ�� ���� ������ �迭�� ������� ex 7��  -> 3�� �ε��� 
				info2[10-score]++;
			}
			
			int ryan = 0;
			int apeach = 0;
			
			for (int i = 0; i < 11; i++) {
				//info[0] = 10 / info[1] = 9
				int score = 10-i;
				if(info2[i] > info[i]) {
					// ���� ������ ������ ���̾��� �� Ŭ �� 
					ryan += score;
					// ���̾��� ���� ���� 
				} else if (info2[i] < info[i]) {
					// ������ ������ ����ġ�� �� Ŭ �� 
					apeach += score;
					// ����ġ�� ���� ���� 
				} else if (info[i]!=0 && info2[i]==info[i]) {
					// ����ġ ������ ������ �ִµ�, ������ ������ ���� ��
					apeach += score;
					// ����ġ�� ���� ���� 
					
				}
			}
			if(ryan-apeach>max) {
				max = ryan-apeach;
				// ���̾�� ����ġ�� ������ ���� ���� ũ�� = ���̾��� �� ���� �������� �̱�� 
				maxRyan = info2;
			}
			return;
		}
		for (int i = start; i < 11; i++) {
			// ���� Ž�� start 0 �϶� 0 �ε��� �� 10���� 0 �� -> idx�� n ȭ�캸�� ���� ��쿡 
			result[idx] = i;
			DFS(i, rest, idx+1, result, info);
		}
	}

}
