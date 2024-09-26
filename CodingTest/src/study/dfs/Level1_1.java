package CodingTest.src.study.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Level1_1 {

    static int[][] arr;
    static boolean[] visited;
    static boolean[] visited2;
    public String solution(int N, int M, int V, int[][] connected) {
        String answer = "";
        visited = new boolean[N + 1];
        visited2 = new boolean[N + 1];
        // ��������
        arr = new int[N + 1][N + 1];
        for (int i = 0; i < connected.length; i++) {
            for (int j = 0; j < 2; j++) {
                arr[connected[i][0]][connected[i][1]] = 1;
                arr[connected[i][1]][connected[i][0]] = 1;
            }
        }

        dfs(V);

        bfs(V);

        return answer;
    }

    private void bfs(int v) { // Queue
        Queue<Integer> queue = new LinkedList<>();
        // ������ ���ڸ� �������
        if (queue.isEmpty()) {
            queue.add(v);
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if(!visited2[current]){
                // �湮���� �ʾҴٸ�
                for (int i = current; i < arr.length; i++) {
                    if (arr[v][i] == 1) {
                        // ���� ���� ����
                        queue.add(i);
                        bfs(i);
                    }
                }
            }
        }
    }

    private void dfs(int v) { // Stack

        if (!visited[v]) {
            // �湮���� �ʾҴٸ�
            visited[v] = true; // �湮
            for (int i = 1; i < arr.length; i++) {
                // �ش� ���� ���� �Ʒ���
                if (arr[v][i] == 1) {
                    // ����Ǿ��ٸ�
                    dfs(i);
                }
            }
        }
    }

}
