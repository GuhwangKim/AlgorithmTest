package CodingTest.src.programmers_lv2;

public class Solution107 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12900
    // 2 x n Ÿ�ϸ�
    public int solution(int n) {
        int answer = 0;
        // ���� �־����� ��, �� ���� 2�� 1�� ��� ������ �� �ֳ��� ����
        // 0�̸� 1
        //¦����
        // 2�� 0�� -> 1
        // 2�� 1��  -> (n-(2*����))=1�ǰ��� * ����  = 2
        // 2�� 2�� -> 1
        // Ȧ�� 5
        // 2�� 0 -> 1
        // 2�� 1 -> 4
        // 2�� 2 -> 2
        int twoCnt = 0;

        while (2 * twoCnt <= n) {
            int tmp = twoCnt * (n-(2*twoCnt));
            if (tmp == 0) {
                answer += 1;
            }else{
                answer += tmp;
            }
            twoCnt++;
        }
        return answer;
    }
}
