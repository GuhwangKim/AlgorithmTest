package CodingTest.src.programmers_lv2;

public class Solution65 {
    public int solution(String dirs) {
        int answer = 0;

        /**
         * �湮�� �߳� ���߳� �÷��� ó���� �ؾ���
         * ���� ��ǥ�� ���� �Ǹ� ���� ����
         *  */

        boolean[][] visited = new boolean[10][10];

        int curXidx = 0;
        int curYidx = 0;

        for (int i = 0; i < dirs.length(); i++) {
            char currAlpha = dirs.charAt(i);
            if(currAlpha =='U'){
                // ��
                int nextXidx = curXidx;
                int nextYidx = curYidx + 1;

                if(nextXidx)

            } else if (currAlpha == 'D') {
                // �Ʒ�

            } else if (currAlpha == 'L') {
                // ����

            } else{
                // ������
            }
        }

        return answer;
    }
}
