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
        // 벽의 개수 0에서 시작
    }

    private static void dfs(int wallCnt) {
        if (wallCnt == 3) {
            // 3개를 다 소진한 경우, 2를 전파시키고 0의 개수를 찾음
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 이차원 배열로 값 탐색함
                if (map[i][j] == 0) {
                    //0일떄 1로 바꿈
                    dfs(wallCnt + 1);
                    map[i][j] = 1;
                    // 원상 복귀 경우의 모든 수
                }
            }
        }
    }

    private static void bfs() {
        // 현재의 map 상태를 복사해놓을 새로운 배월이 필요함
        copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        Queue<Virus> queue = new LinkedList<>();

        // 2면 상하 좌우를 변경시켜야 함 여기서 bfs - queue를 사용
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
                int nx = v.x + dx[i]; // 다음 x
                int ny = v.y + dy[i]; // 다음 y
                if (0 <= nx && nx < N && ny <= ny && ny < M) {
                    if (copyMap[nx][ny] == 0) {
                        // 바이러스 감염되야함
                        copyMap[nx][ny] = 2;
                        queue.add(new Virus(nx, ny));
                    }
                }
            }
        }
    }
}
