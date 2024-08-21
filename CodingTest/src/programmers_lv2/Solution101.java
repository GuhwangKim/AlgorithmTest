package CodingTest.src.programmers_lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution101 {

    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        // 1번에서 시작하면, 1번 마을은 무조건 방문 가능
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            // 빈 공간을 만듦
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < road.length; i++) {
            // Node들의 list가 list의 값임
            list.get(road[i][0]).add(new Node(road[i][0], road[i][1], road[i][2]));
            list.get(road[i][1]).add(new Node(road[i][1], road[i][0], road[i][2]));
            // 양쪽에 모두 다 같은 2의 값을 넣어줌
        }

        Queue<Node> queue = new LinkedList<>();
        int[] visited = new int[N + 1];
        for (int i = 2; i < visited.length; i++) {
            visited[i] = Integer.MAX_VALUE;
            // 방문 배열을 모두 max의 값으로 집어넣음
        }
        // 처음 값을 담음
        queue.addAll(list.get(1));

        // 반복 - DFS
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (visited[n.x] <= visited[n.y] + n.v) {
                // 여기서 왜 y + v를 하는 건지?
                continue;
            }
            visited[n.x] = visited[n.y] + n.v;
            queue.addAll(list.get(n.x));
        }
        for (int i = 2; i < visited.length; i++) {
            if (visited[i] <= K) {
                answer++;
            }
        }
        return answer;
    }


    static class Node {
        int x, y, v;

        public Node(int x, int y, int v) {
            this.x = y;
            this.y = x;
            this.v = v;
        }
    }



}

