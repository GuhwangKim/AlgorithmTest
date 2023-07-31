package CodingTest.src.programmers_lv2;

public class Solution26 {
    /**
     * n <enemy[i] �� �� i �ܰ���� ������
     * k ��ŭ�� ������
     * ������ ���� ��� ������ �������� �ߟG��
     *
     * 1) enemy�� ���� <= k ��� enemy�� ���̸� ����
     * 2) n <enemy[i] �� �� i �ܰ���� ������
     * 3) �׷��� �ʴٸ�
     *      - n-=enemy[i]
     *
     *      - K>0 ��� k-1 ���� i �Ѵܰ� ������
     * */


    int answer = 0;
    public int solution(int n, int k, int[] enemy) {
        int sum = 0;
        for(int num : enemy){
            sum+=num;
        }
        if(k>= enemy.length || n>=sum){
            // 1. ������ > �� / ����� > ���� ��
            return enemy.length;
        }
        BFS(n,k, enemy, 0);

        return answer+1;
    }

    private void BFS(int n, int k, int[] enemy, int level) {

        for (int i = level; i < enemy.length; i++) {
            if(k>0){
                // �ѹ� �ǳ� �ٴ� ���
               BFS(n, k-1, enemy, level+1);
            } else if (n-enemy[i]>0) {
                // �� ���� ���
                BFS(n-enemy[i], k, enemy, level+1);
            }
            answer = Math.max(answer, level);
            // ������ ��������
            break;

        }

    }

}
