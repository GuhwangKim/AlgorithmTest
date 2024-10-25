package CodingTest.src.secondPrgrammers.lv2;

import lombok.Data;

import java.util.*;

public class Solution2 {
    /**
     * https://school.programmers.co.kr/learn/courses/30/lessons/176962
     * */
    public String[] solution(String[][] plans) {
        // 1. 진행중이다가 새로운 과제 -> 진행중이던 것 종료
        // 2. 과제 끝내면 기다리고 있던 것 시작 (멈춘 순서대로)
        // 3. 멈춘 것 vs  새로운 것이 있다면 새로운 것을 시작

        // 분밖에 없기 때문에, 분으로 만들어버리자
        // 시작 시간을 중심으로 배열을 정렬해야함 즉 1번째 인덱스
        // 과목과 분으로 밖은 시작과 끝 시간을 담은 클래스를 만들어서 이걸 기준으로

        List<String> answer = new ArrayList<>();

        // 순서를 변경해줄 예정이므로 linkedlist
        List<Assignment> list = new ArrayList<>();

        // 재조립
        for (String[] plan : plans) {
            String[] separated = plan[1].split(":");
            long startHour = Long.valueOf(separated[0]) * 60 + Long.valueOf(separated[1]);
            // 시작 시간 변환
            Assignment assignment = new Assignment(plan[0], startHour, startHour + Long.valueOf(plan[2]));
            list.add(assignment);
        }

        // 시작 시간 순으로 정렬
        Collections.sort(list, new StartComprator());
        answer.add(list.get(0).getSubject());// 첫번째 과목

        // 대기 큐
        Queue<Assignment> queue = new LinkedList<>();
        queue.add(list.get(0)); // 가장 첫번째 것 넣음 

        // 시작
        while (!queue.isEmpty()) {
            for (int i = 1; i < list.size(); i++) {
                if (queue.peek().getEnd() > list.get(i).getEnd()) {
                    // next의 시작이 curr end 보다 작으면 next가 시작임
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
