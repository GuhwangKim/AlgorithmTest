package CodingTest.src.secondPrgrammers.lv2;

import lombok.Data;

import java.util.*;

public class Solution2 {
    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/176962
     * */
    public String[] solution(String[][] plans) {
        // ��� ���� ������ ������ -> �ֱٿ� ���� �� ���� ���� (Stack)

        String[] answer = new String[plans.length];
        int idx = 0;
        LinkedList<Assignment> tasks = new LinkedList<>();
        for (String[] plan : plans) {
            tasks.offer(new Assignment(plan[0], convertToMinute(plan[1]), Integer.parseInt(plan[2])));
        }
        // ����
        tasks.sort((o1, o2) -> o1.start - o2.start);

        // ���� ��
        Stack<Assignment> stopTasks = new Stack<>();

        Assignment currentAssign = tasks.poll();
        int time = currentAssign.start;

        while (!tasks.isEmpty()) {
            // ���� ����
            // ���� �ð� + �����ִ� �ð�  = �� ���� �ð�
            time += currentAssign.left;
            // �� ���� ��
            Assignment next = tasks.peek();

            if (time > next.start) {
                // �ش� �ϰ� �ʰ� ��
                currentAssign.left = time - next.start; // �����ð�
                stopTasks.push(currentAssign); // ���� ��
            } else {
                answer[idx] = currentAssign.subject;
                idx++;
                if (!stopTasks.empty()) {
                    // �����ִ°� ������ ** �켱 �����ִ� �� �켱
                    currentAssign = stopTasks.pop();
                    continue;
                }
            }
            currentAssign = tasks.poll(); // while �� �ٱ����� ���������Ƿ�
            time = currentAssign.start;
        }

        // ������ ����
        answer[idx] = currentAssign.subject;

        // ������ �����ִ� ������ �� �������
        while (!stopTasks.isEmpty()) {
            answer[idx] = stopTasks.pop().subject;
            idx++;
        }

        return answer;
    }

    class Assignment {
        private String subject;
        private int start;
        private int left;

        public Assignment(String subject, int start, int left) {
            this.subject = subject;
            this.start = start;
            this.left = left;
        }
    }

    private int convertToMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}
