package CodingTest.src.programmers_lv2;

import java.util.Arrays;

public class Solution83 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int restApt = 0;
        int infldApt = 0;

        for (int station : stations){
            if(station + w < n || station - w < 0){
                // ���İ� ���������� �� ���� ��
                if(station + w < n){
                    infldApt = (n-station);

                // ���İ� �������� �� ���� ��
                }else{
                    infldApt = station-1;
                }
            } else {
                infldApt += w * 2;
            }
            infldApt++; //���ΰ�
        }

        restApt = n-infldApt;

        if(restApt==0){
            return answer;
        }

        // �̹� ǥ�õ� �κ� ���� �ٸ� �κп� ���� �ְ�, ����ؼ� ���� �Լ��� ����






        return answer;
    }
}
