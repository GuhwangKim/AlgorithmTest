package programmers_lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution21 {

	public static void main(String[] args) {
		int[][] arrarr = { { 2, 2 }, { 1, 4 }, { 3, 2 }, { 3, 2 }, { 2, 1 } };
		Solution21 solution21 = new Solution21();
		solution21.solution(arrarr);
	}

	public int solution(int[][] scores) {
		int answer = 1;
		int[] vararr = scores[0];
		Arrays.sort(scores, (o1, o2) -> o1[0] - o2[0]);

		int var = vararr[0] + vararr[1];

		// 인덱스 1을 비교, 최대값을 담고 비교함
		int peerPoint = 0;

		for (int[] arr : scores) {
			if (arr[1] < peerPoint) {
				// 인덱스 1의 값이 기준 동료 값보다 작은 경우 = 사라짐
				if (vararr[0] == arr[0] && vararr[1] == arr[1]) {
					// 완호의 것과 같다면
					return -1;
				}
			} else {
				peerPoint = Math.max(arr[1], peerPoint);
				// ** 기준이 되는 값 최대 값을 담아줌
				if (var < (arr[0]) + arr[1]) {
					// 나의 값이 기준 값보다 작다면 순위를 올려줘야함 
					answer++;
				}
			}
		}

		return answer;
	}
}
