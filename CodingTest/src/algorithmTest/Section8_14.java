package CodingTest.src.algorithmTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section8_14 {
    static int num;
    static int[] dx = {-1, -1, 0, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 0, -1, -1, -1};
    static int L = 0;

    static class Point {
        public int x, y; // 좌효

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void BFS(int x, int y, int[][] board) {
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(x, y));
        // 0,0을 집어넣음
        while (!Q.isEmpty()) {
            // 값이 여전히 존재한다면
            Point point = Q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx>=0 && nx < num && ny >= 0 && ny < num && board[nx][ny] == 1){
                    // 섬일때
                    board[nx][ny]=0;
                    Q.add(new Point(nx,ny));
                }
            }
        }
    }
    public void solution(int[][] board) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (board[i][j] == 1) {
                    // 섬일 때 호출
                    L++;
                    board[i][j]=0;
                    BFS(i, j, board);
                }
            }
        }

    }
    public static void main(String[] args) {
        Section8_14 T = new Section8_14();
        Scanner in = new Scanner(System.in);
        num = in.nextInt();
        int[][] arr = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                arr[i][j] = in.nextInt();

            }
        }
        T.solution(arr);
        System.out.println(L);
    }
}

