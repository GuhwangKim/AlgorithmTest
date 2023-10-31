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
        * 0,0 에서 상하좌우 해봄
        * 쭉 가다가 막힌 곳 있는데, 그 뒤로 상하좌우 가 간다면 코너
        * n , n 까지 갔을 때 직진 코너 값
        * */
        int x = 0, y = 0;

        DFS(0, 0, 0, board);
        
        

        return answer;
    }
	private void DFS(int curXidx, int curYidx, int blockCnt, int[][] board) {
		if(curXidx == num-1 && curYidx == num-1) {
        	// 끝 
			answer = Math.min(answer, (direct*100)+(corner*500));
			return;
        }
		
		
		for (int i = 0; i < 4; i++) {
            int nx = curXidx + dx[i];
            int ny = curYidx + dy[i];
            
            // 상하좌우 이동
            if(nx<0 || ny<0 || nx>=num || ny>= num || board[nx][ny]==1 || visited[nx][ny]){
                // 좌표가 가지고 있는 인덱스 밖을 넘어서거나 벽이 있는 경우거나 이미 방문한 경우 
            	// 이런 경우가 3개가 함께 안된다면 그땐 코너가 됨
            	// 무조건 1곳은 빠져나갈 수 있게 구성이 되어있음 
            	blockCnt++;
            	continue;
            }
            if(blockCnt==3) {
            	// 3면이 다 막힌 상황 
            	corner++;
            }
            visited[nx][ny] = true;
            DFS(nx,ny,0,board);
            // 카운트 원상태 
            visited[nx][ny] = false;

        }
		
	}
}
