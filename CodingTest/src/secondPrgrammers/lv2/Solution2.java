package CodingTest.src.secondPrgrammers.lv2;

import lombok.Data;

import java.util.*;

public class Solution2 {
    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/176962
     * */
    public String[] solution(String[][] plans) {
        // 1. �������̴ٰ� ���ο� ���� -> �������̴� �� ����
        // 2. ���� ������ ��ٸ��� �ִ� �� ���� (���� �������)
        // 3. ���� �� vs  ���ο� ���� �ִٸ� ���ο� ���� ����

        // �йۿ� ���� ������, ������ ����������
        // ���� �ð��� �߽����� �迭�� �����ؾ��� �� 1��° �ε���
        // ����� ������ ���� ���۰� �� �ð��� ���� Ŭ������ ���� �̰� ��������

        String[] answer = new String[plans.length];

        // ������ �������� �����̹Ƿ� linkedlist
        List<Assignment> list = new ArrayList<>();

        // ������
        for (String[] plan : plans) {
            String[] separated = plan[1].split(":");
            long startHour = Long.valueOf(separated[0]) * 60 + Long.valueOf(separated[1]);
            // ���� �ð� ��ȯ
            Assignment assignment = new Assignment(plan[0], startHour, startHour + Long.valueOf(plan[2]));
            list.add(assignment);
        }

        // ���� �ð� ������ ����
        Collections.sort(list, new StartComprator());

        // ��� ť
        Queue<Assignment> queue = new LinkedList<>();
        for (Assignment assign : list) {
            queue.add(assign);
        }
        int idx = 0;
        // ����
        while (!queue.isEmpty()) {
            Assignment currentAssign = queue.poll();
            // ���� assginment ����

            if (currentAssign.getEnd() > queue.peek().getStart()) {
                // next�� ������ curr end ���� ������ next�� ������
                // next�� ���� �������
                queue.add(currentAssign);
                // ���� �ϰ� �ִ� ���� queue���� ���� �������
            }else{
                answer[idx] = currentAssign.getSubject();
                idx++;
            }
        }
        return answer;
    }

    class Assignment {
        private String subject;
        private long start;
        private long end;

        public Assignment(String subject, long start, long end) {
            this.subject = subject;
            this.start = start;
            this.end = end;
        }

        public String getSubject() {
            return subject;
        }

        public long getStart() {
            return start;
        }

        public long getEnd() {
            return end;
        }
    }

    class StartComprator implements Comparator<Assignment> {
        @Override
        public int compare(Assignment o1, Assignment o2) {
            if (o1.getStart() < o2.getStart()) {
                return 1;
            } else if (o1.getStart() > o2.getStart()) {
                return -1;
            }
            return 0;
        }
    }
}
