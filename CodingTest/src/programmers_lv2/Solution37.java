package CodingTest.src.programmers_lv2;

import java.util.Arrays;

public class Solution37 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        for(int[] arr : skill){

            int type = arr[0];
            int startRow = arr[1];
            int startCol = arr[2];
            int endRow = arr[3];
            int endCol = arr[4];
            int degree = arr[5];

            if(type==1){
                // - 하나하나 하다보면 시간
                for (int i = startRow; i <= endRow; i++) {
                    for (int j = startCol; j <= endCol; j++) {
                        board[i][j] -=degree;
                    }
                }

            } else{
                // +
                for (int i = startRow; i <= endRow; i++) {
                    for (int j = startCol; j <= endCol; j++) {
                        board[i][j] +=degree;
                    }
                }
            }
        }

        for(int[] bod : board){
            System.out.println(bod[0]);
            int cnt = (int) Arrays.stream(bod).filter(value -> value>0).count();
            answer+=cnt;
        }
        return answer;
    }
}
