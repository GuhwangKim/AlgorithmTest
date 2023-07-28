package CodingTest.src.programmers_lv2;

import java.util.Arrays;
import java.util.Comparator;

public class Solution25 {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        /**
         * 1. 2���� �迭�� �ε��� col-1�� �������� ������
         * 2. for ������ �� Ʃ���� ������ row_begin���� ���� ������ �� ���� ����
         * 3. �� �ش��� ����ؼ� ���Ƴ���          *
         * */

        Arrays.sort(data, Comparator.comparingInt(o -> o[col - 1]));
        // 1. ���� col ��° ���� �������� data �迭�� ������

        for(int[] oneRow : data){
            for (int i = 0; i < oneRow.length; i++) {
                for (int j = row_begin; j <= row_end; j++) {
                // 2. ���۰� �������� �� Ʃ���� ������ ����
                    answer+=oneRow[i]%j;

                }
            }
        }



        return answer;
    }
}
