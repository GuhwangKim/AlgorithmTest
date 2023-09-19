package CodingTest.src.programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution42 {
	int[] dx = { -1, 1, 0, 0 };
	int[] dy = { 0, 0, -1, 1 };
	boolean[][] visited;

	public int[] solution(String[][] places) {
		int[] answer = new int[5];

		int cnt = 0;
		for (String[] place : places) {
			boolean okay = true;
			for (int i = 0; i < 5; i++) {
				// ù��° ���ڿ���
				for (int j = 0; j < 5; j++) {
					// �ε��� ó ~ �� ���� Ž
					if(place[i].charAt(j)=='P') {
						// ����� ���´ٸ� �׶� ���� �� �������� � ���� �����ֳ� �׽�Ʈ 
						if(!BFS(i, j, place)) {
							okay = false;
						}
					}
				}
			}
			answer[cnt] = okay? 1 : 0;
			cnt++;
		}
		return answer;
	}

	private boolean BFS(int level, int idx, String[] currentArr) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {level, idx});
		
		while(!queue.isEmpty()) {
			int[] currentPosition = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nextX = currentPosition[0] + dx[k];
				int nextY = currentPosition[1] + dy[k];
				if (nextX >= 5 || nextX < 0 || nextY >= 5 || nextY < 0 || (nextX == level && nextY == idx)) {
					// �� ���� ��� continue 
					continue;
				}else {
//					visited[nextX][nextY] = false;
//					// �湮�� 
					int mandistance = Math.abs(nextX - level)+Math.abs(nextY - idx);
					if(currentArr[nextX].charAt(nextY) == 'P' && mandistance<=2) {
						// �Ÿ��� 2�̻�, �ٽ� P �� ���� 
						return false;
						// �� 
					} else if (currentArr[nextX].charAt(nextY) == 'O' && mandistance<2) {
						queue.offer(new int[] {nextX, nextY});
					}
				}
			}
		}
		return true;
	}
}
