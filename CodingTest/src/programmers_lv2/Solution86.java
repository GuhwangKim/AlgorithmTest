package CodingTest.src.programmers_lv2;

import java.io.IOException;

public class Solution86 {
    public int solution(int sticker[]) throws IOException {

        int n = sticker.length;
        if (n == 1) {
            // 하나 뿐이라면
            return sticker[0];
        }

        int[] dp = new int[sticker.length + 2];

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + sticker[i-2], dp[i-1]);
            //  바로 앞에 글자가 선택되는 경우 -> 그 전전 최대값 + 그 전전값 / 바로 앞글자 선택 안된 경우 현재 값
        }
        int secondMax = dp[dp.length-1];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + sticker[i-2], dp[i-1]);
            //  바로 앞에 글자가 선택되는 경우 -> 그 전전 최대값 + 그 전전값 / 바로 앞글자 선택 안된 경우 현재 값
        }
        int firstMax = dp[dp.length-2];

        return Math.max(firstMax, secondMax);
    }
}
