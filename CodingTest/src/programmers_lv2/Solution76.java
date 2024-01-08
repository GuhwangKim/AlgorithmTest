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
        // 같은 블럭들이 사라지는 작업
        for (int c = 0; c < n; c++) { // 행
            for (int r = m-1; r >= 0; --r) {
                // 아래 부터 올라옴
                if(map[r][c] == '.'){
                    // 존재하지 않을 때
                    for (int nr = r-1; nr >= 0 ; --nr) {
                        // 위에 있는 값이 내려옴
                        if(map[nr][c] != '.'){
                            // 위에 값이 존재하면 내려옴
                            map[r][c] = map[nr][c];
                            // 위에 값은 공백이 됨
                            map[nr][c] = '.';
                            break;
                        }
                    }
                }
            }

        }
    }

    private int checkBlock(int m, int n, char[][] map) {
        // 몇개가 사라질 까 같은 블록을 확인하는 작업
        int cnt = 0;
        boolean[][] checked = new boolean[][];

        for (int i = 0; i < m-1; ++i) {
            for (int j = 0; j < n-1; ++j) {

            }
        }


        return 0;
    }
}
