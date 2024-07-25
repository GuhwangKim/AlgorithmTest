package CodingTest.src.programmers_lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution95 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        if (n > s) {
            // �ڿ����� ������ �������� �պ��� ���� ��� => ���� ���� x
            return new int[]{-1};
        }
        // ** �߰����� ���� ������ ���� ũ�� **
        // s �� n ��ŭ���� �ɰ���

        for (int i = 0; i < n; i++) {
            answer[i] = s / n; // ���� �ʾ���
        }
        // �׷����� �������� �� �����ٰ� �����ָ� ��
        for (int i = 0; i < s%n; i++) {
            answer[i] ++;
        }
        Arrays.sort(answer);
        return answer;
    }
}
