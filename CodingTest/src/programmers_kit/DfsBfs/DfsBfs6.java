package programmers_kit.DfsBfs;

import java.util.Arrays;

public class DfsBfs6 {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
			if(!visited[i]) {
				answer++;
				DFS(i, visited, computers);
			}
		}
        return answer;
    }

	private void DFS(int node, boolean[] visited, int[][] computers) {
		visited[node]=true;
		// 방문표시 
		// 이어져 있는 것들이 끝까지 표시됨 
		for (int i = 0; i < computers.length; i++) {
			if(visited[i]==false && computers[node][i]==1) {
				DFS(i, visited, computers);
			}
		}
		
	}


}

