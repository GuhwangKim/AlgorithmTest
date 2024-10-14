package CodingTest.src.programmers_lv2;

public class Solution106 {
    public int solution(String s)
    {
        int answer = 1;
        int n = s.length();
        loop:
        for (int i = n; i >= 1; i--) {
            // ���� �� ���̺���
            for (int j = 0; j <= n - 1; j++) {
                // ���� ���� ����
                boolean flag = true;
                int start = j; // ���� �ε���
                int end = j+i-1; // �� �ε���

                while (start < end) {
                    if (s.charAt(start) != s.charAt(end)) {
                        // ���� ������ �ݺ�
                        flag = false;
                        break; // while�� ��������
                    }
                    start++;
                    end--;
                }
                if (flag) {
                    answer = i;
                    break loop;
                }
            }
        }


        return answer;
    }
}
