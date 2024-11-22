package CodingTest.src.secondPrgrammers.lv3;

public class Solution1 {

    /**
     * �����ϴ� �޽� �κ� ������ �� https://school.programmers.co.kr/learn/courses/30/lessons/161988
     * */

    public long solution(int[] sequence) {
        long answer = 0;
        long reset = 0;
        // 1. �켱 ������ �� �迭�� ���� ������ ��
        // 2. ���� ������ �Ͽ� ��ģ �迭�� ������

        int[] sumFirstMinus = new int[sequence.length];
        int[] sumFirstPlus = new int[sequence.length];
        int n = 1;

        for (int i = 0; i < sequence.length; i++) {
            sumFirstPlus[i] = sequence[i] * n;
            n *= -1;
            sumFirstMinus[i] = sequence[i] * n;
        }
        // ** �� �κ��� �ٽ� **
        // ������ ��� ���� �־��ִ� �迭
        long[] operationArrPlus = new long[sequence.length];
        long[] operationArrMinus = new long[sequence.length];

        answer = Math.max(operationArrPlus[0], operationArrMinus[0]);

        for (int i = 1; i < sequence.length; i++) {
            // ������ ���� ���� �� vs ���� ��
            // �� ū ���� �迭�� �־���
            operationArrPlus[i] = Math.max(operationArrPlus[i - 1] + sumFirstPlus[i], sumFirstPlus[i]);
            operationArrMinus[i] = Math.max(operationArrMinus[i - 1] + sumFirstMinus[i], sumFirstPlus[i]);
            reset = Math.max(operationArrPlus[i], operationArrMinus[i]);
            answer = Math.max(reset, answer);
        }

        return answer;
    }
}
