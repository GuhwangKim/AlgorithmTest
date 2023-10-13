package CodingTest.src.programmers_lv2;

import java.util.*;

public class Solution48 {
    class Point {
        int node;
        int cost;

        public Point(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        /**
         * �迭�� ù��°�� �������� ������
         * 1. KEY : 1 ~ N ����
         * 2. VALUE : ���� NODE �� COST ���� ���� Ŭ������ LIST ���·� ��
         * 3. �ش� MAP�� QUEUE �� ����
         * 4. ������ ��尡 ���������� DFS
         * 5. ���� ���� �� ��ȯ
         *
         * */

        // 1. ù���� ���� �������� ������
        Arrays.sort(fares, (o1, o2) -> o1[0]-o2[0]);
        // 2. map �� �����
        Map<Integer, List<Point>> map = new HashMap<>();

        for(int[] fare : fares){

            // 1) ù���� �����ϴ� ���� ��� list�� �־���
            if(map.containsKey(fare[0])){
                map.get(fare[0]).add(new Point(fare[1],fare[2]));
                if(map.containsKey(fare[1])){
                    // 2��° ���� �����ϴ� ���
                    map.get(fare[1]).add(new Point(fare[0],fare[2]));

                }else{
                    // 2���� �� ���� �������
                    List<Point> list = new LinkedList<>();
                    list.add(new Point(fare[0],fare[2]));
                    // ����� ���� �� ���� ���� Point�� �����
                    map.put(fare[1], list);
                    // map�� ���� �����
                }

            } else{
                // 2) ó�� ���� key�� ��� list�� ���� ���� �־���
                List<Point> list = new LinkedList<>();
                list.add(new Point(fare[1],fare[2]));
                // ����� ���� �� ���� ���� Point�� �����
                map.put(fare[0], list);
                if(map.containsKey(fare[1])){
                    // 2��° ���� �����ϴ� ���
                    map.get(fare[1]).add(new Point(fare[0],fare[2]));

                }else{
                    // 2���� �� ���� �������
                    List<Point> list2 = new LinkedList<>();
                    list2.add(new Point(fare[0],fare[2]));
                    // ����� ���� �� ���� ���� Point�� �����
                    map.put(fare[1], list2);
                    // map�� ���� �����
                }

            }



        }



        return answer;
    }
}
