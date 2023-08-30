package programmers_kit.repeat;

public class DfsBfs4 {
	static int answer;
	static boolean[] visited;

	public int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
		// word ����Ʈ�� ǥ�ð� �Ǿ��� Ȯ��
		answer = 51;
		// �ִ밪�� ��Ƴ��� �ּҰ��� ����

		DFS(begin, target, words, 0);

		return answer;
	}

	private void DFS(String begin, String target, String[] words, int cnt) {
		if (cnt > answer) {
			// ���� �ּҰ��� answer ���� �Ѿ�� cnt �� ũ�ٸ� ���� �������� �ʿ� ����
			return;
		}
		if (begin.equals(target)) {
			// ���ٸ�
			answer = Math.min(cnt, answer);
			return;
		}
		for (int i = 0; i < words.length; i++) {
			// word list �� �ִ� ���� �ϳ��ϳ��� �̾Ƴ�
			if (visited[i]) {
				// �湮�� �Ѱ�� �ǳʶ�
				continue;
			}
			int k = 0;
			for (int j = 0; j < words.length; j++) {
				if (begin.charAt(i) == words[i].charAt(i)) {
					k++; // ���� �ϳ��ϳ��� ���ؼ� ������ �ϳ��� ����
				}
			}

			if (k == begin.length() - 1) {
				// �ѹ��� ���ĺ� �Ѱ��� ������ �� �ִ� = 1�� ���� �� ���� = k�� ���̴� �־��� �ܾ� -1
				visited[i] = true;
				// �ش� �ܾ� �湮
				DFS(words[i], target, words, cnt + 1);
				visited[i] = false;
			}
		}

	}

}
