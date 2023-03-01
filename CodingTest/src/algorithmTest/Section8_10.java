package algorithmTest;

import java.util.Scanner;

public class Section8_10 {
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    private void DFS(int x, int y) {
        if(x==7 && y==7){ // 醫낆갑�젏 , �븿�닔 �걹
            answer++;
        } else{
            // 4 吏��젏�쑝濡� 六쀬뼱�굹媛�
            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                // 寃쎄퀎�꽑 �븞�뿉 �엳�뒗吏�, �뻾 �젹
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0){
                    board[nx][ny]=1;
                    DFS(nx, ny);
                    // �뮘濡� 諛�
                    board[nx][ny]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Section8_10 T = new Section8_10();
        Scanner in = new Scanner(System.in);
        board = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = in.nextInt();
            }
        }
        board[1][1] = 1;
        T.DFS(1, 1);
        System.out.println(answer);
    }


}
