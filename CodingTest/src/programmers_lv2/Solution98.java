package CodingTest.src.programmers_lv2;

public class Solution98 {
    int givenNum = 0;
    int answer = 0;
    boolean numberOne = false;
    public int solution(int n) {

        return answer+1;
    }

    private void sum(int i) {
        int total = i;
        int idx = 1;

        while (total + (i-idx) <= givenNum) {
            if (i-idx == 1) {
                // ������ �Դٴ� ��
                numberOne = true;
            }
            // ���� �־��� ���ں��� ���� ������ ����
            total += (i-idx);
            System.out.println("total : "+total);
            if (total == givenNum) {
                // ���ӵ� ���� ���� ����
                answer++;
                return; // ���� ������ �ٽ� ���ư�
            }
            idx++;
        }

    }
}
