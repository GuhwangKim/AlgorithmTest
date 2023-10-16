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
            // 각 연결된 노드 cost를 담아줌
            matrix[frontIdx][backIdx] = cost;
            matrix[backIdx][frontIdx] = cost;
        }

        // 연결된 노드들의 cost 총합
        // 시작 인덱스를 기준으로
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
        // 0번째 인덱스의 값을 기준으로 오름차 정렬

        // 총 노드 만큼 방문했는지,
        // 각 노드별 길이를 저장하는 배열
        boolean[] visited = new boolean[Node];
        int[] distance = new int[Node];

        Arrays.fill(distance, Integer.MAX_VALUE);
        // 거리의 최대 값을 입력함

        distance[start] = 0;
        // 시작 점의 거리를 0으로 놓고 시작

        queue.add(new int[]{0, start});
        // 거리의 값과, 시작점을 담은 배열을 집어넣음

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int point = current[1];
            // 시작 포인트

            if(visited[point]){
                continue;
                // 방분했다면 건너띔
            }

            visited[point] = true;
            // 방문표시

            for (int i = 0; i < Node; i++) {
                // 총 노드 만큼 반복해줌

                // 시작점에서부터 총 노드까지 cost값을 파악함
                if(matrix[point][i] == 0){
                    continue; // 아무것도 없으면 건너띔
                }
                if(distance[point] + matrix[point][i] < distance[i]){
                    // 시작점의 값 + 시작점과 연결된 노드의 값 < 시작점
                    distance[i] = distance[point] + matrix[point][i];
                    // 해당 위치의 값 = 그 시작포인트의 값 + 연결된 값
                    queue.add(new int[] {distance[i], i});
                }
            }
        }

    return distance;
    }
}
