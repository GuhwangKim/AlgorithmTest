package CodingTest.src.programmers_lv2;

public class Solution107 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12900
    // 2 x n ≈∏¿œ∏µ
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10000007;
        }
        return answer;
    }
}
