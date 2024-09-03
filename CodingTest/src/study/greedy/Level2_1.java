package CodingTest.src.study.greedy;

import java.util.Arrays;

public class Level2_1 {
    /**
     * 1) �ּ��� ���� ��Ʈ = �ִ�� ���� ��ƾ� �ϹǷ�,
     * �켱�� �迭�� ������������ ����
     * 2) �ִ� 2�θ� �����ϹǷ�
     * ������ �ִ밪���� ���������� �׻� ŭ
     * �� �ڷ� ���ؼ� ���� ���ؼ� �� ���� �������� ���� ������ �ΰ��� ����
     * */
    public int solution(int[] people, int limit) {
        int answer = 0;
        if (people.length == 1) {
            return 1;
        }

        Arrays.sort(people); // ��������
        int startIdx = 0;
        int endIdx = people.length-1;

        for (int i = endIdx; i >= startIdx; i--) {
            if (people[i] + people[startIdx] <= limit) {
                // 2�� �Բ�
                startIdx++;
            }
            answer++;
        }

        return answer;
    }
}
