package programmers_kit.DfsBfs;

import java.util.LinkedList;
import java.util.Queue;


public class DfsBfs2 {

	int[] dx = { -1, 0, 1, 0 };
	int[] dy = { 0, 1, 0, -1 };

	public void DFS(int[][] vChkArr, int[][] vMaps) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0 });
		vChkArr[0][0] = 1;
		while (!queue.isEmpty()) {
			int[] currentQ = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = currentQ[0] + dx[i];
				int ny = currentQ[1] + dy[i];
				if(nx < 0 || nx > vMaps.length-1 || ny < 0 || ny > vMaps[0].length-1)
                    continue;
                
                if(vChkArr[nx][ny] == 0 && vMaps[nx][ny] == 1){
                    vChkArr[nx][ny] = vChkArr[currentQ[0]][currentQ[1]] + 1;
                    queue.add(new int[]{nx, ny});
                }

			}
		}

	}

	public int solution(int[][] maps) {
		int answer = 0;
		int[][] chkArr = new int[maps.length][maps[0].length];
		DFS(chkArr, maps);

		answer = chkArr[maps.length - 1][maps[0].length - 1];

		if (answer == 0) {
			answer = -1;
		}

		return answer;
	}

}
