package CodingTest.src.programmers_kit.DfsBfs;

public class DfsBfs6 {
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board.length; j++) {
                //1. 게임보드 숫자를 테이블이랑 똑같이 만들어주기
                game_board[i][j] = game_board[i][j]==0?1:0;
            }
        }
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board.length; j++) {
                //1. 게임보드 숫자를 테이블이랑 똑같이 만들어주기
                if(game_board[i][j]==1){
                    String blockString = bfs(game_board, i, j);
                }
            }
        }


        return answer;
    }



    String bfs(int[][] board, int x, int y){
        int dx[] = new int[] {1, -1, 0, 0};
        int dy[] = new int[] {0, 0, 1, -1};

    }
}
