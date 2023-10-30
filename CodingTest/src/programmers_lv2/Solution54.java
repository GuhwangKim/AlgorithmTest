package programmers_lv2;

public class Solution54 {
	public int[] solution(int n) {

        int[] answer = new int[(n*(n+1))/2];
        int[][] matrix = new int[n][n];
        
        int x = -1, y= 0;
        // 좌표의 시작 0,0
        int num = 1;
        // 들어가는 숫자의 시작 
        
        for (int i = 0; i < n; i++) { // 아래, 가로, 대각선
			for (int j = i; j < n; j++) { // 각기 다른 시작점에서부터 n까지 
				if(i%3==0) {
					// 아래 
					x++;
				}else if (i%3==1) {
					// 가로
					y++;
				}else {
					// 대각선 
					x--;
					y--;
				}
				matrix[x][y] = num++;
				
			}
		}
        int k = 0;
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(matrix[i][j]==0) {
					break; // 빈 공간 => 채워지지 않았음, 밑으로 내려감 
				}
				answer[k++] = matrix[i][j];
			}
		}
        
        return answer;
    }

}
