package CodingTest.src.programmers_lv2;

public class Solution27 {
    public long solution(int k, int d) {
        long answer = 0;

        /**
         * 0, 0 ���� ������
         * 1���� ������ �ؼ� �� d���� ������ �ϰ�
         * k ��ŭ ���� ������
         * �׶� x y  ���� ��Ʈ�� ���� ���� d���� ���ų� ������ cnt �߰���
         *
         * */

        for (int i = 0; i <= d; i++) { //x���� ���� 0 1*k 2*k 3*k ....d
            int idxX= i*=k;
            if(idxX>d){
                break;
            }
            // i ���� k�� ����
            for (int j = idxX; j <=d ; j++) { // x���� �� y ��
                int idxY = j*=k;
                // j �� ������
                if(idxY>d){
                    // ���� ���� y ��ǥ �Ѿ�� ��������
                    break;
                }

            }

        }

        return answer;
    }
}
