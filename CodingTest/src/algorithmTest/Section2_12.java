package algorithmTest;

import java.util.Scanner;

public class Section2_12 {
	public int solution(int n, int m, int[][] arr) {
		int answer = 0;
		for (int i = 1; i <=n; i++) { // 멘토
			for (int j = 1; j <=n; j++) { // 멘티 
				int cnt = 0; // 새로운 조합
				for (int k = 0; k < m; k++) { // 횟수
					int pi =0, pj=0;
					for (int s = 0; s < n; s++) { // 등수 (한줄)
						if(arr[k][s]==i) { // 멘토인경우
							pi=s; // 등수 
						}
						if(arr[k][s]==j) { // 멘티인경우
							pj=s; 
						}
					}
					// 한줄 끝났음 
					if(pi<pj) {
						cnt++;
					}
					// 다음 줄 
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
