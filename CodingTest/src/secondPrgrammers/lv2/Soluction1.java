package CodingTest.src.secondPrgrammers.lv2;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ӵ� �κ� ������ ��
 * */
public class Soluction1 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int leftIdx = 0; // ����
        int curSum = 0;
        int curSize = sequence.length;

        for (int rightIdx = 0; rightIdx < sequence.length; rightIdx++) {
            curSum += sequence[rightIdx];
            while (rightIdx < sequence.length && curSum > k) {
                // ���ʿ��� �ڷ� �̵���
                curSum -= sequence[leftIdx];
                leftIdx++;
            }
            if (curSum == k) {
                // ã������ �ϴ� ��
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
