package CodingTest.src.programmers_lv2;

public class Solution101 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        // ���� ��� ������ ���� �� �ִ� �迭 ����
        int[][] directions = new int[N+1][N+1];
        for (int[] each : road) {
            directions[each[0]][each[1]] = each[2];
            directions[each[1]][each[2]] = each[2];
        }

        for (int i = 1; i <= N ; i++) { // level
            for (int j = 1; j <= N; j++) { // row
                if (directions[i][j] == 0) {
                    continue; // ���� ������ �ǳʶ��
                }else{
                    DFS(i, j, directions[i][j]);
                }
            }
        }


        return answer;
    }

    private void DFS(int row, int col, int total) {

    }
}
