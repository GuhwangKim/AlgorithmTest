package CodingTest.src.programmers_lv2;

public class Solution105 {
    public int solution(int [][]board)
    {
        int answer = 1234;

        // ����� 1�� ���η� 1�� ���ӵ� ��� ������ ���� ����� , ���۰� �� ��� (�����)
        // 1 1 , 1 2
        // ���� �޼ҵ�
        // ����+1 ( � -1)  / ���۰� �� 1�̴�

        for (int j = 0; j < board.length; j++) {
            // 2���� �迭 1�ο쾿 ��
            int startIdx = 0;
            int endIdx = 0;
            for (int i = 0; i < board[j].length; i++) {
                if (board[j][i] == 1 && startIdx == 0) {
                    // ���� ó��
                    startIdx = i;
                }
                if (board[j][i] == 1 && startIdx != 0) {
                    // �� �������� ���� ������
                    endIdx = i;
                }
            }

            // �Ʒ��� ���̻� ������ ���� ���� ��� (����>����)
            int continueOne = endIdx - startIdx;
            if (continueOne > board[0].length - j) {
                continue;
            }else{
                // Ȯ�� �޼ҵ� ȣ��
                check(startIdx, endIdx, answer, board, j);
            }
        }
        return answer;
    }

    private void check(int startIdx, int endIdx, int answer, int[][] board, int rowIdx) {

        for (int i = rowIdx + 1; i < board.length; i++) {
            // ����
            for (int j = startIdx; j <= endIdx; j++) {
                // ����
                if (board[i][j] != 1) {
                    // �ϳ��� 1�� �ƴϸ� ���� ���̽�
                    return;
                }
            }
        }
        answer++; // ���� ������ �������� +1
    }
}
