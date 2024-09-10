package CodingTest.src.programmers_lv2;

public class Solution104 {
    public int solution(int n) {
        int cntI = Integer.bitCount(n);

        while (true) {
            n++;
            if (cntI == Integer.bitCount(n)) {
                return n;
            }
        }
    }
}
