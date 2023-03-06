package CodingTest.src.algorithmTest;

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
		public int x, y; // ��ȿ

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
					// 2. ������ �迭�� ���� 1�� ������� (+1 ����) 
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
					// 1. �̸� ������ (0����)
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
					// 3-1. ���� ���� Ž���ϸ鼭 board�� Ž������ �� ���� �ʴ� �丶�䰡 ������ 
				}
			}
		}
		if (flag) { 
			// 3-2. dis �� ���� Ž���ϸ鼭 �ִ� ���� ã�� 
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
