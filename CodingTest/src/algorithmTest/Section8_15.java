package CodingTest.src.algorithmTest;

import java.util.Scanner;

public class Section8_15 {
    static int num, shop, count;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void DFS(int x, int y, int[][] arr) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=1 && nx<=num && ny>=1 && ny<=num) {
                    // 집이라면
                    if(arr[nx][ny]==1) {
                        arr[nx][ny] = 0;
                        count += Math.abs(x-nx) + Math.abs(y-ny);
                    }
                    DFS(nx, ny, arr);
                }
            }
        }

    }

    public static void solution(int[][] arr) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                if (arr[i][j] == 2) {
                    DFS(i, j, arr);
                    answer = Math.min(count, answer);
                    count = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        num = in.nextInt();
        shop = in.nextInt();
        int[][] arr = new int[num + 1][num + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        solution(arr);
        System.out.println(answer);
    }
}

