package CodingTest.src.programmers_lv2;

public class Solution19 {
    int answer = 0;
    public int solution(int x, int y, int n) {
        /**
         * 1. x�� n�� ���ϴ� ���
         * 2. x�� 2�Ǵ� 3�� ���ϴ� ���
         * */
        DFS(x, y, n, x, 0);


        return answer;
    }

    private void DFS(int x, int y, int n, int presentNum, int cnt) {

        if(x==n){
            answer = Math.min(answer, cnt);
            return;
            // ���ٸ� �ٷ�
        }
        // �׳� ������ �����ϴٺ��� ���� ����
        if(x<y){
            DFS(x, y, n, presentNum*3, cnt+1);
            DFS(x, y, n, presentNum*2, cnt+1);
            DFS(x, y, n, presentNum+n, cnt+1);
            // �̷��� �Ǹ� ���̴� ��츦 �ݿ��� �� ����


        }



    }
}
