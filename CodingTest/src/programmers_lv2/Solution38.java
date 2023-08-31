package programmers_lv2;

import java.util.Arrays;

public class Solution38 {
	boolean[] visited;
	public int solution(int[] info, int[][] edges) {
		visited = new boolean[info.length];
		
		Arrays.sort(edges, (o1, o2) -> o1[0]-o2[0]); // 0번째 인덱스를 기준으로 오름차순 
		visited[0] = true;
		// 가장 첫번째 부모는 방문함 = 무조건 양 cnt+1;
		
		int answer = BFS(edges[0][1], edges, info, 1, 0);
		
		
		for (int i = 0; i < edges.length; i++) {
			int parent = edges[i][0];
			int child = edges[i][1];
			
			int sCnt = 1;
			int wCnt = 0;
			
			if(wCnt >= sCnt) { // 조건 불일치 
				break;
			}
			
			if(visited[i]) {
				// 방문하지 않았다면 더해줌 
			}
			
		}
		
		
		return answer;
	}
	private int BFS(int nextParent, int[][] edges, int[] info, int sheep, int wolf) {
		
		
		if(info[nextParent]>0) {
			// 늑대인 경우 
			wolf++;
		}
		
		if()
		
		
		return wolf;
		
		
		
	}
}
