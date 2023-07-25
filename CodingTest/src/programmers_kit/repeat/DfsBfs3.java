package CodingTest.src.programmers_kit.repeat;

import java.util.LinkedList;
import java.util.Queue;

public class DfsBfs3 {
	int[] dx = { -1, 0, 1, 0 };
	int[] dy = { 0, 1, 0, -1 };
	int[][] chkArr;

	public int solution(int[][] maps) {
		chkArr = new int[maps.length][maps[0].length];
		/**
		 * 0 0 �� ���� ��ǥ�� ��ġ�� ���� ���� ��ġ�� ���ٸ� �׶� level�� ��ȯ�ϰ�, math���� idx map.length -1,
		 * maps[0].length -1 ���� ���� ����� ���� ����
		 */
		/**
		 * Queue �� �ִٸ� ���� ����Լ��� ������ �ʿ䰡 ������
		 */
		DFS(0, 0, maps, chkArr);
		chkArr[0][0]=1;
		int answer = 0;
		answer = chkArr[maps.length - 1][maps[0].length - 1];
		if (answer == 0) {
			answer = -1;
		}

		return answer;
	}

	private void DFS(int positionX, int positionY, int[][] maps, int[][] chkArr) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { positionX, positionY });
		
		/**
		 * 1. ����Լ��� ����� �ʿ� ���� ���� [queue�� �ִ� ��� ����Լ��� ȣ���� �ʿ䰡 ����]
		 * 	-> �������� �������̰�, �׶� �ִ밪�� ��� ���ؾ��ϴ��� Ȯ��ġ ����
		 * 	-> �ֳ��ϸ� ���� ���ȿ� �����ִ� ��찡 �ִµ� �̷� ��쿣 ���� �������� ���� ������ �񱳸� �� ���� ���� 
		 * 	
		 * 	=> ���� queue �� ���� ���� �������� �ؼ� ������ ���� ã������ϰ� 
		 * 		�̷� ��쿡�� ���� ����Լ��� ���� �ʿ䰡 ������ 
		 * 	=> ���� �������� ǥ�õ� ���� ����ؼ� ���� �����ָ� �� 
		 * 
		 *2. �� ��쵵 constant�� ���� ��쿡��, ���� ���� �ѷ��׿� ���� ���� ���� ���� ���� �� 
		 * -> �̷� ��� 0�� �Ǿ��ϴµ� constant�� ��� ��ŭ ���� ������ ���� 
		 * 
		 * 3. ������ �迭�� ���� ��� ���� ���� ���� �迭�� ����
		 * 	-> boolean�� ������ ��ü�� 
		 * 	-> ������ �ѷ��ο� ���� �� -1 �� ��ȯ�Ǵ� �͵� ������ �� ���� 
		 * -
		 * */
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];

				if (nx < 0 || nx > maps.length - 1 || ny < 0 || ny > maps[0].length - 1)
					continue;

				if (chkArr[nx][ny] == 0 && maps[nx][ny] == 1) {
					chkArr[nx][ny] = chkArr[current[0]][current[1]] + 1;
					queue.add(new int[] { nx, ny });
				}

			}

		}

	}
}
