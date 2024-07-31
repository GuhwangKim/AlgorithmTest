package CodingTest.src.programmers_lv2;

import java.util.Arrays;

public class Solution97 {
    public long solution(int n, int[] works) {
        long answer = 0;
        int amount;
        // ���ް��� ���� ��� ���� ���� ���� ��
        // �� ���� ���� �迭�� ��� ������ ���� �Ŀ�
        // ������ �� �� ���̸�ŭ �迭���� ���� ���ָ�?
        if (n >= works.length) {
            // ���� �۾����� �� �������� ū ���
            amount = n / works.length;
            System.out.println("amount : "+amount);
        } else {
            amount = 0;
        }
        int rest = n % works.length;

        Arrays.stream(works).map(s -> s - amount);
        for (int i = 0; i < rest; i++) {
            works[i] -= -1;
            System.out.println("works[i] : "+works[i]);
        }

        answer = Arrays.stream(works).map(s -> s*s).sum();
        return answer;
    }
}