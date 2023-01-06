package algorithmTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section7_1 {
	int answer = 0;
	int[] dis = {1, -1, 5};
	int[] ch;
	Queue<Integer> Q = new LinkedList<Integer>();
	private int T(int a, int b) {
		ch = new int[10001];
		ch[a] = 1;// 출발지점 지나 갔나 안갔나만 확인 
		Q.offer(a);
		int L = 0; // 레벨
		while(!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				int x= Q.poll(); // 빼고 지움 
				if(x==b) return L;// 같은 위치 
				for (int j = 0; j < 3; j++) {
					int nx = x+dis[j];
					if(nx>=1 && nx<=10000 && ch[nx]==0) { // 0 은 방문 안한 곳
						ch[nx]=1;
						Q.offer(nx);
					}
				}
			}
			L++;
		}
		return 0;
	}
	public static void main(String[] args) {
		Section7_1 section = new Section7_1();
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		System.out.println(section.T(a, b));
	}
}
