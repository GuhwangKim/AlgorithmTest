package CodingTest.src.programmers_lv2;

import java.util.*;

public class Solution48 {

    int Node;
    int Cnnct;
    int[][] matrix;

    public int solution(int n, int s, int a, int b, int[][] fares) {
       int answer = 0;
       Node = n;
       Cnnct = fares.length;

        for (int i = 0; i < Cnnct; i++) {
            int frontIdx = fares[i][0]-1;
            int backIdx = fares[i][1]-1;
            int cost = fares[i][2];
            // �� ����� ��� cost�� �����
            matrix[frontIdx][backIdx] = cost;
            matrix[backIdx][frontIdx] = cost;
        }

        // ����� ������ cost ����
        // ���� �ε����� ��������
        int[] together = dijkstra(s-1);
        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < Node; i++) {
            int[] alone = dijkstra(i);
            int cost = together[i] + alone[a -1] + alone[b-1];
            if(cost<minCost){
                minCost = cost;
            }
        }
        return minCost;
    }

    public int[] dijkstra(int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a ->a[0]));
        // 0��° �ε����� ���� �������� ������ ����

        // �� ��� ��ŭ �湮�ߴ���,
        // �� ��庰 ���̸� �����ϴ� �迭
        boolean[] visited = new boolean[Node];
        int[] distance = new int[Node];

        Arrays.fill(distance, Integer.MAX_VALUE);
        // �Ÿ��� �ִ� ���� �Է���

        distance[start] = 0;
        // ���� ���� �Ÿ��� 0���� ���� ����

        queue.add(new int[]{0, start});
        // �Ÿ��� ����, �������� ���� �迭�� �������

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int point = current[1];
            // ���� ����Ʈ

            if(visited[point]){
                continue;
                // ����ߴٸ� �ǳʶ�
            }

            visited[point] = true;
            // �湮ǥ��

            for (int i = 0; i < Node; i++) {
                // �� ��� ��ŭ �ݺ�����

                // �������������� �� ������ cost���� �ľ���
                if(matrix[point][i] == 0){
                    continue; // �ƹ��͵� ������ �ǳʶ�
                }
                if(distance[point] + matrix[point][i] < distance[i]){
                    // �������� �� + �������� ����� ����� �� < ������
                    distance[i] = distance[point] + matrix[point][i];
                    // �ش� ��ġ�� �� = �� ��������Ʈ�� �� + ����� ��
                    queue.add(new int[] {distance[i], i});
                }
            }
        }

    return distance;
    }
}
