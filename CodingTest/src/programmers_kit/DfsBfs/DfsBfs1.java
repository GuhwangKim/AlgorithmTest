package programmers_kit.DfsBfs;

public class DfsBfs1 {
	static int answer = 0;

	public int solution(int[] numbers, int target) {
		BFS(numbers, 0, target, 0);
		return answer;
	}

	public void BFS(int[] numbers, int idx, int target, int sum) {
		if (idx == numbers.length) {
			// ������ ����� ���
			if (target==sum) {
				answer++;
				return;
			}
		} else {
			BFS(numbers, idx + 1, target, sum + numbers[idx]);
			// idx �� 1�� ���ϰ�, sum���� ���� �ִ� �޼ҵ��� ���갪�� ����
			BFS(numbers, idx + 1, target, sum - numbers[idx]);
		}


	}

}
