package CodingTest.src.programmers_lv3;

import java.util.Arrays;
import java.util.Collections;

public class Solution1 {
    // �Ž����� https://school.programmers.co.kr/learn/courses/30/lessons/12907

    static int answer = 0;

    public int solution(int n, int[] money) {

        // ��� �������� ���ϰ�
        // ���� 1�� ������ ���� �޼��带
        // money�� �ִ� ���� n���ٴ� �۰ų� ���ƾ� ��

        // �������� money �迭�� �����ϴ���
        // 1 ~ share ��ŭ ���ذ��鼭 Ȯ��
        check(0, money, n);

        return answer;
    }

    private void check(int currentIdx, int[] money, int n) {
        if (currentIdx < 0) {
            // �ε����� ��
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
            // ��
            int share = n / money[currentIdx]; // 2
            // �������� ����
            int rest = n % money[currentIdx]; // 1

            for (int i = 1; i <= share; i++) {
                check();
            }


        }
    }
}
