package CodingTest.src.programmers_lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution67 {
    static ArrayList<Integer>[]list;
    static boolean visited[];   // 양방향그래프이니 큐에서 무한 반복을 방지하기 위해
    static Queue<Integer> queue = new LinkedList<>();
    static int arr[];

    public int solution(int n, int[][] edge) {
        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        arr = new int[n+1];

        // 각 노드 값 마다 연결된 노드(Integer)들을 담는 List를 생성함
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int front = edge[i][0];
            int back = edge[i][1];
            list[front].add(back);
            list[back].add(front);
            // 노드의 앞과 뒤에 서로의 값을 담음 (연결관계)
        }

        queue.add(1);
        // 1에서 시작함
        visited[1] = true;
        // 1은 지나침

        while (!queue.isEmpty()){
            int nodeVal = queue.poll();
            for (int child : list[nodeVal]){
                // 해당하는 노드 값에 연결된 정수들
                if(visited[child]){
                    continue; // 이미 방문했다면 아웃
                }
                queue.add(child);
                // 방문 안했으면 queue에 추가함
                visited[child] = true;
                // 방문표시
                arr[child] = arr[nodeVal]+1;
                // 해당 노드를 인덱스로 갖는 값에 부모의 노드의 값까지 포함해서 더해줌 **
            }
        }

        Arrays.sort(arr);
        // 그렇게 해서 더한 배열을 정렬함
        int cnt = 0;
        int max = arr[n];
        for (int i = n; i >= 1; i--) {
            // 거꾸로 내려옴 (가장 큰 것부터)
            if(max == arr[i]){
                // 가장 큰 값과 같은 값이 있으면
                cnt++;
            }else{
                break;
            }
        }
        
        return cnt;
    }

    private int DFS(int cntcNum, int[][] edge, int distance, boolean[] visited) {
        visited[cntcNum] = true;
        // 방문함
        for (int[] each : edge){
            if(each[0] == cntcNum || !visited[each[1]]){
                // 연결된 값과 방문하지 않았다면
                distance++; // 연결되었으니 1이 추가 됨
                DFS(each[1], edge, distance, visited);
                visited[each[1]] = false; // 풀어줌 
            }
        }

        return distance;
    }
}
