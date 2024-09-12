package CodingTest.src.study.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Level2_1 {
    public static int N;
    public static int M;
    public static int[][] map;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int[][] copyMap;

    static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        // ���� ���� 0���� ����
    }

    private static void dfs(int wallCnt) {
        if (wallCnt == 3) {
            // 3���� �� ������ ���, 2�� ���Ľ�Ű�� 0�� ������ ã��
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // ������ �迭�� �� Ž����
                if (map[i][j] == 0) {
                    //0�ϋ� 1�� �ٲ�
                    dfs(wallCnt + 1);
                    map[i][j] = 1;
                    // ���� ���� ����� ��� ��
                }
            }
        }
    }

    private static void bfs() {
        // ������ map ���¸� �����س��� ���ο� ����� �ʿ���
        copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        Queue<Virus> queue = new LinkedList<>();

        // 2�� ���� �¿츦 ������Ѿ� �� ���⼭ bfs - queue�� ���
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    queue.add(new Virus(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Virus v = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = v.x + dx[i]; // ���� x
                int ny = v.y + dy[i]; // ���� y
                if (0 <= nx && nx < N && ny <= ny && ny < M) {
                    if (copyMap[nx][ny] == 0) {
                        // ���̷��� �����Ǿ���
                        copyMap[nx][ny] = 2;
                        queue.add(new Virus(nx, ny));
                    }
                }
            }
        }
    }
}
