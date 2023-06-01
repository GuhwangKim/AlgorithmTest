package CodingTest.src.programmers_kit.StackQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StackQueue5 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int cnt = 0;
            for (int j = i+1; j < prices.length; j++) {
                if(prices[i]>prices[j]){
                    break;
                }
                cnt++;
            }
            answer[i]=cnt;
        }

        return answer;
    }
}
