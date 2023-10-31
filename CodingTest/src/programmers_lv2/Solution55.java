package CodingTest.src.programmers_lv2;

public class Solution55 {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    public int solution(int[][] board) {
        int answer = 0;
        /*
        * 0,0 에서 상하좌우 해봄
        * 쭉 가다가 막힌 곳 있는데, 그 뒤로 상하좌우 가 간다면 코너
        * n , n 까지 갔을 때 직진 코너 값
        * */
        int x = 0, y = 0;
        int direct = 0;
        int corner = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 상하좌우 이동
            if(nx<0 || ny<0 || nx>=board.length || ny>= board.length){
                // 좌표가 가지고 있는 인덱스 밖을 넘어선 경우
            }

        }

        return answer;
    }
}
