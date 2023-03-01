package algorithmTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section8_11 {
	static int[][] board, dis;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int min = 49;
	static int count = 0;
	static int answer = 0;
	
	class Point{
		public int x, y; // ��ȿ 
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
		

	private void BFS(int x, int y) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x, y));
		board[x][y]=1; // 1. ������ ���� 1�� �湮�ߴٰ� ǥ�� 
		while (!Q.isEmpty()) {
			Point tmp = Q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
					// 2. �ش� ������ �����ϸ� 
					board[nx][ny]=1; // 3. �����̸鼭 ���� ��ġ�� �湮�ߴٰ� ǥ�� 
					Q.offer(new Point(nx, ny)); // 4.  Queue�� ���� ������� 
					dis[nx][ny]= dis[tmp.x][tmp.y]+1; // 5. dis �迭�� �Ÿ��� ������Ŵ 
					
				}
			}
		}
	}

	public static void main(String[] args) {
		Section8_11 T = new Section8_11();
		Scanner in = new Scanner(System.in);
		board = new int[8][8];
		dis = new int[8][8];
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				board[i][j] = in.nextInt();
			}
		}
		T.BFS(1, 1);
		if (dis[7][7]==0) {
			System.out.println(-1);
		} else {
			System.out.println(dis[7][7]);
		}
	}
}
