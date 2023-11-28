package CodingTest.src.programmers_lv2;

import java.util.Arrays;

public class Solution67 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        /**
         * edge�� �� ���ҵ��� �켱 ���� ���� �켱���� ��ġ�ϰ�
         * �迭�� 0q���� ���� �������� ������
         * */

        boolean[] visited = new boolean[n+1];
        int currentMax = Integer.MIN_VALUE;

       
        for (int[] each : edge){
            Arrays.sort(each);
            if(each[0] == 1){
                visited[each[1]] = true;
                // 1�� ���� �湮���� ǥ����
            }
        }
        
        Arrays.sort(edge, (o1, o2) -> o1[0] - o2[0]);
        

        for(int[] each : edge){
            if(each[0] == 1){
                // 1�̶�� ������ �Ǵ� ��
                // �̿� ����� ������ ������� ������

                // �湮��
                int distance = DFS(each[1], edge, 1, visited);
                if (distance>currentMax) {
                    currentMax = distance;
                    answer = 0 ; // ���ݱ��� �ٸ� �Ÿ����� ���ؿ� ���� �ʱ�ȭ
                    answer++; // �ִ� ���� �°� ���ع���
                }
            }

        }

        return answer;
    }

    private int DFS(int cntcNum, int[][] edge, int distance, boolean[] visited) {
        visited[cntcNum] = true;
        // �湮��
        for (int[] each : edge){
            if(each[0] == cntcNum || !visited[each[1]]){
                // ����� ���� �湮���� �ʾҴٸ�
            	visited[each[1]] = true;
                distance++; // ����Ǿ����� 1�� �߰� ��
                DFS(each[1], edge, distance, visited);
                visited[each[1]] = false; // Ǯ���� 
            }
        }

        return distance;
    }
}
