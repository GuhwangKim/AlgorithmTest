package CodingTest.src.programmers_lv2;

public class Solution55 {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    public int solution(int[][] board) {
        int answer = 0;
        /*
        * 0,0 ���� �����¿� �غ�
        * �� ���ٰ� ���� �� �ִµ�, �� �ڷ� �����¿� �� ���ٸ� �ڳ�
        * n , n ���� ���� �� ���� �ڳ� ��
        * */
        int x = 0, y = 0;
        int direct = 0;
        int corner = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // �����¿� �̵�
            if(nx<0 || ny<0 || nx>=board.length || ny>= board.length){
                // ��ǥ�� ������ �ִ� �ε��� ���� �Ѿ ���
            }

        }

        return answer;
    }
}
