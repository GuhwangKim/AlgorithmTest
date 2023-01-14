package algorithmTest;

import java.util.ArrayList;
import java.util.Scanner;

public class Section7_11 {
	static int n;
	static int m;
	static int answer = 0;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] ch;
	public void DFS(int v) {
		if(v==n) answer++ ; //끝남 
		else {
			for(int nv : graph.get(v)) {
				ch[nv] = 1; 
				DFS(nv); 
				ch[nv]=0;
			}
		}
	}
	
	public static void main(String[] args) {
		Section7_11 T = new Section7_11();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //5 
		m = sc.nextInt();
		graph = new ArrayList<ArrayList<Integer>>();
		ch = new int[n+1];
		for (int i = 0; i <=n; i++) {
			// 5개의 변수를 가지고 있으므로 
			graph.add(new ArrayList<Integer>());
		}
		ch= new int[n+1]; // 출발점 체크 
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
			// 1 ~ 5 번 접근 / S
			
		}
		ch[1]=1;
		T.DFS(1);
		System.out.println(answer);
		
	}
}
