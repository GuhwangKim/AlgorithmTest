package CodingTest.src.programmers_lv2;

import java.util.Arrays;

public class Solution67 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        /**
         * edge의 안 원소들을 우선 작은 것을 우선으로 배치하고
         * 배열의 0q번쨰 값을 기준으로 정렬함
         * */

        boolean[] visited = new boolean[n+1];
        int currentMax = Integer.MIN_VALUE;

       
        for (int[] each : edge){
            Arrays.sort(each);
            if(each[0] == 1){
                visited[each[1]] = true;
                // 1인 값은 방문으로 표시함
            }
        }
        
        Arrays.sort(edge, (o1, o2) -> o1[0] - o2[0]);
        

        for(int[] each : edge){
            if(each[0] == 1){
                // 1이라는 기준이 되는 값
                // 이와 연결된 값으로 뻗어나가기 시작함

                // 방문함
                int distance = DFS(each[1], edge, 1, visited);
                if (distance>currentMax) {
                    currentMax = distance;
                    answer = 0 ; // 지금까지 다른 거리에서 더해온 값을 초기화
                    answer++; // 최대 값에 맞게 더해버림
                }
            }

        }

        return answer;
    }

    private int DFS(int cntcNum, int[][] edge, int distance, boolean[] visited) {
        visited[cntcNum] = true;
        // 방문함
        for (int[] each : edge){
            if(each[0] == cntcNum || !visited[each[1]]){
                // 연결된 값과 방문하지 않았다면
            	visited[each[1]] = true;
                distance++; // 연결되었으니 1이 추가 됨
                DFS(each[1], edge, distance, visited);
                visited[each[1]] = false; // 풀어줌 
            }
        }

        return distance;
    }
}
