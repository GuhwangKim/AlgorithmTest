package CodingTest.src.programmers_lv2;

public class Solution76 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        // m n ���� �̷���� ���带 ����
        char[][] map = new char[m][n];
        // �� �ະ�� ���� �ѹ��� �������
        for (int i = 0; i < m; ++i) {
            map[i] = board[i].toCharArray();
        }

        // ���̻� ���� �� ���� �� ����
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
