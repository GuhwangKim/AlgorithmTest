package CodingTest.src.programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution69 {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] visited;
    Queue<int[]> queue = new LinkedList<>();
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        visited = new boolean[m][n];
        for(int[] puddle : puddles){
            visited[puddle[0]][puddle[1]] = true; // �� ���� ��
        }

        // ���� ��ġ 1, 1  0,0 ���� ��ġ m-1 n-1 �ε�����
        visited[0][0] = true;
        int[] cur
        queue.add();





        return answer;
    }
}
