package CodingTest.src.programmers_lv2;

public class Solution99 {
    public int solution(int n, int[][] results) {
        int answer = 0;

        // ��� ������� �������� ǥ���� �� �ִ� �׷���
        int[][] graph = new int[n + 1][n + 1];
        // �迭�� �� ���ڴ� 1���� �̹Ƿ�

        for (int[] edge : results) {
            graph[edge[0]][edge[1]] = 1;
            // �̱� ǥ��
            graph[edge[1]][edge[0]] = -1;
            // �� ǥ��
        }

        for (int i = 1; i <= n; i++) {
            // ����
            for (int j = 1; j <= n; j++) {
                // ���İ�
                for (int k = 1; k <= n; k++) {
                    // i, j �� ��Ī�� ����� ����� Ȯ���Ǵ� ��
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                    if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }

                }
            }
        }
        // 1���� ������ ����� ���ư��鼭, n-1 ������ Ȯ��
        for (int i = 0; i <= n ; i++) {
            int cnt = 0;
            for (int j = 0; j <= n; j++) {
                if (graph[i][j] != 0) {
                    cnt++;
                }
            }
            if (cnt == n - 1) {
                answer++;
            }
        }
        return answer;
    }
}
