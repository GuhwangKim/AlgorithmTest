package CodingTest.src.programmers_lv2;

import java.util.Arrays;

public class Solution93 {
    static int row = -1;
    static int col = -1;

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
        // �迭�� ���� ��ŭ �ݺ���
        for (int i = 0; i < A.length; i++) {
            answer += findMin(AB);
        }

        return answer;
    }

    public static int findMin(int[][] arr) {
        int min = 9999999;

        for (int i = 0; i < arr.length; i++) {
            if (i == row) {
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
        return min;
    }
}
