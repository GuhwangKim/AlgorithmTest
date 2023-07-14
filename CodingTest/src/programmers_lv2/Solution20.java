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
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(long weight : weights){
            queue.add(weight);
        }
        HashSet<Long> set = new HashSet<>();
        for(long weight : weights){
            set.add(weight*1);
            set.add(weight*2);
            set.add(weight*3);
            set.add(weight*4);

        }

        while(!queue.isEmpty()){
            long num = queue.poll();
            for (int i = 1; i <=4 ; i++) {
                long standnum = num*i;
                if(set.contains(standnum)){
                    answer++;
                    set.remove(standnum);
                    continue;
                }
            }
        }

        return answer;
    }
}
