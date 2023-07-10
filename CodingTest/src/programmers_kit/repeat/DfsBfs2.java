package programmers_kit.repeat;

public class DfsBfs2 {
	
	boolean[] visited;
	
	public int solution(int n, int[][] computers) {
		visited= new boolean[n];
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if(!visited[i]) {
				answer++;
				DFS(i, computers);
			}
		}
		
		return n;
		
	}

	private void DFS(int i, int[][] computers) {
		visited[i] = true;
		
		for (int j = 0; j < computers.length; j++) {
			if(!visited[j]&&computers[i][j]==1) {
				// 한번도 방문 안하고, 행 열 의 값이 연결되어 있다면 그 수를 기준으로 다시 들어감 
				DFS(j, computers);
			}
		}
		
	}

}
