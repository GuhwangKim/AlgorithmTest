package CodingTest.src.programmers_lv2;

public class Solution106 {
    public int solution(String s)
    {
        int answer = 1;
        int n = s.length();
        loop:
        for (int i = n; i >= 1; i--) {
            // 가장 긴 길이부터
            for (int j = 0; j <= n - 1; j++) {
                // 가장 작은 길이
                boolean flag = true;
                int start = j; // 시작 인덱스
                int end = j+i-1; // 끝 인덱스

                while (start < end) {
                    if (s.charAt(start) != s.charAt(end)) {
                        // 같을 때까지 반복
                        flag = false;
                        break; // while을 빠져나감
                    }
                    start++;
                    end--;
                }
                if (flag) {
                    answer = i;
                    break loop;
                }
            }
        }


        return answer;
    }
}
