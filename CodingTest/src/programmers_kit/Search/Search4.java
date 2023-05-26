package programmers_kit.Search;

import java.util.LinkedList;
import java.util.Queue;

public class Search4 {
	static int[][] arr;

	public int solution(int n, int[][] wires) {
		int answer = n;
		// 노드의 개수가 n 이고 가상 배열에는 마지막 숫자 까지 표시해야하므로 베열은 n+1로 만들어줘야함
		arr = new int[n + 1][n + 1];
		// 1. 인접 행렬을 만들어서 각 노드별로 연결된 전선을 표시함
		for (int i = 0; i < wires.length; i++) {
			arr[wires[i][0]][wires[i][1]] = 1;
			// 양방향 그래프 이므로 두개가 연결되어있으면 x y 값을 바꾼 곳도 연결 표시가 됨
			arr[wires[i][1]][wires[i][0]] = 1;
		}

		// 2. 가장 앞글자를 기준으로 전선을 끊음
		for (int i = 0; i < wires.length; i++) {
			int frontNum = wires[i][0];
			int backNum = wires[i][1];

			arr[frontNum][backNum] = 0;
			arr[backNum][frontNum] = 0;

			// 3. 앞글자를 기준으로 연결된 그래프들을 찾을 것
			answer = Math.min(answer, BFS(frontNum, n));

			arr[frontNum][backNum] = 1;
			arr[backNum][frontNum] = 1;

		}

		return answer;

	}

	private int BFS(int frontNum, int nodeCnt) {
		// 4. 같은 숫자일 때 건너뛰기 위한 배열 생성  (주어진 숫자를 체크해야하므로 인덱스보다 1 하나 더)
		boolean[] visited = new boolean[nodeCnt + 1];
		int cnt = 1;

		Queue<Integer> queue = new LinkedList<Integer>();
		// 5. 큐에 전선의 앞 숫자를 입력
		queue.add(frontNum);

		while (!queue.isEmpty()) {
			int queueFirstNode = queue.poll();
			// 6. 행렬 같은 숫자가 나오면 그 값은 무조건 0이므로 건너뛰기 위해 만들어놓음
			visited[queueFirstNode] = true;

			for (int i = 0; i < nodeCnt; i++) {
				// 7. 같은 숫자라면 건너뜀
				if (visited[i]) {
					continue;
				} else {
					// 8. 해당 숫자 이미 세지 않은 상태이고
					// 9. 뽑은 숫자와 연결된 노트라면
					if (arr[queueFirstNode][i] == 1) {
						queue.add(i);
						// 10. 연결된 전선의 개수를 더해줌
						cnt++;
					}
				}
			}

		}
		// 11. 마지막 값은 연결된 노드와 그렇지 않은 노드 사이의 차를 보내줘야함
		return (int) Math.abs(nodeCnt - 2 * cnt);
	}

}
