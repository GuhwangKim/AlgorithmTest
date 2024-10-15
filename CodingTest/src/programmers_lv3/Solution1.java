package CodingTest.src.programmers_lv3;

import java.util.Arrays;
import java.util.Collections;

public class Solution1 {
    // 거스름돈 https://school.programmers.co.kr/learn/courses/30/lessons/12907
    private int[][] dp;

    public int solution(int n, int[] money) {
        // 2차원 배열에서 돈의 개수 X 나와야 하는 금액
        // 자기 자신이 나올 때 1 추가
        dp = new int[money.length][n + 1]; // 해당 금액이 표에 나와야하기 때문
        for (int i = 1; i <= money.length; i++) {
            for (int j = 0; j <= n; j++) { // 가로로 가는 개념임
                if (j == 0) {
                    dp[i][j] = 1; // 맨 첫번 째 열은 1로 초기화
                } else if (j - money[i - 1] >= 0) {
                    // 돈보다 작거나 같은 경우
                    dp[i][j] = (dp[i-1][j] + dp[i][j-money[i-1]])%10000007;
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[money.length][n];
    }
}
