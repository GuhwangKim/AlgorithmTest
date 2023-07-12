package CodingTest.src.programmers_kit.repeat;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Heap1 {
    public int solution(int[] scoville, int K) {
        int cnt =0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        Arrays.stream(scoville).forEach(queue::add);

        while(!queue.isEmpty()){
            if(queue.size()==1){
                if(queue.poll()==K){
                    return cnt;
                } else{
                    return -1;
                }
            }
            int kCandidate = queue.poll()+queue.poll();
            cnt++;
            if(kCandidate==K){
                return cnt;
            } else{
                queue.add(kCandidate);
            }
        }

        return -1;
    }
}
