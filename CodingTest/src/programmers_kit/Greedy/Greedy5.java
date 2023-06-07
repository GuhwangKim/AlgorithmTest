package CodingTest.src.programmers_kit.Greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Greedy5 {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, ((o1, o2) -> o1[1]-o2[1]));
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < routes.length; i++) {
            if(queue.isEmpty()){
                queue.add(routes[i][1]);
                answer++;
                continue;
            }
            if(queue.peek()>=routes[i][0]){
                continue;
            } else{
                answer++;
                queue.poll();
                queue.add(routes[i][1]);
            }

        }


        return answer;
    }
}
