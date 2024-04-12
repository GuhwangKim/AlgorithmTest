package CodingTest.src.programmers_lv2;

import java.util.Arrays;

public class Solution83 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 0; // ������ �ε���
        int aptIndx = 1; // �� ����Ʈ

        while (aptIndx <=n) {
            if (index < stations.length && aptIndx >= stations[index] - w) {
                aptIndx = stations[index]+w+1;
                aptIndx++;
            } else{
                answer += 1;
                aptIndx += (w*2)+1;
            }
        }

        return answer;
    }
}
