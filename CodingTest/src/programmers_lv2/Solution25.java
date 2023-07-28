package programmers_lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution25 {
	public int solution(int[][] data, int col, int row_begin, int row_end) {
		int answer = 0;
		List<Integer> list = new LinkedList<Integer>();
		
		/**
		 * 1. 2차원 배열을 인덱스 col-1을 기준으로 정렬함 2. for 문으로 각 튜플의 값들을 row_begin에서 부터 나누고 그 값을
		 * 더함 3. 그 해답을 계속해서 더아나감 *
		 */

		Arrays.sort(data, (o1, o2) -> {
			// 1. col의 값을 중심으로 배열을 정렬한 후 
			if(o1[col-1]==o2[col-1]) {
				return o2[0]-o1[0];
			}else {
				 return o1[col-1]-o2[col-1];
			}
		});

		for (int j = row_begin; j <= row_end; j++) {
			// 2. j번째 배열을 뽑아,  시작과 끝값으로 각 튜플의 값들을 나눔
			int[] arr = data[j-1];
			int result = 0;
			for(int num : arr) {
				result+=num%j;
			}
			list.add(result);
			// 3. 그 값을 list에 담고 비트 연산 
		}
		
		for(int listNum : list){
			answer ^= listNum;
		}
		

		return answer;
	}
}
