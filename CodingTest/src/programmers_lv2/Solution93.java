package CodingTest.src.programmers_lv2;

import java.util.Arrays;

public class Solution93 {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        // ������ ��� ���ڵ��� �� ���� ���� �ִ� �迭 ����
        int[][] AB = new int[A.length][B.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                AB[i][j] = A[i] * B[j];
            }
        }

        // ���⼭ ���� ��������� �̾Ƽ� �����ϰ�, �� ���� ������� ��� �� �ƴ� ��

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
