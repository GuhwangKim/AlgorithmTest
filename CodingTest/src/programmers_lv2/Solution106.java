package CodingTest.src.programmers_lv2;

public class Solution106 {
    public int solution(String s)
    {
        int answer = 1;

        // �켱 1����, 2���� �϶�, 1���ڴ� ������ 1 / 2���ڴ� ���� �� 2 �ٸ��� 1
        // 3���� �̻���� ����

        // �ִ밪�� ���ϴ� ���̱� ������ �켱 ������ �����
        // �ݿ��� ������ �� ����(1������) ������(���� -1) ���� Ž��
        // Ȧ�� �� �� ���� �򿡼� ����
        // ¦�� �� �� ��� �� -1 ���� ����
        // �հ� ���� ���ڸ� ���� ��, ������ �� ���ϰ� �ٸ��� �������� �� ���� �ε�����

        if (s.length() == 1) {
            return 1;
        } else if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return 2;
            }else{
                return 1;
            }
        }

        // 3�̻�
        int divide = s.length() / 2;

        // ������ ��
        for (int i = divide; i >0 ; i--) {
            int tmp = check(i, s);
            answer = Math.max(answer, tmp);

            // divide ��ġ �ٲ�
        }
        if (answer == s.length()) {
            // ���� �ִ밪
            return answer;
        }
        // �ڷ� ��
        for (int i = divide+1; i < s.length()-1; i++) {
            int tmp = check(i, s);
            answer = Math.max(answer, tmp);
        }
        return answer;
    }

    private int check(int index, String s) {
        int i = 1;
        int answer = 1;
        while (index - i > 0 && index < s.length()) {
            if (s.charAt(index - 1) == s.charAt(index + 1)) {
                answer += 2;
                i++;
            }else{
                break;
            }
        }
        return answer;
    }
}
