package algorithmTest;

import java.util.Scanner;

public class Section7_10 {
	static int n;
	static int m;
	static int answer = 0;
	static int[][] graph;
	static int[] ch;
	public void DFS(int v) {
		if(v==n) answer++ ; //끝남 
		else {
			for (int i = 1; i <=n; i++) { // 한 수에 5개의 가닥
				if(graph[v][i]==1 && ch[i]==0) {
					// 방향이 존재하고 + 한번도 안 갔다 왔으면
					ch[i]=1;
					// 갔다 왔다 체크 
					DFS(i);
					// 그 자리에서 또 아래로 뻗어나감 
					ch[i]=0;
					// 행동 취소 
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Section7_10 T = new Section7_10();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		graph = new int[n+1][n+1];
		ch = new int[n+1];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
		}
		ch[1]=1; // 출발점 체크 
		T.DFS(1);
		System.out.println(answer);
		
	}

}
