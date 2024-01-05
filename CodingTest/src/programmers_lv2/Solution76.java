package CodingTest.src.programmers_lv2;

public class Solution76 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        // m n 으로 이루어진 보드를 만듦
        char[][] map = new char[m][n];
        // 각 행별로 값을 한번에 집어넣음
        for (int i = 0; i < m; ++i) {
            map[i] = board[i].toCharArray();
        }

        // 더이상 없앨 게 없을 때 끝냄
        while(true){
            int cnt = checkBlock(m,n,map);
            if(cnt==0){
                break;
            }
            answer+=cnt;
            dropBlock(m,n,map);
        }

        return answer;
    }

    private void dropBlock(int m, int n, char[][] map) {
    }

    private int checkBlock(int m, int n, char[][] map) {


        return 0;
    }
}
