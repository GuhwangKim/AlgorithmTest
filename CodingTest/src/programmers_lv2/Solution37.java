package CodingTest.src.programmers_lv2;

import java.util.Arrays;

public class Solution37 {
	public int solution(int[][] board, int[][] skill) {
		int answer = 0;
		int row = board.length;
		int column = board[0].length;

		int preSum[][] = new int[row + 1][column + 1];
		// 부분합을 구하는 배열

		for (int[] arr : skill) {

			int type = arr[0];
			int startRow = arr[1];
			int startCol = arr[2];
			int endRow = arr[3];
			int endCol = arr[4];
			int degree = arr[5];

			if (type == 1) {
				// - 하나하나 하다보면 시간
				preSum[startRow][startCol] += -degree;
				preSum[endRow + 1][startCol] += degree;
				preSum[startRow][endCol + 1] += degree;
				preSum[endRow + 1][endCol + 1] += -degree;

			} else {
				// +
				preSum[startRow][startCol] += degree;
				preSum[endRow + 1][startCol] += -degree;
				preSum[startRow][endCol + 1] += -degree;
				preSum[endRow + 1][endCol + 1] += degree;

			}
		}

		for (int i = 0; i < row + 1; i++) {
			int sum = 0;
			for (int j = 0; j < column + 1; j++) {
				sum += preSum[i][j];
				preSum[i][j] = sum;
			}
		}

		for (int i = 0; i < column; i++) {
			int sum = 0;
			for (int j = 0; j < row; j++) {
				sum += preSum[j][i];
				preSum[j][i] = sum;
			}
		}

		for (int i = 0; i < row; i++) {
			int sum = 0;
			for (int j = 0; j < column; j++) {
				if (preSum[i][j] + board[i][j] > 0) {
					answer++;
				}
			}
		}

		return answer;
	}
}
