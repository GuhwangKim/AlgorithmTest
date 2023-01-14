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
		ch[v]=1;// 1������ ���� 
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
		// �ε��� ��ȣ�� n - 1 ������ �־�� �ϹǷ� 
		for (int i = 0; i <=n; i++) {
			// 5���� ������ ������ �����Ƿ� 
			graph.add(new ArrayList<Integer>());
		}
		ch= new int[n+1]; // ����� üũ 
		
		// ��������Ʈ 
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			// ���� Array 
			int b = sc.nextInt();
			// ���� Array �� ���� Array 
			graph.get(a).add(b);
			// 1 ~ 5 �� ���� / S
		}
		T.BFS(1);
		for (int i = 2; i <= n; i++) {
			// 1�� ���� 2���� 
			System.out.println(i+" : "+dis[i]);
		}
	}
}
