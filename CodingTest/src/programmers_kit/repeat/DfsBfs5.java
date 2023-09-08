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
         * ������ ����� �� ���ĺ� �տ� �ִ� ��
            -> �̷� ��츦 ����ؼ� loop�� ������ ó������ �����غ�

         * */
        visited = new boolean[tickets.length];
        DFS(tickets, "ICN", "ICN", totalCnt);
        
        Collections.sort(list);
        String[] arr = list.get(0).split(",");

        return arr;
    }

    private void DFS(String[][] tickets, String formerFlight, String allRoutes, int totalCnt) {
        if(totalCnt == tickets.length){
            // �湮�Ѵ�� �Ѱ��� ��� ������ ������ �� �͵��

            list.add(allRoutes);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            // ���� ó�� ��尡 ������ ���� ���� ������
            if(formerFlight.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                DFS(tickets, tickets[i][1], allRoutes+","+tickets[i][1], totalCnt+1);
                visited[i] = false;
            }
        }

    }
}
