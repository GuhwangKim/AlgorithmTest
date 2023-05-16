package programmers_kit.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Heap2 {

    public int solution(int[][] jobs) {
        // 시작 시점에 따라 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        // jobs 를 잔여 시간에 따라 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int cnt = 0;    // 완료된 작업의 개수
        int total = 0; // 합계 시간
        int endTime = 0; // 짧은 순서대로 정리된 배열에서 작업이 완료된 시간
        int idx = 0; // 0 1 ~


        while (cnt < jobs.length) {
            while (idx < jobs.length && jobs[idx][0]<=endTime) {
                // 1. 한 프로세스가 끝나기 전에 들어온 것들에 대해서
                queue.add(jobs[idx++]);
                // 2. 다 집어넣어줌 - jobs 에서 행별로 추출해서 집어넣음 - 0 1 의 값이 있음
            }

            if(queue.isEmpty()) {
                endTime = jobs[idx][0];
                // 3. 프로세스가 끝나고 나서 후에 실행되는 프로세스가 있을 시에 최종 작업의 완료시간은
                // 시작시간으로 세팅

            } else {
                int[] cur = queue.poll();
                total += cur[1]+endTime-cur[0];
                // 4. 진행시간 + 마지막 완료 시점 - 시작 시점 (이전에 시작한 경우)
                endTime += cur[1];
                // 5. 다시 완료 시점은 작업 진행기간
                cnt ++;
            }
        }
        return total / jobs.length;
    }

}