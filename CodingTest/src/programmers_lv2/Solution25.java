package CodingTest.src.programmers_lv2;

import java.util.Arrays;
import java.util.Comparator;

public class Solution25 {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        /**
         * 1. 2차원 배열을 인덱스 col-1을 기준으로 정렬함
         * 2. for 문으로 각 튜플의 값들을 row_begin에서 부터 나누고 그 값을 더함
         * 3. 그 해답을 계속해서 더아나감          *
         * */

        Arrays.sort(data, Comparator.comparingInt(o -> o[col - 1]));
        // 1. 행의 col 번째 수를 기준으로 data 배열을 정리함

        for(int[] oneRow : data){
            for (int i = 0; i < oneRow.length; i++) {
                for (int j = row_begin; j <= row_end; j++) {
                // 2. 시작과 끝값으로 각 튜플의 값들을 나눔
                    answer+=oneRow[i]%j;

                }
            }
        }



        return answer;
    }
}
