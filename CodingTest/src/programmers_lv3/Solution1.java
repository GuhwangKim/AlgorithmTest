package CodingTest.src.programmers_lv3;

import java.util.Arrays;
import java.util.Collections;

public class Solution1 {
    // �Ž����� https://school.programmers.co.kr/learn/courses/30/lessons/12907
    private int[][] dp;

    public int solution(int n, int[] money) {
        // 2���� �迭���� ���� ���� X ���;� �ϴ� �ݾ�
        // �ڱ� �ڽ��� ���� �� 1 �߰�
        dp = new int[money.length][n + 1]; // �ش� �ݾ��� ǥ�� ���;��ϱ� ����
        for (int i = 1; i <= money.length; i++) {
            for (int j = 0; j <= n; j++) { // ���η� ���� ������
                if (j == 0) {
                    dp[i][j] = 1; // �� ù�� ° ���� 1�� �ʱ�ȭ
                } else if (j - money[i - 1] >= 0) {
                    // ������ �۰ų� ���� ���
                    dp[i][j] = (dp[i-1][j] + dp[i][j-money[i-1]])%10000007;
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[money.length][n];
    }
}
