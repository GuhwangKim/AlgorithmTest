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

                }
            }
        }

        return answer;
    }
}
