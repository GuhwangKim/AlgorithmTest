package algorithmTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section7_12 {
	static int n;
	static int m;
	static int answer = 0;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] ch;
	static int[] dis;
	public void BFS(int v) {
		Queue<Integer> Q = new LinkedList<Integer>();
		ch[v]=1;// 1번부터 시작 
		dis[v] = 0;
		Q.offer(v);
		while (!Q.isEmpty()) {
			int cv = Q.poll();
			for(int nv : graph.get(cv)) {
				if(ch[nv]==0) {
					ch[nv]=1;
					Q.offer(nv);
					dis[nv] = dis[cv]+1;
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Section7_12 T = new Section7_12();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //5 
		m = sc.nextInt();
		graph = new ArrayList<ArrayList<Integer>>();
		ch = new int[n+1];
		dis = new int [n+1];
		// 인덱스 번호가 n - 1 번까지 있어야 하므로 
		for (int i = 0; i <=n; i++) {
			// 5개의 변수를 가지고 있으므로 
			graph.add(new ArrayList<Integer>());
		}
		ch= new int[n+1]; // 출발점 체크 
		
		// 인접리스트 
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			// 메인 Array 
			int b = sc.nextInt();
			// 메인 Array 에 서브 Array 
			graph.get(a).add(b);
			// 1 ~ 5 번 접근 / S
		}
		T.BFS(1);
		for (int i = 2; i <= n; i++) {
			// 1번 제외 2부터 
			System.out.println(i+" : "+dis[i]);
		}
	}
}
