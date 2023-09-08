package CodingTest.src.programmers_kit.repeat;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DfsBfs5 {
    boolean[] visited;
    List<String> list = new LinkedList<>();
    int totalCnt = 0;
    public String[] solution(String[][] tickets) {
        /**
         * 동일한 경로일 때 알파벳 앞에 있는 순
            -> 이런 경우를 대비해서 loop를 돌려서 처음부터 검증해봄

         * */
        visited = new boolean[tickets.length];
        DFS(tickets, "ICN", "ICN", totalCnt);
        
        Collections.sort(list);
        String[] arr = list.get(0).split(",");

        return arr;
    }

    private void DFS(String[][] tickets, String formerFlight, String allRoutes, int totalCnt) {
        if(totalCnt == tickets.length){
            // 방문한대로 한개씩 계쏙 붙혀줌 끝까지 온 것드료

            list.add(allRoutes);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            // 가장 처음 노드가 복수일 때가 방지 가능함
            if(formerFlight.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                DFS(tickets, tickets[i][1], allRoutes+","+tickets[i][1], totalCnt+1);
                visited[i] = false;
            }
        }

    }
}
