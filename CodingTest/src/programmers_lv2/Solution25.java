package programmers_lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution25 {
	public int solution(int[][] data, int col, int row_begin, int row_end) {
		int answer = 0;
		List<Integer> list = new LinkedList<Integer>();
		
		/**
		 * 1. 2���� �迭�� �ε��� col-1�� �������� ������ 2. for ������ �� Ʃ���� ������ row_begin���� ���� ������ �� ����
		 * ���� 3. �� �ش��� ����ؼ� ���Ƴ��� *
		 */

		Arrays.sort(data, (o1, o2) -> {
			// 1. col�� ���� �߽����� �迭�� ������ �� 
			if(o1[col-1]==o2[col-1]) {
				return o2[0]-o1[0];
			}else {
				 return o1[col-1]-o2[col-1];
			}
		});

		for (int j = row_begin; j <= row_end; j++) {
			// 2. j��° �迭�� �̾�,  ���۰� �������� �� Ʃ���� ������ ����
			int[] arr = data[j-1];
			int result = 0;
			for(int num : arr) {
				result+=num%j;
			}
			list.add(result);
			// 3. �� ���� list�� ��� ��Ʈ ���� 
		}
		
		for(int listNum : list){
			answer ^= listNum;
		}
		

		return answer;
	}
}
