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
         * ���ϴ� �������� ������ ���ϴ� ��ü �޼ҵ�
         * */
        // 1. ������ �������� ���ϴ� ���
        set = new HashSet<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i; j < line.length; j++) {
                // �� ������ 2���� ���� ������
                long a = line[i][0], b = line[i][1], c= line[i][2];
                long d = line[j][0], e = line[j][1], f= line[j][2];
                long divideBottom = a*e - b*d;
                if(divideBottom!=0){
                    // 0�� �ƴϸ� ���� �� �ֱ� ����
                    long dividedX = b*f - c*e;
                    // y�� ���� ����
                    long dividedY = c*d - a*f;
                    // y�� ���� ����
                    if(dividedX/divideBottom==0 && dividedY/divideBottom ==0){
                        // ������ �������� = ����
                        set.add(new Point((int)dividedX/(int)divideBottom, (int)dividedX/(int)divideBottom));
                    }
                }
            }
        }

        // 2. ���� x, y�� �ִ�ġ�� ���ؼ� �� �ȿ����� ������ ǥ�� �Ǹ� ��
        getSize(set.size());



        String[] answer = {};
        return answer;
    }

    private void getSize(int size) {
        List<Point> list = new LinkedList<>(set);

        // x�� �������� �ִ� �ּ�
        Collections.sort(list, (o1, o2) -> o1.x - o2.x);
        minX = list.get(0).x; maxX = list.get(size-1).x;
        Collections.sort(list, (o1, o2) -> o1.y - o2.y);
        minY = list.get(0).y; maxY = list.get(size-1).y;
    }
}
