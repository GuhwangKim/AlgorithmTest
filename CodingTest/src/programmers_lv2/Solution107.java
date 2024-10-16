package CodingTest.src.programmers_lv2;

public class Solution107 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12900
    // 2 x n 타일링
    public int solution(int n) {
        int answer = 0;
        // 값이 주어졌을 때, 이 값을 2와 1로 어떻게 구성할 수 있냐의 여부
        // 0이면 1
        //짝수는
        // 2가 0개 -> 1
        // 2가 1개  -> (n-(2*개수))=1의개수 * 개수  = 2
        // 2가 2개 -> 1
        // 홀수 5
        // 2가 0 -> 1
        // 2가 1 -> 4
        // 2가 2 -> 2
        int twoCnt = 0;

        while (2 * twoCnt <= n) {
            int tmp = twoCnt * (n-(2*twoCnt));
            if (tmp == 0) {
                answer += 1;
            }else{
                answer += tmp;
            }
            twoCnt++;
        }
        return answer;
    }
}
