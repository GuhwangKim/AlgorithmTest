package CodingTest.src.programmers_lv3;

import java.util.Arrays;
import java.util.Collections;

public class Solution1 {
    // 거스름돈 https://school.programmers.co.kr/learn/courses/30/lessons/12907

    static int answer = 0;

    public int solution(int n, int[] money) {

        // 몫과 나머지를 구하고
        // 몫이 1일 때까지 같은 메서드를
        // money에 있는 값은 n보다는 작거나 같아야 함

        // 나머지가 money 배열에 존재하는지
        // 1 ~ share 만큼 곱해가면서 확인
        check(0, money, n);

        return answer;
    }

    private void check(int currentIdx, int[] money, int n) {
        if (currentIdx < 0) {
            // 인덱스의 끝
            return;
        }
        if (money[currentIdx] > n) {
            currentIdx--;
            check(currentIdx, money, n);
        } else if (money[currentIdx] == n) {
            answer++;
            currentIdx--;
            check(currentIdx, money, n);
        }else{
            // 몫
            int share = n / money[currentIdx]; // 2
            // 나머지를 구함
            int rest = n % money[currentIdx]; // 1

            for (int i = 1; i <= share; i++) {
                check();
            }


        }
    }
}
