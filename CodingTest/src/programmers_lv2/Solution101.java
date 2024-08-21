package CodingTest.src.programmers_lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution101 {

    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        // 1������ �����ϸ�, 1�� ������ ������ �湮 ����
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            // �� ������ ����
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < road.length; i++) {
            // Node���� list�� list�� ����
            list.get(road[i][0]).add(new Node(road[i][0], road[i][1], road[i][2]));
            list.get(road[i][1]).add(new Node(road[i][1], road[i][0], road[i][2]));
            // ���ʿ� ��� �� ���� 2�� ���� �־���
        }

        Queue<Node> queue = new LinkedList<>();
        int[] visited = new int[N + 1];
        for (int i = 2; i < visited.length; i++) {
            visited[i] = Integer.MAX_VALUE;
            // �湮 �迭�� ��� max�� ������ �������
        }
        // ó�� ���� ����
        queue.addAll(list.get(1));

        // �ݺ� - DFS
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (visited[n.x] <= visited[n.y] + n.v) {
                // ���⼭ �� y + v�� �ϴ� ����?
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

