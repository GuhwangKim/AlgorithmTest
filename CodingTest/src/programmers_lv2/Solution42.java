package CodingTest.src.programmers_lv2;

public class Solution42 {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] visited;
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        visited = new boolean[5][5];

        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places.length; j++) {
                int curX = i;
                int curY = j;

                for (int k = 0; k < 4; k++) {
                    int nextX = curX + dx[k];
                    int nextY = curY + dy[k];
                    if(nextX<5 || nextX>=0 || nextY<5 || nextY>=0 || !visited[nextX][nextX]){
                        // 이동할 수 있고 방문도 안한 경우

                    }
                }
            }
        }


        return answer;
    }
}
