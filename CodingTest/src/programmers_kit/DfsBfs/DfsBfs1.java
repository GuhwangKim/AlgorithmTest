package programmers_kit.DfsBfs;

public class DfsBfs1 {
	static int answer = 0;

	public int solution(int[] numbers, int target) {
		BFS(numbers, 0, target, 0);
		return answer;
	}

	public void BFS(int[] numbers, int idx, int target, int sum) {
		if (idx == numbers.length) {
			// 마지막 노드인 경우
			if (target==sum) {
				answer++;
				return;
			}
		} else {
			BFS(numbers, idx + 1, target, sum + numbers[idx]);
			// idx 는 1개 더하고, sum에는 지금 있는 메소드의 연산값을 더함
			BFS(numbers, idx + 1, target, sum - numbers[idx]);
		}


	}

}
