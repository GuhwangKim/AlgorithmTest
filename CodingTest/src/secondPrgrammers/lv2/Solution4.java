package CodingTest.src.secondPrgrammers.lv2;

public class Solution4 {
    /**
     * 리코쳇 로봇 https://school.programmers.co.kr/learn/courses/30/lessons/169199
     */

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    String[][] boardArr;
    public int solution(String[] board) {
        int answer = -1;
        int temp = Integer.MAX_VALUE;
        int rFirstRowIdx = 0;
        int rFristColIdx = 0;

        boardArr = new String[board.length][board[0].length()];

        // 2차원 배열에 담기
        for (int i = 0; i < board.length; i++) {
            String boardStr = board[i];
            for (int j = 0; j < boardStr.length(); j++) {
                // R의 위치
                if (String.valueOf(boardStr.charAt(j)) == "R") {
                    rFirstRowIdx = i;
                    rFristColIdx = j;
                }
                boardArr[i][j] = String.valueOf(boardStr.charAt(j));
            }
        }

        // R의 시점에서 시작함
        // 상하좌우
        int currentCnt = dfs(rFirstRowIdx, rFristColIdx);


        return answer;
    }

    private int dfs(int currentRowIdx, int currentColIdx) {
        int currentCnt = 0;

        for (int i = 0; i < 4; i++) {
            int nextRowIdx = currentRowIdx + dx[i];
            int nextColIdx = currentColIdx + dy[i];
            while(nextRowIdx>=0 && nextRowIdx<boardArr.length
                    && nextColIdx>=0 && nextColIdx<boardArr[0].length
                    && boardArr[nextRowIdx][nextColIdx] == "."){
                // 같은 방향일 떄
                nextRowIdx += dx[i];
                nextRowIdx += dy[i];
            }
            // 다른 방향일 때 차수 증가
           currentCnt ++;

        }

    }
}
