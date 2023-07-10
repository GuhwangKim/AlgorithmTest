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
				// �ѹ��� �湮 ���ϰ�, �� �� �� ���� ����Ǿ� �ִٸ� �� ���� �������� �ٽ� �� 
				DFS(j, computers);
			}
		}
		
	}

}
