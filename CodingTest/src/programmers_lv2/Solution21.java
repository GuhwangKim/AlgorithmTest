package CodingTest.src.programmers_lv2;

import java.util.Arrays;

public class Solution21 {
    public int solution(int[][] scores) {
        int answer = 0;

        Arrays.sort(scores, (o1, o2) -> o1[0]-o2[0]);
        // �迭 �ε��� 0������ �������� ����

        for (int i = 0; i < scores.length-1; i++) {
            boolean flag = false;
            for (int j = i; j < scores.length; j++) {
                if(scores[i][0]<scores[j][0] && scores[i][1]<scores[j][0]){
                    flag = true;
                }
            }

            if(flag){
                // ���ǿ� �ɸ�, 0 1 �� ��ġ�� �� �� ��� ū ���� ������
                scores.re

            }
        }
        return answer;
    }
}
