package algorithmTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section8_12 {
	static int width;
	static int height;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] board, dis;
	static Queue<Point> Q = new LinkedList<>();

	static class Point {
		public int x, y; // 좌효

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private void BFS() {
		if (!Q.isEmpty()) {
			Point tmp = Q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx >= 1 && nx <= width && ny >= 1 && ny <= height && board[nx][ny] == 0) {
					board[nx][ny] = 1;
					Q.offer(new Point(nx, ny));
					dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
					// 2. 현재의 배열의 값에 1을 집어넣음 (+1 레벨) 
				}
			}
		}

	}

	public static void main(String[] args) {
		Section8_12 T = new Section8_12();
		Scanner in = new Scanner(System.in);
		width = in.nextInt();
		height = in.nextInt();

		board = new int[width][height];
		dis = new int[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				board[i][j] = in.nextInt();
				if (board[i][j] == 1) {
					Q.offer(new Point(i, j));
					// 1. 미리 만들어놈 (0레벨)
				}
			}
		}
		T.BFS();
		boolean flag = true;
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (board[i][j] == 1) {
					flag = false;
					// 3-1. 이중 폼을 탐색하면서 board를 탐색했을 때 익지 않는 토마토가 있으면 
				}
			}
		}
		if (flag) { 
			// 3-2. dis 의 값을 탐색하면서 최대 값을 찾음 
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					answer = Math.max(answer, dis[i][j]);
				}
			}
			System.out.println(answer);
		}else {
			System.out.println(-1);
		}
	}
}
