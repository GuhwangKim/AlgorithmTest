package CodingTest.src.programmers_lv2;

public class Solution62 {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        /**
         * key�� ���� �� - lock�� ���� ���� ��ġ ���� �ʴ´ٸ� => ��
         * lock���� ���� �κп� �־�� ���� �¿� �̵��� �� �� ����
         * lock�� ���� ��δ� 1�̶�� �Ʒ� �̵� ����
         *        ���� ��δ� 1�̶�� ���� ������ �̵� ����
         * key�� ȸ���غ� - �ٽ� lock �� ���غ�
         * */

        int kLength = key.length;
        int lLength = lock.length;

        int extLen = lLength + (kLength)*2 -2;
        int[][] extArr = new int[extLen][extLen]; // Ȯ�� �迭

        // Ȯ�� �迭�� lock ǥ��
        for (int i = kLength-1; i < kLength+lLength-1; i++) {
            for (int j = kLength-1; j < kLength+lLength-1; j++) {
                extArr[i][j] = lock[i-(kLength-1)][i-(kLength-1)];
            }
        }

        // ȸ���ϸ鼭 4�� ��ȸ��
        for (int i = 0; i < 4; i++) {
            if(check(extArr, key, lLength)){
                return true;
            }
            rotate(key);
        }

        return answer;
    }
}
