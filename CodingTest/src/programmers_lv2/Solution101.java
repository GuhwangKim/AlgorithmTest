package CodingTest.src.programmers_lv2;

public class Solution101 {
    int n;
    int[][] directions;
    boolean[][] visited;
    int K2;
    int answer;
    public int solution(int N, int[][] road, int K) {
        answer = 0;
        n = N;
        K2 = K;
        // ���� ��� ������ ���� �� �ִ� �迭 ����
        directions = new int[N+1][N+1];
        visited = new boolean[N + 1][N + 1];
        for (int[] each : road) {
            directions[each[0]][each[1]] = each[2];
            directions[each[1]][each[2]] = each[2];
        }

        for (int i = 1; i <= N ; i++) { // level
            for (int j = i+1; j <= N; j++) { // row
                if (directions[i][j] == 0) {
                    continue; // ���� ������ �ǳʶ��
                }else{
                    visited[i][j] = true;
                    visited[j][i] = true;
                    if (directions[i][j] <= K) {
                        DFS(i, j, directions[i][j]);
                    }
                }
            }
        }


        return answer;
    }

    private void DFS(int row, int col, int total) {
        for (int i = col; i <=n ; i++) {
            for (int j = row; j <=n ; j++) {
                if (!visited[i][j] && directions[i][j] != 0) {
                    // �湮���� �ʾҰ�, ���� �ִ�
                    total += directions[i][j];
                    if (total >= K2) {
                        answer++;
                        return;
                    }else{
                        DFS(i, j, total);
                    }
                }
            }

        }
    }
}
