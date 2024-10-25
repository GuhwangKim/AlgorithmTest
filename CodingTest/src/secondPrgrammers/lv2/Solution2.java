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

        List<String> answer = new ArrayList<>();

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
        answer.add(list.get(0).getSubject());// ù��° ����

        // ��� ť
        Queue<Assignment> queue = new LinkedList<>();
        queue.add(list.get(0)); // ���� ù��° �� ���� 

        // ����
        while (!queue.isEmpty()) {
            for (int i = 1; i < list.size(); i++) {
                if (queue.peek().getEnd() > list.get(i).getEnd()) {
                    // next�� ������ curr end ���� ������ next�� ������
                }
            }
            

        }


    }

    @Data
    class Assignment {
        private String subject;
        private long start;
        private long end;

        public Assignment(String subject, long start, long end) {
            this.subject = subject;
            this.start = start;
            this.end = end;
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
