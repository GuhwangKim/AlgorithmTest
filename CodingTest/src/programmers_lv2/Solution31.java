package CodingTest.src.programmers_lv2;

import java.util.ArrayList;
import java.util.List;

public class Solution31 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[n+1][n+1];

        for (int i = 0; i < roads.length; i++) {
            int[] arr = roads[i];
            visited[arr[0]][arr[1]]=true;
            // road�� �ִ� ��� üũ
            visited[arr[1]][arr[0]]=true;
            // �ݴ��� ��쵵 üũ
        }

        for(int position : sources){
            if(position==destination){
                // ���� ��ġ�� destination�� ���� ���
                list.add(0);
                continue;
            }
            for (int i = 1; i <= n ; i++) {
                if(visited[position][i]){
                    // ����� ���
                }
            }

        }


        return answer;
    }
}
