package programmers_lv2;

public class Solution60 {
	public int solution(int[] stones, int k) {
		int answer = 0;
		int min = 1;
		int max = 200000000;

		// �ǳ� �� �ִ� �ο� max �� ������ ũ��
		while(min<=max){
			// �ǳ� �ο� �� �õ�
			int mid = (min + max) / 2;
			if(canAcrossRiver(stones, k, mid)){
				// �ǳ� �� �ִٸ� �� ���� �õ��غ�
				min = mid +1;
				answer = Math.max(answer, mid);

			}else{
				// �ǳ� �� ������ ����
				max = mid-1;
			}
		}
		return answer;
	}

	private boolean canAcrossRiver(int[] stones, int k, int friends) {
		int skip = 0;
		for (int stone : stones){
			if(stone - friends < 0){
				// 3���� �ǳʾ� �ϴµ� �������� ���� ������ ���� �װź��� �۴ٸ� �Ұ���
				skip++;
			}else{
				// 0 �̻��̸� �ǳ� �� ����, �ǳԴٸ� skip�� reset ��
				skip = 0;
			}
			if(skip == k) {
				// k ��ŭ �ǳʶپ����� �� �ǳ�
				return false;
			}
		}
		return true;
	}

}
