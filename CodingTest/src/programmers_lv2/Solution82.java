package CodingTest.src.programmers_lv2;

public class Solution82 {
    public int solution(int n) {
        int ans = 0;
        // 2�� ��� -> �����̵� (������� �� �Ÿ� * 2 �� �̵��ϴ� ������)
        // 1 ��ŭ �̵� -> ans�� ������

        // 1 ��ŭ �ϴ� �̵� -> 2*��� = n �� ���� ������ �̵� ��
        // 1 + 1*2 + 2*2 + 4*2 + 6-2�� 2�� = 4 =
        while(n!=0){
            if(n%2==0){
                // ¦���϶�
                n/=2;
                // ������
            } else{
                n--;
                // �Ѱ��� �ȱ�
                ans++;
            }
        }
        return ans;
    }
}
