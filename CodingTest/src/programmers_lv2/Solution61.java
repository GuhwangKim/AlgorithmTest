package CodingTest.src.programmers_lv2;

import java.math.BigInteger;

public class Solution61 {
    public long solution(int w, int h) {
        long answer = 1;
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        // w �� h�� �ִ� �����
        answer = ((long)w * (long)h) - ((((long)w/gcd)+((long)h/gcd)-1)*gcd);

        return answer;
    }
}
