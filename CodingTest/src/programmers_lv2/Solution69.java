package CodingTest.src.programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution69 {

	public int solution(int m, int n, int[][] puddles) {

		int[][] visited = new int[n][m];
		for(int[] puddle : puddles) {
			visited[puddle[1]-1][puddle[0]-1] = -1; // ��ֹ� ǥ��  �ε����� �ϳ� �� ���� 
		}
		
		visited[0][0] = 1;
		
		for (int i = 0; i < n; i++) { // ��
			for (int j = 0; j < m; j++) { // ��
				// �������� 1�� 
				if(visited[i][j] == -1) {
					// �������̶�� 
					visited[i][j] = 0;
					continue;
				}
				if(i!=0) {
					// ���������� ���� ��� (������) 
					visited[i][j] += visited[i-1][j]%1000000007;
				}
				if(j!=0) {
					// �Ʒ��� �������� ��� 
					visited[i][j] += visited[i][j-1]%1000000007;
				}
				
			}
		}

		return visited[n-1][m-1]% 1000000007;
	}
}
