package algorithmTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section8_4 {
	static int[] dis;
	static int total = 0; // ������ ��

	private static void BFS(int n, int m) {
		int[] ch = new int[1000];
		int L = 0; // ���� (����)
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.offer(0); // 1. �ʱ�ȭ
		while (!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				int x = Q.poll(); // 2. �̾Ҵµ� �Ž��� ���̸�
				if (x == m) {
					System.out.println(L);
					break; // ��
				}
				for (int j = 0; j < dis.length; j++) {
					int nx = x + dis[j]; // 3.���� ���� ���� 
					if(ch[nx]!=0) {
						ch[nx]=1;
						Q.offer(nx); // 4. �̹� ���� ���� �ƴ϶�� ������� 
					}
				}
			}
			L++; // 4. ���� �ϳ� �� ��
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); // ���� ���� ����
		for (int i = 0; i < n; i++) {
			dis[i] = in.nextInt();
		}
		int m = in.nextInt(); // �Ž��� ����ϴ� �ݾ�
		BFS(n, m);
		return;
	}

}
