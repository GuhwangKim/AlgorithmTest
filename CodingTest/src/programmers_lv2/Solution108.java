package CodingTest.src.programmers_lv2;

public class Solution108 {
    public String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        String answer = "";

        // 3���� �켱 ���� ��
        // �������� �ڿ� �ٿ��ְ� ���ڸ��� ����
        // �������� 0�� ��� 4
        int num = n;
        // ���� �� �ڸ���
        while (num > 0) {
            // ����ؼ� �̾� ����
            int remain = num % 3; // ������
            num /= 3;// ��
            if (remain == 0) {
                num--;
            }
            answer = numbers[remain] + answer;

        }
        return answer;
    }
}
