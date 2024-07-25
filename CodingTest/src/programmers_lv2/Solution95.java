package CodingTest.src.programmers_lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution95 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        if (n > s) {
            // 자연수의 개수가 더해지는 합보다 작은 경우 => 조건 부합 x
            return new int[]{-1};
        }
        // ** 중간층의 값이 나오면 가장 크다 **
        // s 를 n 만큼으로 쪼갠다

        for (int i = 0; i < n; i++) {
            answer[i] = s / n; // 몫을 너어줌
        }
        // 그런다음 나머지를 각 수에다가 더해주면 됨
        for (int i = 0; i < s%n; i++) {
            answer[i] ++;
        }
        Arrays.sort(answer);
        return answer;
    }
}
