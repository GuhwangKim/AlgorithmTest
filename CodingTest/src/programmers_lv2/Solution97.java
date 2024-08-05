package CodingTest.src.programmers_lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import static java.lang.Long.sum;

public class Solution97 {
    public long solution(int n, int[] works) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        // ���� ���� �켱

        for (int work : works) {
            queue.add(work);
            // queue�� ���� �������
        }

        for (int i = 0; i < n; i++) {
            int max = queue.poll();
            // ������ ���� ū ��
            if (max <= 0) {
                // ���� ū���� 0�̶�� N���� �� �Ҵ� �� ��
                break;
            } else {
                // max�� ���� ����
                queue.add(max - 1);
                // �� �ϳ��� �����ϰ� ����
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