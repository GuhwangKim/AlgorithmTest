package CodingTest.src.programmers_lv2;

public class Solution91 {
    public int solution(int n) {
        int answer = cal(n);

        return answer;
    }
    public int cal(int n) {
        int[] cache = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            cache[i] = (cache[i-1] + cache[i-2])%1234567;
        }

        return cache[n];
    }
}
