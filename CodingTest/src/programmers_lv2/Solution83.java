package CodingTest.src.programmers_lv2;

import java.util.Arrays;

public class Solution83 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int restApt = 0;
        int infldApt = 0;

        for (int station : stations){
            if(station + w < n || station - w < 0){
                // 전파가 오른쪽으로 더 많이 감
                if(station + w < n){
                    infldApt = (n-station);

                // 전파가 왼쪽으로 더 많이 감
                }else{
                    infldApt = station-1;
                }
            } else {
                infldApt += w * 2;
            }
            infldApt++; //본인것
        }

        restApt = n-infldApt;

        if(restApt==0){
            return answer;
        }

        // 이미 표시된 부분 말고 다른 부분에 값을 주고, 계속해서 같은 함수를 돌림






        return answer;
    }
}
