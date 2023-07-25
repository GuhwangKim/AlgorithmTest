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
		 * 0 0 에 있음 좌표의 위치를 보냄 적의 위치와 같다면 그때 level을 반환하고, math적용 idx map.length -1,
		 * maps[0].length -1 까지 가면 상대의 말을 잡음
		 */
		/**
		 * Queue 가 있다면 굳이 재귀함수를 구현할 필요가 없어짐
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
		 * 1. 재귀함수를 사용이 필요 없는 이유 [queue가 있는 경우 재귀함수를 호출할 필요가 없다]
		 * 	-> 언제까지 마지막이고, 그때 최대값과 어떻게 비교해야하는지 확실치 않음
		 * 	-> 왜냐하면 말이 벽안에 가둬있는 경우가 있는데 이런 경우엔 가장 끝에까지 오는 것으로 비교를 할 수가 없음 
		 * 	
		 * 	=> 따라서 queue 에 값이 없는 조건으로 해서 마지막 값을 찾아줘야하고 
		 * 		이런 경우에는 굳이 재귀함수를 구할 필요가 없어짐 
		 * 	=> 단지 전역으로 표시된 값에 계속해서 값을 더해주면 됨 
		 * 
		 *2. 이 경우도 constant를 갖는 경우에는, 말이 벽에 둘러쌓여 있을 때를 구할 수가 없게 됨 
		 * -> 이런 경우 0이 되야하는데 constant는 경로 만큼 값이 더해질 것임 
		 * 
		 * 3. 기존의 배열과 같은 행과 열의 수를 갖는 배열을 만듦
		 * 	-> boolean의 역할을 대체함 
		 * 	-> 벽으로 둘러싸여 있을 때 -1 이 반환되는 것도 구현할 수 있음 
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
