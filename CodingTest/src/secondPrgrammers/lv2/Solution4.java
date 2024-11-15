package CodingTest.src.secondPrgrammers.lv2;

public class Solution4 {
    /**
     * ������ �κ� https://school.programmers.co.kr/learn/courses/30/lessons/169199
     */
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    String[][] boardArr;
    int temp = Integer.MAX_VALUE;
    public int solution(String[] board) {
        int answer = -1;
        int rFirstRowIdx = 0;
        int rFristColIdx = 0;

        boardArr = new String[board.length][board[0].length()];

        // 2���� �迭�� ���
        for (int i = 0; i < board.length; i++) {
            String boardStr = board[i];
            for (int j = 0; j < boardStr.length(); j++) {
                // R�� ��ġ
                if (String.valueOf(boardStr.charAt(j)) == "R") {
                    rFirstRowIdx = i;
                    rFristColIdx = j;
                }
                boardArr[i][j] = String.valueOf(boardStr.charAt(j));
            }
        }

        // R�� �������� ������
        // �����¿�
        dfs(rFirstRowIdx, rFristColIdx, 0);

        if (temp != Integer.MAX_VALUE) {
            return temp;
        }
        return -1;
    }

    private void dfs(int currentRowIdx, int currentColIdx, int count) {

        for (int i = 0; i < 4; i++) {
            int nextRowIdx = currentRowIdx + dx[i];
            int nextColIdx = currentColIdx + dy[i];
            if (boardArr[nextRowIdx][nextColIdx].equals("G")) {
                // ��ǥ ����
                return;
            }
            while(nextRowIdx>=0 && nextRowIdx<boardArr.length
                    && nextColIdx>=0 && nextColIdx<boardArr[0].length
                    && boardArr[nextRowIdx][nextColIdx] == "."){
                // ���� ������ ��
                nextRowIdx += dx[i];
                nextRowIdx += dy[i];
            }
            // �ٸ� ������ �� ���� ����
            count ++;
            dfs(nextRowIdx, nextColIdx, count);
            // �� ���� ������ ���� ��
            temp = Math.min(temp, count);
        }
    }
}
