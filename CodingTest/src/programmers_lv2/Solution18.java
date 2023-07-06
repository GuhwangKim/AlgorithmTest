package CodingTest.src.programmers_lv2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution18 {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    LinkedList<Integer> answer = new LinkedList<>();
    boolean[][] visited;

    public List<Integer> solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        // 좌표를 넘거야 할 듯

        for (int i = 0; i < maps.length; i++) { // 행
            for (int j = 0; j < maps[0].length(); j++) { // 열
                if (!visited[i][j] && maps[0].charAt(j) != 'X') {
                    answer.add(BFS(maps, i, j));
                    // 리턴 값으로 연결된 섬의 값을 반환하게 해서 바로 집어넣음
                }
            }
        }


        if (answer.size() == 0) {
            // 아무것도 없는 경우
            answer.add(-1);
        }
        Collections.sort(answer);

        return answer;
    }

    private int BFS(String[] maps, int presentX, int presentY) {

        int linkedTotal = 0;
        Queue<int[]> queue = new LinkedList<>();

        // 현재 좌표 x y 값을 집어넣음
        queue.add(new int[]{presentX, presentY});

        // 방문함
        visited[presentX][presentY] = true;


        // * 언제까지 반복 ?
        while (!queue.isEmpty()) {
            int currentPosition[] = queue.poll();
            // 그때의 값을 더함
            linkedTotal += maps[currentPosition[0]].charAt(currentPosition[1]) - '0';


            // 좌우 상하
            for (int i = 0; i < 4; i++) {

                int nextX = currentPosition[0] + dx[i];
                int nextY = currentPosition[1] + dy[i];

                if (nextX >= maps.length || nextX < 0 || nextY >= maps[0].length() || nextY < 0) {
                    continue;
                    // 해당이 안되면 넘어가면 됨
                }
                if (!visited[nextX][nextY] && maps[nextX].charAt(nextY) != 'X') {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }

            }

        }

        return linkedTotal;
    }
}


