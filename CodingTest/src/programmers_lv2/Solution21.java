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

		// �ε��� 1�� ��, �ִ밪�� ��� ����
		int peerPoint = 0;

		for (int[] arr : scores) {
			if (arr[1] < peerPoint) {
				// �ε��� 1�� ���� ���� ���� ������ ���� ��� = �����
				if (vararr[0] == arr[0] && vararr[1] == arr[1]) {
					// ��ȣ�� �Ͱ� ���ٸ�
					return -1;
				}
			} else {
				peerPoint = Math.max(arr[1], peerPoint);
				// ** ������ �Ǵ� �� �ִ� ���� �����
				if (var < (arr[0]) + arr[1]) {
					// ���� ���� ���� ������ �۴ٸ� ������ �÷������ 
					answer++;
				}
			}
		}

		return answer;
	}
}
