package algorithmTest;

import java.util.Scanner;

public class Section2_12 {
	public int solution(int n, int m, int[][] arr) {
		int answer = 0;
		for (int i = 1; i <=n; i++) { // ����
			for (int j = 1; j <=n; j++) { // ��Ƽ 
				int cnt = 0; // ���ο� ����
				for (int k = 0; k < m; k++) { // Ƚ��
					int pi =0, pj=0;
					for (int s = 0; s < n; s++) { // ��� (����)
						if(arr[k][s]==i) { // �����ΰ��
							pi=s; // ��� 
						}
						if(arr[k][s]==j) { // ��Ƽ�ΰ��
							pj=s; 
						}
					}
					// ���� ������ 
					if(pi<pj) {
						cnt++;
					}
					// ���� �� 
				}
				if(cnt==m) {
					answer++;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Section2_12 T = new Section2_12();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j]=in.nextInt();
			}
		}
		System.out.println(T.solution(n, m, arr));
	}

}
