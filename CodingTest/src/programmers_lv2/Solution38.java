package programmers_lv2;

import java.util.Arrays;

public class Solution38 {
	boolean[] visited;
	public int solution(int[] info, int[][] edges) {
		visited = new boolean[info.length];
		
		Arrays.sort(edges, (o1, o2) -> o1[0]-o2[0]); // 0��° �ε����� �������� �������� 
		visited[0] = true;
		// ���� ù��° �θ�� �湮�� = ������ �� cnt+1;
		
		int answer = BFS(edges[0][1], edges, info, 1, 0);
		
		
		for (int i = 0; i < edges.length; i++) {
			int parent = edges[i][0];
			int child = edges[i][1];
			
			int sCnt = 1;
			int wCnt = 0;
			
			if(wCnt >= sCnt) { // ���� ����ġ 
				break;
			}
			
			if(visited[i]) {
				// �湮���� �ʾҴٸ� ������ 
			}
			
		}
		
		
		return answer;
	}
	private int BFS(int nextParent, int[][] edges, int[] info, int sheep, int wolf) {
		
		
		if(info[nextParent]>0) {
			// ������ ��� 
			wolf++;
		}
		
		if()
		
		
		return wolf;
		
		
		
	}
}
