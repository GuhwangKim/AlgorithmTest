package CodingTest.src.programmers_lv2;

public class Solution108 {
    public String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        String answer = "";

        // 3으로 우선 나눈 후
        // 나머지는 뒤에 붙여주고 앞자리는 루프
        // 나머지가 0인 경우 4
        int num = n;
        // 가장 끝 자리수
        while (num > 0) {
            // 계속해서 이어 붙임
            int remain = num % 3; // 나머지
            num /= 3;// 몫
            if (remain == 0) {
                num--;
            }
            answer = numbers[remain] + answer;

        }
        return answer;
    }
}
