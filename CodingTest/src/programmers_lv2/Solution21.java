package CodingTest.src.programmers_lv2;

import java.util.Arrays;

public class Solution21 {
    public int solution(int[][] scores) {
        int answer = 0;

        Arrays.sort(scores, (o1, o2) -> o1[0]-o2[0]);
        // 배열 인덱스 0번쨰를 기준으로 정렬

        for (int i = 0; i < scores.length-1; i++) {
            boolean flag = false;
            for (int j = i; j < scores.length; j++) {
                if(scores[i][0]<scores[j][0] && scores[i][1]<scores[j][0]){
                    flag = true;
                }
            }

            if(flag){
                // 조건에 걸림, 0 1 의 위치에 두 곳 모두 큰 값이 존재함
                scores.re

            }
        }
        return answer;
    }
}
