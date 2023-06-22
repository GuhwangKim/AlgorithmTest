package CodingTest.src.programmers_lv2;

public class Solution14 {
    public long solution(int[] sequence) {
        /**
         * ó�� ���ڰ� + ��� �������� ����
         * �׷��� �� ������ - �� ����
         * ���� ����
         * ������ �״�� �����Ǿ�� ��
         * math.max�� ����ؼ� �����س���
         * */

        long answerFM = -100001;
        long answerFP = -100001;
        long sumFirstMinus = 0;
        long sumFirstPlus = 0;
        long reset = 0;
        long answer = 0;
        for (int j = 0; j < sequence.length; j++) {
            for (int i = j; i < sequence.length; i++) {
                if(i%2==0){
                    // -1 1
                    sumFirstMinus+=sequence[i];
                    sumFirstPlus+=sequence[i]*-1;
                }else{
                    sumFirstMinus+=sequence[i]*-1;
                    sumFirstPlus+=sequence[i];
                }
                answerFM = Math.max(sumFirstMinus, answerFM);
                answerFP = Math.max(sumFirstPlus, answerFP);
            }
            reset = Math.max(answerFM, answerFP);
            answer = Math.max(reset, answer);
            answerFM = -100001;
            answerFP = -100001;
        }


        return answer;

    }
}
