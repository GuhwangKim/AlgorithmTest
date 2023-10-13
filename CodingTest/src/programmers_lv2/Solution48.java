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
         * 배열은 첫번째를 기준으로 정렬함
         * 1. KEY : 1 ~ N 까지
         * 2. VALUE : 연결 NODE 와 COST 값을 가진 클래스가 LIST 형태로 들어감
         * 3. 해당 MAP을 QUEUE 에 담음
         * 4. 시작점 노드가 끝날때까지 DFS
         * 5. 가장 작은 값 반환
         *
         * */

        // 1. 첫번쨰 값을 기준으로 정렬함
        Arrays.sort(fares, (o1, o2) -> o1[0]-o2[0]);
        // 2. map 에 담아줌
        Map<Integer, List<Point>> map = new HashMap<>();

        for(int[] fare : fares){

            // 1) 첫번쨰 존재하는 수의 경우 list에 넣어줌
            if(map.containsKey(fare[0])){
                map.get(fare[0]).add(new Point(fare[1],fare[2]));
                if(map.containsKey(fare[1])){
                    // 2번째 수가 존재하는 경우
                    map.get(fare[1]).add(new Point(fare[0],fare[2]));

                }else{
                    // 2번쨰 수 새로 만들어줌
                    List<Point> list = new LinkedList<>();
                    list.add(new Point(fare[0],fare[2]));
                    // 연결된 노드와 그 값을 담은 Point를 담아줌
                    map.put(fare[1], list);
                    // map에 값을 담아줌
                }

            } else{
                // 2) 처음 나온 key의 경우 list를 새로 만들어서 넣어줌
                List<Point> list = new LinkedList<>();
                list.add(new Point(fare[1],fare[2]));
                // 연결된 노드와 그 값을 담은 Point를 담아줌
                map.put(fare[0], list);
                if(map.containsKey(fare[1])){
                    // 2번째 수가 존재하는 경우
                    map.get(fare[1]).add(new Point(fare[0],fare[2]));

                }else{
                    // 2번쨰 수 새로 만들어줌
                    List<Point> list2 = new LinkedList<>();
                    list2.add(new Point(fare[0],fare[2]));
                    // 연결된 노드와 그 값을 담은 Point를 담아줌
                    map.put(fare[1], list2);
                    // map에 값을 담아줌
                }

            }



        }



        return answer;
    }
}
