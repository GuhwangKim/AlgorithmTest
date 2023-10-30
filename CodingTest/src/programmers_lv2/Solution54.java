package programmers_lv2;

public class Solution54 {
	public int[] solution(int n) {

        int[] answer = new int[(n*(n+1))/2];
        int[][] matrix = new int[n][n];
        
        int x = -1, y= 0;
        // ��ǥ�� ���� 0,0
        int num = 1;
        // ���� ������ ���� 
        
        for (int i = 0; i < n; i++) { // �Ʒ�, ����, �밢��
			for (int j = i; j < n; j++) { // ���� �ٸ� �������������� n���� 
				if(i%3==0) {
					// �Ʒ� 
					x++;
				}else if (i%3==1) {
					// ����
					y++;
				}else {
					// �밢�� 
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
					break; // �� ���� => ä������ �ʾ���, ������ ������ 
				}
				answer[k++] = matrix[i][j];
			}
		}
        
        return answer;
    }

}
