package CodingTest.src.programmers_lv2;

public class Solution15 {

        /**
         * 1. ���ڰ� ���� ��� o�� x ���� 2�� �̻� ������ �ȵ�, x�� o���� 1�� �̻� ������ �ȵ�
         * 2. o�� �¸��ϴ� ��� : o �� x���� 1�� �� ����
         * 3. x�� �¸��ϴ� ��� : x �� ���� = o�� ����
         * 4. o x ��� �¸��ϴ� ��� ���� (������ ���� 3��)
         * */
    public int solution(String[] board) {
        int answer = -1;

        int countO = 0;
        int countX = 0;

        int oWin = 0;
        int xWing = 0;


        // ������ ����
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i].charAt(j)=='O'){
                    countO++;
                }if(board[i].charAt(j)=='X'){
                    countX++;
                }
            }
        }

        // ������ ���� �켱
        if(countO-countX>1 || countX>countO){
            return 0;
        }
        // 0�� �̱�� ���
        if(countO>=3){

        }



        return answer;
    }
}
