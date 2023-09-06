package CodingTest.src.programmers_lv2;

import lombok.RequiredArgsConstructor;

import java.util.*;

public class Solution40 {

    class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }



    static Set<Point> set;
    int minX, maxX, minY, maxY;
    public String[] solution(int[][] line) {
        /**
         * 구하는 방정식의 교점을 구하는 자체 메소드
         * */
        // 1. 정수인 교차점을 구하는 방법
        set = new HashSet<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i; j < line.length; j++) {
                // 총 라인을 2개씩 각각 비교해줌
                long a = line[i][0], b = line[i][1], c= line[i][2];
                long d = line[j][0], e = line[j][1], f= line[j][2];
                long divideBottom = a*e - b*d;
                if(divideBottom!=0){
                    // 0이 아니면 나눌 수 있기 때문
                    long dividedX = b*f - c*e;
                    // y의 값을 연산
                    long dividedY = c*d - a*f;
                    // y의 값을 연산
                    if(dividedX/divideBottom==0 && dividedY/divideBottom ==0){
                        // 나누어 떨어진다 = 정수
                        set.add(new Point((int)dividedX/(int)divideBottom, (int)dividedX/(int)divideBottom));
                    }
                }
            }
        }

        // 2. 교점 x, y의 최대치를 구해서 그 안에서만 교점이 표시 되면 됨
        getSize(set.size());



        String[] answer = {};
        return answer;
    }

    private void getSize(int size) {
        List<Point> list = new LinkedList<>(set);

        // x를 기준으로 최대 최소
        Collections.sort(list, (o1, o2) -> o1.x - o2.x);
        minX = list.get(0).x; maxX = list.get(size-1).x;
        Collections.sort(list, (o1, o2) -> o1.y - o2.y);
        minY = list.get(0).y; maxY = list.get(size-1).y;
    }
}
