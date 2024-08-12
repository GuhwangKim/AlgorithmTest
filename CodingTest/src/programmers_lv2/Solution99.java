package CodingTest.src.programmers_lv2;

public class Solution99 {
    public int solution(int n, int[][] results) {
        int answer = 0;

        // 모든 사람과의 대항전을 표시할 수 있는 그래프
        int[][] graph = new int[n + 1][n + 1];
        // 배열에 들어간 숫자는 1부터 이므로

        for (int[] edge : results) {
            graph[edge[0]][edge[1]] = 1;
            // 이긴 표시
            graph[edge[1]][edge[0]] = -1;
            // 진 표시
        }

        for (int i = 1; i <= n; i++) {
            // 도착
            for (int j = 1; j <= n; j++) {
                // 거쳐감
                for (int k = 1; k <= n; k++) {
                    // i, j 의 매칭의 결과로 결과가 확정되는 값
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
        // 1부터 마지막 행까지 돌아가면서, n-1 순위가 확정
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
