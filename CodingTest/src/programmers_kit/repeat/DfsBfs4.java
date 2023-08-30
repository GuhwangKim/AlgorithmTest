package programmers_kit.repeat;

public class DfsBfs4 {
	static int answer;
	static boolean[] visited;

	public int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
		// word 리스트에 표시가 되었나 확인
		answer = 51;
		// 최대값을 잡아놓고 최소값을 구함

		DFS(begin, target, words, 0);

		return answer;
	}

	private void DFS(String begin, String target, String[] words, int cnt) {
		if (cnt > answer) {
			// 현재 최소값인 answer 보다 넘어온 cnt 가 크다면 굳이 연산해줄 필요 없음
			return;
		}
		if (begin.equals(target)) {
			// 같다면
			answer = Math.min(cnt, answer);
			return;
		}
		for (int i = 0; i < words.length; i++) {
			// word list 에 있는 글자 하나하나를 뽑아냄
			if (visited[i]) {
				// 방문을 한경우 건너뜀
				continue;
			}
			int k = 0;
			for (int j = 0; j < words.length; j++) {
				if (begin.charAt(i) == words[i].charAt(i)) {
					k++; // 글자 하나하나를 비교해서 같으면 하나씩 더함
				}
			}

			if (k == begin.length() - 1) {
				// 한번에 알파벳 한개만 변경할 수 있다 = 1개 빼고 다 같다 = k의 길이는 주어진 단어 -1
				visited[i] = true;
				// 해당 단어 방문
				DFS(words[i], target, words, cnt + 1);
				visited[i] = false;
			}
		}

	}

}
