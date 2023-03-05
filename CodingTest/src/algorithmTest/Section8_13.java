package algorithmTest;

import java.util.Scanner;

public class Section8_13 {
	static int num;
	static int[] dx = { -1, -1, 0, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 0, -1, -1, -1 };
	static int count = 0;

	public static void DFS(int x, int y, int[][] board) {
		// 이동용 
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >=0 && nx < num && ny >= 0 && ny < num && board[nx][ny] == 1) {
				// 섬이고 카운팅 하지 않았다면 
				board[nx][ny]=0;
				DFS(nx, ny, board);
				// 이 부분이 왜 필요한거지? 
			}
			
		}

	}
	

	public static void solution(int[][] board) {
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if(board[i][j]==1) {
					count++;
					board[i][j]=0;
					DFS(i, j, board);
				}
			}
		}
		
	}

	public static void main(String[] args) {
		Section8_13 T = new Section8_13();
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		int[][] arr = new int[num][num];
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		solution(arr);
		
		System.out.println(count);
	}


}
