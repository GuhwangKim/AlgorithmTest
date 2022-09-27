package programmers_lv1;

import java.util.Arrays;

public class Solution7 {
	public int solution(int[] numbers) {
		int result = 45;
		int sum = 0;

		
		
		
		for (int n : numbers) {
			sum += n;
		}

		result = result - sum;

		return result;
	}

	private static boolean contains(final int[] arr, final int key) {
		return Arrays.stream(arr).anyMatch(i -> i == key);
	}

}
