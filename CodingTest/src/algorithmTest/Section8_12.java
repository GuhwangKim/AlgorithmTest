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
		public int x, y; // 占쏙옙효

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
					// 2. 占쏙옙占쏙옙占쏙옙 占썼열占쏙옙 占쏙옙占쏙옙 1占쏙옙 占쏙옙占쏙옙占쏙옙占� (+1 占쏙옙占쏙옙) 
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
					// 1. 占싱몌옙 占쏙옙占쏙옙占쏙옙 (0占쏙옙占쏙옙)
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
					// 3-1. 占쏙옙占쏙옙 占쏙옙占쏙옙 탐占쏙옙占싹면서 board占쏙옙 탐占쏙옙占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙 占십댐옙 占썰마占썰가 占쏙옙占쏙옙占쏙옙 
				}
			}
		}
		if (flag) { 
			// 3-2. dis 占쏙옙 占쏙옙占쏙옙 탐占쏙옙占싹면서 占쌍댐옙 占쏙옙占쏙옙 찾占쏙옙 
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
