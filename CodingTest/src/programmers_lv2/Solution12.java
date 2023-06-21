package programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution12 {
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
	
	boolean[][] visited;
	
	public int solution(String[] board) {
        int answer = 0;
        int startRow = 0, startColumn = 0, endRow = 0, endColumn = 0;
        
        for (int i = 0; i < board.length; i++) { // 열
			for (int j = 0; j < board[i].length(); j++) { // 행
				if(board[i].charAt(j)=='R') {
					startRow = i;
					startColumn = j;
				}else if(board[i].charAt(j)=='G') {
					endRow = i;
					endColumn = j;
				}
			}
		}
        
        visited= new boolean[board.length][board[0].length()]; // 열 행 2차원 배열 
        answer = bfs(startRow, startColumn, endRow, endColumn, board);
        
        return answer;
    }

	private int bfs(int startRow, int startColumn, int endRow, int endColumn, String[] board) {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {startRow, startColumn, 0}); // 시작의 열, 행, count
		visited[startRow][startColumn] = true; // 방문 
		
		while(!queue.isEmpty()) {
			int[] currentPosition = queue.poll();
			int count = currentPosition[2];
			
			if(currentPosition[0]==endRow && currentPosition[1]==endColumn) {
				// 들어온 값과 목표 값이 같다면 
				return count;
			}
			
			for (int i = 0; i < 4; i++) { //상하좌우로 흘러감
				int currentRow = currentPosition[0];
				int currentColumn = currentPosition[1];
				
				while(true) {
					int nextRow = currentRow+dx[i];
					int nextColumn = currentColumn+dy[i];
					if(nextRow>=board.length || nextRow<0 || nextColumn>=board[0].length() || nextColumn<0 || board[nextRow].charAt(nextColumn)=='D') {
						break; // 글자의 길이를 넘거나, 주어진 글자 이상이거나, 장애물을 만날 경우 넘겨줌 
					}
				currentRow = nextRow;
				currentColumn = nextColumn;
				}
				
				if(currentRow==currentPosition[0] && currentColumn == currentPosition[1]) continue; // 이동했는데 같은 위치라면 넘어감 
				if(visited[currentRow][currentColumn]) continue; // 방문한 곳이라면 넘어감 
				else {
					queue.add(new int[] {currentRow, currentColumn, count+1});
					visited[currentRow][currentColumn] = true;
				}
				
				
			}
		}
		
		
		return -1;
	}


}
