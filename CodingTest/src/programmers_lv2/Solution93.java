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
        //������ ��� ���ڵ��� �� ���ڰ� ������
        // �ּ� ���� �ִ밪�� �������� �Ǵ� ��
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
            if (i == row) { // �ش� ��� ���� �����ٸ� �� ���ڴ� ���̻� ���� ����
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
