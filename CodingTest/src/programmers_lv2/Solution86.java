package CodingTest.src.programmers_lv2;

import java.io.IOException;

public class Solution86 {
    public int solution(int sticker[]) throws IOException {

        int n = sticker.length;
        if (n == 1) {
            // �ϳ� ���̶��
            return sticker[0];
        }

        int[] dp = new int[sticker.length + 2];

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + sticker[i-2], dp[i-1]);
            //  �ٷ� �տ� ���ڰ� ���õǴ� ��� -> �� ���� �ִ밪 + �� ������ / �ٷ� �ձ��� ���� �ȵ� ��� ���� ��
        }
        int secondMax = dp[dp.length-1];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + sticker[i-2], dp[i-1]);
            //  �ٷ� �տ� ���ڰ� ���õǴ� ��� -> �� ���� �ִ밪 + �� ������ / �ٷ� �ձ��� ���� �ȵ� ��� ���� ��
        }
        int firstMax = dp[dp.length-2];

        return Math.max(firstMax, secondMax);
    }
}
