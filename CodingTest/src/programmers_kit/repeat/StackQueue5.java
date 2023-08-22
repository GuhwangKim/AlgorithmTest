package CodingTest.src.programmers_kit.repeat;

public class StackQueue5 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        /**
         * answer에 나올 수 있는 수는 prices idx
         * */

        for (int i = 0; i < prices.length; i++) {
            int result = 0;
            for (int j = i+1; j < prices.length; j++) {
                result++;
                if(prices[i]>prices[j]){
                    answer[i]= result;
                    break;
                }
            }
            answer[i] = result;
        }

        return answer;
    }
}
