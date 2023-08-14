package programmers_lv2;

import java.util.ArrayList;
import java.util.List;

public class Solution31 {
	int regions;
	int goal;
	boolean[][] visited;

	public int[] solution(int n, int[][] roads, int[] sources, int destination) {
		regions = n;
		goal = destination;
		visited = new boolean[n + 1][n + 1];
		int[] answer = new int[sources.length];
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < roads.length; i++) {
			int[] arr = roads[i];
			visited[arr[0]][arr[1]] = true;
			// road에 있는 경우 체크
			visited[arr[1]][arr[0]] = true;
			// 반대의 경우도 체크
		}

		for (int position : sources) {
			if (position == destination) {
				// 현재 위치와 destination과 같은 경우
				list.add(0);
				continue;
			}
			int path = BFS(position, 0, n);
			list.add(path);

		}

		return answer;
	}

	private int BFS(int startNum, int level, int result) {
		if(startNum==goal) {
			result = Math.min(result, level);
			
		}
		
		for (int i = 1; i <= regions; i++) {
			if(startNum==i) {
				continue;
			}
			if(visited[startNum][i]) {
				visited[i][startNum]=false;
				// 연결되있기 때문에 한쪽 부분 체크 해제
				BFS(i, level++, result);
				visited[i][startNum]=true;
			}
		}
		
		return 0;
	}
}
