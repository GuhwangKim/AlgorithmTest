package CodingTest.src.programmers_lv2;

public class Solution53 {
    public int solution(int[] a) {
        int answer = 0;
        /**
         * ó������ ������ �ϳ��� ���ֺ�
         * 1.a�� ����� 2
         *  1) small = 1 answer+2 (������/ū�� ����)
         *  2) small = 0 answer+1 (ū�� ����)
         *2. ó������ 2���� �����غ�
         * ������
         * ū��
         * ������ ������ ����ؼ� �����غ�
         *
         * */
        String wholeNums = "";
        for(int num : a){
            wholeNums += String.valueOf(num);
        }

        int small = 1;
        // �ϳ� �־���
        StringBuilder str = new StringBuilder();
        // ���ϴ� �� �����ϰڴµ�, �� ���Ŀ� ����� �ٽ� ��ġ�� ���� ���?

        for (int i = 0; i < wholeNums.length()-1; i++) {
            // ���� ������ �� �տ� �ε��� ������ �ؼ� 2���� ���� ������
            str.append(wholeNums.substring(0, i));
            // �տ� �κ� ��ġ��


            if(a[i]>a[i+1]){
            // ���� �� ���ִ� ���


            }

            str.append(wholeNums.substring())
            // �ڿ� �κ� ��ġ��


        }

        return answer;
    }
}
