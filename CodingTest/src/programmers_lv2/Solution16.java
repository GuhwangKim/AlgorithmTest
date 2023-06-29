package CodingTest.src.programmers_lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution16 {

	int[] dx = { -1, 0, 1, 0 };
	int[] dy = { 0, 1, 0, -1 };
	boolean[][] visited;
	String[][] miro;

	public int solution(String[] maps) {
		int count = 0;

		miro = new String[maps.length][maps[0].length()];
		// ���� - �ⱸ / ���� - ���� �� ����� ����
		int[] start = new int[2];
		int[] lever = new int[2];

		for (int i = 0; i < maps.length; i++) {
			String[] split = maps[i].split("");
			for (int j = 0; j < maps.length; j++) {
				miro[i][j] = split[j];

				if (miro[i][j].equals('S')) {
					start = new int[] { i, j };
				}
				if (miro[i][j].equals('S')) {
					lever = new int[] { i, j };
				}

			}
		}

		int startToLever = BFS(start, "L");
		int leverToEnd = BFS(lever, "E");
		
		// �Ұ����� ��� 
		if(startToLever == -1 || leverToEnd == -1) {
			return -1;
		}
		return startToLever+leverToEnd;
	}

	private int BFS(int[] currentRC, String target) {
		Queue<int[]> queue = new LinkedList<int[]>();

		// ��, ��
		queue.add(new int[] { currentRC[0], currentRC[1], 0 });
		visited = new boolean[miro.length][miro[0].length];

		while (!queue.isEmpty()) {
			int x = queue.peek()[0]; // ��
			int y = queue.peek()[1]; // ��
			int count = queue.peek()[2];
			visited[x][y] = true;

			// Ÿ�� ���� ������ �� ����
			if (miro[x][y].equals(target)) {
				return count;
			}
			queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < miro.length && ny >= 0 && ny < miro[0].length && !visited[nx][ny]) {
					if (!miro[nx][ny].equals("X")) {
						visited[nx][ny] = true;
						queue.add(new int[] { nx, ny, count + 1 });
					}
				}
			}

		}

		return -1;
	}

}
