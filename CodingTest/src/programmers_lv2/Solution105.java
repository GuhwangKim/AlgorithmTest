package CodingTest.src.programmers_lv2;

public class Solution105 {
    public int solution(int [][]board)
    {
        int answer = 1234;

        // 연결된 1이 가로로 1이 연속된 경우 오른쪽 값을 기억함 , 시작과 끝 기억 (몇개인지)
        // 1 1 , 1 2
        // 따로 메소드
        // 왼쪽+1 ( 몇개 -1)  / 시작과 끝 1이다

        for (int j = 0; j < board.length; j++) {
            // 2차원 배열 1로우씩 뺌
            int startIdx = 0;
            int endIdx = 0;
            for (int i = 0; i < board[j].length; i++) {
                if (board[j][i] == 1 && startIdx == 0) {
                    // 가장 처음
                    startIdx = i;
                }
                if (board[j][i] == 1 && startIdx != 0) {
                    // 그 다음부턴 끝에 값으로
                    endIdx = i;
                }
            }

            // 아래로 더이상 내려갈 수가 없는 경우 (가로>세로)
            int continueOne = endIdx - startIdx;
            if (continueOne > board[0].length - j) {
                continue;
            }else{
                // 확인 메소드 호출
                check(startIdx, endIdx, answer, board, j);
            }
        }
        return answer;
    }

    private void check(int startIdx, int endIdx, int answer, int[][] board, int rowIdx) {

        for (int i = rowIdx + 1; i < board.length; i++) {
            // 세로
            for (int j = startIdx; j <= endIdx; j++) {
                // 가로
                if (board[i][j] != 1) {
                    // 하나라도 1이 아니면 예외 케이스
                    return;
                }
            }
        }
        answer++; // 루프 끝까지 돌았으면 +1
    }
}
