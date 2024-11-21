package CodingTest.src.secondPrgrammers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {
    /**
     * 리코쳇 로봇 https://school.programmers.co.kr/learn/courses/30/lessons/169199
     */

    public int solution(String[] board) {
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[board.length][board[0].length()];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    // 시작 위치
                    queue.offer(new int[]{i, j, 0}); // x, y 좌표를 담아둠
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0]; // x
            int y = tmp[1];
            int count = tmp[2];

            // 반복하다가 만족하면 여기서 반납 (제일 먼저 반납한다는 건 제일 빠르다는 뜻)
            if (board[x].charAt(y) == 'G') {
                answer = count;
                return answer;
            }

            for (int i = 0; i < 4; i++) {
                // 상하좌우
                int nx = x;
                int ny = y;

                while (nx >= 0 && nx < board.length
                        && ny >= 0 && ny < board[0].length()
                        && board[nx].charAt(ny) != 'D'
                ) {
                    // 계속해서 이동하는 경우
                    nx += dx[i];
                    ny += dy[i];
                }

                // ** 장애물 만나면 직전으로 수정 **
                nx -= dx[i];
                ny -= dy[i];

                // ** 장애물 만나기 직전으로 옮겨짐 방문했거나 또는 같은 위치라면 **
                // 상하좌우 기존 값에서 이동해하므로
                if (visited[nx][ny] || (x == nx && y == ny)) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, count + 1});
            }
        }
        answer = -1;
        return answer;
    }

}
