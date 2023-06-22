package CodingTest.src.programmers_lv2;

public class Solution14 {
    public long solution(int[] sequence) {
        /**
         * 처음 숫자가 + 라면 에서부터 시작
         * 그러면 그 다음은 - 를 붙임
         * 더해 나감
         * 순서가 그대로 유지되어야 함
         * math.max를 계속해서 변경해나감
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
