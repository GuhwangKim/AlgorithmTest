package CodingTest.src.programmers_lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution93 {
    static int row = -1;
    static int col = -1;

    public int solution(int []A, int []B)
    {
        int answer = 0;
        //어차피 모든 숫자들은 다 각자가 곱해짐
        // 최소 값과 최대값이 곱해지면 되는 것
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length-1-i];
        }
        return answer;
    }

    public static int findMin(int[][] arr) {
        int min = 9999999;

        for (int i = 0; i < arr.length; i++) {
            if (i == row) { // 해당 행과 열이 뽑혔다면 그 숫자는 더이상 쓰지 않음
                continue;
            }
            for (int j = 0; j < arr.length; j++) {
                if (j == col) {
                    continue;
                }
                if (arr[i][j] < min) {
                    min = arr[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println(min);
        return min;
    }
}
