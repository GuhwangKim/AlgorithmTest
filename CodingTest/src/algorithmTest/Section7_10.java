package algorithmTest;

import java.util.Scanner;

public class Section7_10 {
	static int n;
	static int m;
	static int answer = 0;
	static int[][] graph;
	static int[] ch;
	public void DFS(int v) {
		if(v==n) answer++ ; //���� 
		else {
			for (int i = 1; i <=n; i++) { // �� ���� 5���� ����
				if(graph[v][i]==1 && ch[i]==0) {
					// ������ �����ϰ� + �ѹ��� �� ���� ������
					ch[i]=1;
					// ���� �Դ� üũ 
					DFS(i);
					// �� �ڸ����� �� �Ʒ��� ����� 
					ch[i]=0;
					// �ൿ ��� 
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
		ch[1]=1; // ����� üũ 
		T.DFS(1);
		System.out.println(answer);
		
	}

}
