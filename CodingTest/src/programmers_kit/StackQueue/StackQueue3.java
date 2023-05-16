package CodingTest.src.programmers_kit.StackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StackQueue3 {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        /*
        7, 3, 9
        5, 10, 1, 1, 20, 1

        */
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            for (int j = 1; j <=100 ; j++) {
                progresses[0]+=speeds[0];
                if(progresses[0]==100) {
                    queue.add(j);
                    break;
                }
            }
        }

        while (queue.isEmpty()){
            int cnt = 1;
            int tot = 0;
            int queueFirst = queue.poll();
            if(tot>queue.peek()){
                tot += queueFirst;
                cnt++;
            }else{
               answer.add(cnt);
            }
        }
        return answer;
    }
}
