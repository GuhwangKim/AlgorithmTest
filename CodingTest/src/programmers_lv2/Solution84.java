package CodingTest.src.programmers_lv2;

/**
 * dijkstra
 * */
public class Solution84 {
    static final int INF = 500001;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N + 1][N + 1];

        // ���Ѵ�� �ʱ�ȭ
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                map[i][j] = INF;
            }
        }

        // ���� ���� ����
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int w = road[i][2];


        }

        return answer;
    }
}
