package CodingTest.src.programmers_kit.repeat;

public class Search3 {
	boolean[] visited;
	int answer = 0;
	public int solution(int k, int[][] dungeons) {
		/**
		 * current >= i0 -> - i1 소모 cnt ++ current < i0 라면 돌아옴 cnt 의 최대 값을 비교
		 *
		 * 루프의 제한 : cnt dungeon의 개수
		 */
		visited = new boolean[dungeons.length];
		int cnt = dungeons.length;

		DFS(k, dungeons, 0);

		return answer;
	}

	private void DFS(int k, int[][] dungeons, int depth) {

		// while 문만을 쓰게 되면 2번째 배열이 처음 시작이 되었을 경우, 1번째 배열의 값이 2번째에 어떻게 들어갈 수 있는지?
		// => 해답은 for visited로 검증해서 for 문 0부터 시작, 
		for (int i = 0; i < dungeons.length; i++) {
			if (!visited[i] && k >= dungeons[i][0]) {
				// 방문전, 현재피로 > 소모 피로
				visited[i] = true;
				DFS(k - dungeons[i][1], dungeons, depth + 1);
				visited[i] = false;
			}
			
			// 처음 배열에서부터 시작해서 노드 끝까지 타봄 
			answer = Math.max(depth, answer);
		}

	}
}
