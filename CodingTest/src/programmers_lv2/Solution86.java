package CodingTest.src.programmers_lv2;

import java.io.IOException;

public class Solution86 {
    public int solution(int sticker[]) throws IOException {
        int answer = 0;
        // 첫번째 원소를 뽑는 경우 - 마지막 원소 뽑을 수 없음
        // 첫번쨰 원소를 뽑지 않는 경우

        int n = sticker.length;
        if (n == 1) {
            // 하나 뿐이라면
            answer = sticker[0];
        }

        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];

        dp1[0] = sticker[0];
        dp2[1] = sticker[0];

        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + sticker[i], Math.max(dp1[i - 1], dp1[i - 2]));
        }

        dp2[0] = 0;
        dp2[1] = sticker[1];

        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], Math.max(dp2[i - 1], dp2[i - 2]));
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}
