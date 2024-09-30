package CodingTest.src.programmers_lv2;

public class Solution105 {
    public int solution(int [][]board)
    {
        int answer = 1;
        int[][] map = new int[board.length][board[0].length];
        // 하나 더 크게 해서 만듦

        int maxLen = 0;

        for (int i = 1; i <= board.length; i++) {
            for (int j = 1; j <= board[0].length; j++) {
                if (board[i - 1][j - 1] != 0) {
                    int min = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]);
                    // 대각선, 왼, 위 값이 1이면 정사각형
                    map[i][j] = min + 1;
                    // board에 해당하는 현재 위치

                    maxLen = Math.max(maxLen, min + 1);
                }
            }
        }
    return maxLen*maxLen;
    }
}
