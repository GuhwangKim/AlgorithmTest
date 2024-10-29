package CodingTest.src.secondPrgrammers.lv2;

import lombok.Data;

import java.util.*;

public class Solution2 {
    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/176962
     * */
    public String[] solution(String[][] plans) {
        // 잠시 멈춘 과제가 있으면 -> 최근에 멈춘 것 부터 진행 (Stack)

        String[] answer = new String[plans.length];
        int idx = 0;
        LinkedList<Assignment> tasks = new LinkedList<>();
        for (String[] plan : plans) {
            tasks.offer(new Assignment(plan[0], convertToMinute(plan[1]), Integer.parseInt(plan[2])));
        }
        // 정렬
        tasks.sort((o1, o2) -> o1.start - o2.start);

        // 남은 일
        Stack<Assignment> stopTasks = new Stack<>();

        Assignment currentAssign = tasks.poll();
        int time = currentAssign.start;

        while (!tasks.isEmpty()) {
            // 과제 돌림
            // 시작 시간 + 남아있는 시간  = 총 업무 시간
            time += currentAssign.left;
            // 그 다음 일
            Assignment next = tasks.peek();

            if (time > next.start) {
                // 해당 일감 초과 함
                currentAssign.left = time - next.start; // 남은시간
                stopTasks.push(currentAssign); // 남은 일
            } else {
                answer[idx] = currentAssign.subject;
                idx++;
                if (!stopTasks.empty()) {
                    // 남아있는게 있으면 ** 우선 남아있는 것 우선
                    currentAssign = stopTasks.pop();
                    continue;
                }
            }
            currentAssign = tasks.poll(); // while 문 바깥에서 설정했으므로
            time = currentAssign.start;
        }

        // 마지막 과제
        answer[idx] = currentAssign.subject;

        // 마지막 남아있는 과제들 싹 집어넣음
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
