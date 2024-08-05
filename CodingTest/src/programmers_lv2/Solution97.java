package CodingTest.src.programmers_lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import static java.lang.Long.sum;

public class Solution97 {
    public long solution(int n, int[] works) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        // 높은 숫자 우선

        for (int work : works) {
            queue.add(work);
            // queue에 일을 집어넣음
        }

        for (int i = 0; i < n; i++) {
            int max = queue.poll();
            // 현재의 가장 큰 수
            if (max <= 0) {
                // 가장 큰수가 0이라면 N에서 다 할당 된 것
                break;
            } else {
                // max에 수가 남음
                queue.add(max - 1);
                // 일 하나를 제거하고 넣음
            }
        }

        return sum(queue);
    }

    private long sum(PriorityQueue<Integer> queue) {
        long sum = 0;
        while (!queue.isEmpty()) {
            sum += Math.pow(queue.poll(), 2);
        }
        return sum;
    }
}