package CodingTest.src.programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution69 {

	public int solution(int m, int n, int[][] puddles) {

		int[][] visited = new int[n][m];
		for(int[] puddle : puddles) {
			visited[puddle[1]-1][puddle[0]-1] = -1; // 장애물 표시  인덱스는 하나 더 적음 
		}
		
		visited[0][0] = 1;
		
		for (int i = 0; i < n; i++) { // 행
			for (int j = 0; j < m; j++) { // 렬
				// 시작점은 1로 
				if(visited[i][j] == -1) {
					// 물웅덩이라면 
					visited[i][j] = 0;
					continue;
				}
				if(i!=0) {
					// 오른쪽으로 가는 경우 (이전것) 
					visited[i][j] += visited[i-1][j]%1000000007;
				}
				if(j!=0) {
					// 아래로 내려오는 경우 
					visited[i][j] += visited[i][j-1]%1000000007;
				}
				
			}
		}

		return visited[n-1][m-1]% 1000000007;
	}
}
