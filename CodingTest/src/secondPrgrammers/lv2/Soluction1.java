package CodingTest.src.secondPrgrammers.lv2;

import java.util.ArrayList;
import java.util.List;

/**
 * 연속된 부분 수열의 합
 * */
public class Soluction1 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int leftIdx = 0; // 시작
        int curSum = 0;
        int curSize = sequence.length;

        for (int rightIdx = 0; rightIdx < sequence.length; rightIdx++) {
            curSum += sequence[rightIdx];
            while (rightIdx < sequence.length && curSum > k) {
                // 왼쪽에서 뒤로 이동함
                curSum -= sequence[leftIdx];
                leftIdx++;
            }
            if (curSum == k) {
                // 찾으려고 하는 값
                if (curSize > rightIdx - leftIdx) {
                    curSize = rightIdx - leftIdx;
                    answer[0] = leftIdx;
                    answer[1] = rightIdx;
                }
            }
        }

        return answer;
    }
}
