package algorithmTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section8_4 {
	static int[] dis;
	static int total = 0; // 동전이 합

	private static void BFS(int n, int m) {
		int[] ch = new int[1000];
		int L = 0; // 레벨 (정답)
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.offer(0); // 1. 초기화
		while (!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				int x = Q.poll(); // 2. 뽑았는데 거스릅 값이면
				if (x == m) {
					System.out.println(L);
					break; // 끝
				}
				for (int j = 0; j < dis.length; j++) {
					int nx = x + dis[j]; // 3.뽑은 수에 더함 
					if(ch[nx]!=0) {
						ch[nx]=1;
						Q.offer(nx); // 4. 이미 나온 수가 아니라면 집어넣음 
					}
				}
			}
			L++; // 4. 레벨 하나 더 들어감
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); // 동전 종류 개수
		for (int i = 0; i < n; i++) {
			dis[i] = in.nextInt();
		}
		int m = in.nextInt(); // 거슬러 줘야하는 금액
		BFS(n, m);
		return;
	}

}
