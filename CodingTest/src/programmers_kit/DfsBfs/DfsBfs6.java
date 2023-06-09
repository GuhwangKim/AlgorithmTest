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
		// �湮ǥ�� 
		// �̾��� �ִ� �͵��� ������ ǥ�õ� 
		for (int i = 0; i < computers.length; i++) {
			if(visited[i]==false && computers[node][i]==1) {
				DFS(i, visited, computers);
			}
		}
		
	}


}

