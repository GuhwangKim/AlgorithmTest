package CodingTest.src.programmers_lv2;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution20 {
    public long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights);

        for (int i = 0; i < weights.length-1; i++) {
            for (int j = i+1; j < weights.length; j++) {
                if(weights[i]*2<weights[j])
                if(weights[i]==weights[j]){
                    answer++;
                } else if (weights[i]*2==weights[j]*3) {
                    answer++;
                } else if (weights[i]*2==weights[j]*4) {
                    answer++;
                } else if (weights[i]*3==weights[j]*4) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
