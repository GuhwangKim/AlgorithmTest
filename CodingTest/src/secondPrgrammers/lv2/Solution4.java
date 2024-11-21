package CodingTest.src.secondPrgrammers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {
    /**
     * ������ �κ� https://school.programmers.co.kr/learn/courses/30/lessons/169199
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
                    // ���� ��ġ
                    queue.offer(new int[]{i, j, 0}); // x, y ��ǥ�� ��Ƶ�
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0]; // x
            int y = tmp[1];
            int count = tmp[2];

            // �ݺ��ϴٰ� �����ϸ� ���⼭ �ݳ� (���� ���� �ݳ��Ѵٴ� �� ���� �����ٴ� ��)
            if (board[x].charAt(y) == 'G') {
                answer = count;
                return answer;
            }

            for (int i = 0; i < 4; i++) {
                // �����¿�
                int nx = x;
                int ny = y;

                while (nx >= 0 && nx < board.length
                        && ny >= 0 && ny < board[0].length()
                        && board[nx].charAt(ny) != 'D'
                ) {
                    // ����ؼ� �̵��ϴ� ���
                    nx += dx[i];
                    ny += dy[i];
                }

                // ** ��ֹ� ������ �������� ���� **
                nx -= dx[i];
                ny -= dy[i];

                // ** ��ֹ� ������ �������� �Ű��� �湮�߰ų� �Ǵ� ���� ��ġ��� **
                // �����¿� ���� ������ �̵����ϹǷ�
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
