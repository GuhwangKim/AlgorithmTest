package programmers_kit.Search;

import java.util.LinkedList;
import java.util.Queue;

public class Search4 {
	static int[][] arr;

	public int solution(int n, int[][] wires) {
		int answer = n;
		// ����� ������ n �̰� ���� �迭���� ������ ���� ���� ǥ���ؾ��ϹǷ� ������ n+1�� ����������
		arr = new int[n + 1][n + 1];
		// 1. ���� ����� ���� �� ��庰�� ����� ������ ǥ����
		for (int i = 0; i < wires.length; i++) {
			arr[wires[i][0]][wires[i][1]] = 1;
			// ����� �׷��� �̹Ƿ� �ΰ��� ����Ǿ������� x y ���� �ٲ� ���� ���� ǥ�ð� ��
			arr[wires[i][1]][wires[i][0]] = 1;
		}

		// 2. ���� �ձ��ڸ� �������� ������ ����
		for (int i = 0; i < wires.length; i++) {
			int frontNum = wires[i][0];
			int backNum = wires[i][1];

			arr[frontNum][backNum] = 0;
			arr[backNum][frontNum] = 0;

			// 3. �ձ��ڸ� �������� ����� �׷������� ã�� ��
			answer = Math.min(answer, BFS(frontNum, n));

			arr[frontNum][backNum] = 1;
			arr[backNum][frontNum] = 1;

		}

		return answer;

	}

	private int BFS(int frontNum, int nodeCnt) {
		// 4. ���� ������ �� �ǳʶٱ� ���� �迭 ����  (�־��� ���ڸ� üũ�ؾ��ϹǷ� �ε������� 1 �ϳ� ��)
		boolean[] visited = new boolean[nodeCnt + 1];
		int cnt = 1;

		Queue<Integer> queue = new LinkedList<Integer>();
		// 5. ť�� ������ �� ���ڸ� �Է�
		queue.add(frontNum);

		while (!queue.isEmpty()) {
			int queueFirstNode = queue.poll();
			// 6. ��� ���� ���ڰ� ������ �� ���� ������ 0�̹Ƿ� �ǳʶٱ� ���� ��������
			visited[queueFirstNode] = true;

			for (int i = 0; i < nodeCnt; i++) {
				// 7. ���� ���ڶ�� �ǳʶ�
				if (visited[i]) {
					continue;
				} else {
					// 8. �ش� ���� �̹� ���� ���� �����̰�
					// 9. ���� ���ڿ� ����� ��Ʈ���
					if (arr[queueFirstNode][i] == 1) {
						queue.add(i);
						// 10. ����� ������ ������ ������
						cnt++;
					}
				}
			}

		}
		// 11. ������ ���� ����� ���� �׷��� ���� ��� ������ ���� ���������
		return (int) Math.abs(nodeCnt - 2 * cnt);
	}

}
