package CodingTest.src.programmers_lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution88 {
    public int solution(int[] arr) {
        int answer = 0;
        // 최대공약수 구함
        Queue<Integer> queue1 = new LinkedList<>();
        Arrays.stream(arr).forEach(value -> queue1.add(value));



        // 모든 숫자를 곱한 값 / 최대공약수

        return answer;
    }

    public int lcm(int a, int b) {
        int c = 0;
        while (b != 0) {
            c = a%b;
            a = b ;
            b= c;
        }
        return a;
    }
}
