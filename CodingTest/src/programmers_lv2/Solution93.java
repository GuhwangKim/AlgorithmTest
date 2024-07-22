package CodingTest.src.programmers_lv2;

import java.util.Arrays;

public class Solution93 {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        // 각각의 모든 숫자들을 다 곱한 값이 있는 배열 생성
        int[][] AB = new int[A.length][B.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                AB[i][j] = A[i] * B[j];
            }
        }

        // 여기서 가장 작은수대로 뽑아서 추출하고, 그 뽑은 결과물의 행과 열 아닌 값

        return answer;
    }

    public static int findMin(int[][] arr) {
        int min = 9999999;

        for (int[] each : arr) {
            for (int num : each) {
                if (num < min) {
                    min = num;
                }
            }
        }
        return min;
    }
}
