package CodingTest.src.programmers_lv2;

public class Solution55 {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    boolean[][] visited;
    int direct = 1;
    int corner = 0;
    int num;
    int answer = 0;
    public int solution(int[][] board) {
        num = board.length;
        visited = new boolean[num][num];
        
    	/*
        * 0,0 ���� �����¿� �غ�
        * �� ���ٰ� ���� �� �ִµ�, �� �ڷ� �����¿� �� ���ٸ� �ڳ�
        * n , n ���� ���� �� ���� �ڳ� ��
        * */
        int x = 0, y = 0;

        DFS(0, 0, 0, board);
        
        

        return answer;
    }
	private void DFS(int curXidx, int curYidx, int blockCnt, int[][] board) {
		if(curXidx == num-1 && curYidx == num-1) {
        	// �� 
			answer = Math.min(answer, (direct*100)+(corner*500));
			return;
        }
		
		
		for (int i = 0; i < 4; i++) {
            int nx = curXidx + dx[i];
            int ny = curYidx + dy[i];
            
            // �����¿� �̵�
            if(nx<0 || ny<0 || nx>=num || ny>= num || board[nx][ny]==1 || visited[nx][ny]){
                // ��ǥ�� ������ �ִ� �ε��� ���� �Ѿ�ų� ���� �ִ� ���ų� �̹� �湮�� ��� 
            	// �̷� ��찡 3���� �Բ� �ȵȴٸ� �׶� �ڳʰ� ��
            	// ������ 1���� �������� �� �ְ� ������ �Ǿ����� 
            	blockCnt++;
            	continue;
            }
            if(blockCnt==3) {
            	// 3���� �� ���� ��Ȳ 
            	corner++;
            }
            visited[nx][ny] = true;
            DFS(nx,ny,0,board);
            // ī��Ʈ ������ 
            visited[nx][ny] = false;

        }
		
	}
}
