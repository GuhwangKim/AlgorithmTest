package CodingTest.src.secondPrgrammers.lv3;

public class Solution1 {

    /**
     * 연속하는 펄스 부분 수열의 합 https://school.programmers.co.kr/learn/courses/30/lessons/161988
     * */

    public long solution(int[] sequence) {
        long answer = 0;
        long reset = 0;
        // 1. 우선 연산을 한 배열을 각각 생성한 후
        // 2. 각각 연산을 하여 합친 배열도 생성함

        int[] sumFirstMinus = new int[sequence.length];
        int[] sumFirstPlus = new int[sequence.length];
        int n = 1;

        for (int i = 0; i < sequence.length; i++) {
            sumFirstPlus[i] = sequence[i] * n;
            n *= -1;
            sumFirstMinus[i] = sequence[i] * n;
        }
        // ** 이 부분이 핵심 **
        // 연산의 결과 값을 넣어주는 배열
        long[] operationArrPlus = new long[sequence.length];
        long[] operationArrMinus = new long[sequence.length];

        answer = Math.max(operationArrPlus[0], operationArrMinus[0]);

        for (int i = 1; i < sequence.length; i++) {
            // 이전과 현재 더한 것 vs 현재 값
            // 더 큰 값을 배열에 넣어줌
            operationArrPlus[i] = Math.max(operationArrPlus[i - 1] + sumFirstPlus[i], sumFirstPlus[i]);
            operationArrMinus[i] = Math.max(operationArrMinus[i - 1] + sumFirstMinus[i], sumFirstPlus[i]);
            reset = Math.max(operationArrPlus[i], operationArrMinus[i]);
            answer = Math.max(reset, answer);
        }

        return answer;
    }
}
