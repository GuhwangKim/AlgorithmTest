package CodingTest.src.programmers_kit.repeat;

public class Search3 {
	boolean[] visited;
	int answer = 0;
	public int solution(int k, int[][] dungeons) {
		/**
		 * current >= i0 -> - i1 �Ҹ� cnt ++ current < i0 ��� ���ƿ� cnt �� �ִ� ���� ��
		 *
		 * ������ ���� : cnt dungeon�� ����
		 */
		visited = new boolean[dungeons.length];
		int cnt = dungeons.length;

		DFS(k, dungeons, 0);

		return answer;
	}

	private void DFS(int k, int[][] dungeons, int depth) {

		// while ������ ���� �Ǹ� 2��° �迭�� ó�� ������ �Ǿ��� ���, 1��° �迭�� ���� 2��°�� ��� �� �� �ִ���?
		// => �ش��� for visited�� �����ؼ� for �� 0���� ����, 
		for (int i = 0; i < dungeons.length; i++) {
			if (!visited[i] && k >= dungeons[i][0]) {
				// �湮��, �����Ƿ� > �Ҹ� �Ƿ�
				visited[i] = true;
				DFS(k - dungeons[i][1], dungeons, depth + 1);
				visited[i] = false;
			}
			
			// ó�� �迭�������� �����ؼ� ��� ������ Ÿ�� 
			answer = Math.max(depth, answer);
		}

	}
}
