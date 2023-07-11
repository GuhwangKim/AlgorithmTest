package CodingTest.src.programmers_lv2;

public class Solution14 {
	public long solution(int[] sequence) {
		/**
		 * ó�� ���ڰ� + ��� �������� ���� �׷��� �� ������ - �� ���� ���� ���� ������ �״�� �����Ǿ�� �� math.max�� ����ؼ�
		 * �����س���
		 */

		long reset = 0;
		long answer = 0;
		int[] sumFirstMinus = new int[sequence.length];
		int[] sumFirstPlus = new int[sequence.length];
		int n = 1;

		for (int i = 0; i < sequence.length; i++) {
			sumFirstPlus[i] = sequence[i]*n;
			n *= -1;
			sumFirstMinus[i] = sequence[i]*n;
		}
        long[] operationArrPlus = new long[sequence.length];
        long[] operationArrMinus = new long[sequence.length];

        operationArrPlus[0] = sumFirstPlus[0];
        operationArrMinus[0] = sumFirstMinus[0];

		answer = Math.max(operationArrPlus[0], operationArrMinus[0]);
		
		for (int i = 1; i < sequence.length; i++) {
            operationArrPlus[i] = Math.max(operationArrPlus[i-1]+sumFirstPlus[i], sumFirstPlus[i]);
            operationArrMinus[i] = Math.max(operationArrMinus[i-1]+sumFirstMinus[i], sumFirstMinus[i]);
			reset = Math.max(operationArrPlus[i], operationArrMinus[i]);
			answer = Math.max(reset, answer);
		}

		return answer;

	}
}
