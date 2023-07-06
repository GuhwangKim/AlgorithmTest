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
        // ��ǥ�� �Ѱž� �� ��

        for (int i = 0; i < maps.length; i++) { // ��
            for (int j = 0; j < maps[0].length(); j++) { // ��
                if (!visited[i][j] && maps[0].charAt(j) != 'X') {
                    answer.add(BFS(maps, i, j));
                    // ���� ������ ����� ���� ���� ��ȯ�ϰ� �ؼ� �ٷ� �������
                }
            }
        }


        if (answer.size() == 0) {
            // �ƹ��͵� ���� ���
            answer.add(-1);
        }
        Collections.sort(answer);

        return answer;
    }

    private int BFS(String[] maps, int presentX, int presentY) {

        int linkedTotal = 0;
        Queue<int[]> queue = new LinkedList<>();

        // ���� ��ǥ x y ���� �������
        queue.add(new int[]{presentX, presentY});

        // �湮��
        visited[presentX][presentY] = true;


        // * �������� �ݺ� ?
        while (!queue.isEmpty()) {
            int currentPosition[] = queue.poll();
            // �׶��� ���� ����
            linkedTotal += maps[currentPosition[0]].charAt(currentPosition[1]) - '0';


            // �¿� ����
            for (int i = 0; i < 4; i++) {

                int nextX = currentPosition[0] + dx[i];
                int nextY = currentPosition[1] + dy[i];

                if (nextX >= maps.length || nextX < 0 || nextY >= maps[0].length() || nextY < 0) {
                    continue;
                    // �ش��� �ȵǸ� �Ѿ�� ��
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


