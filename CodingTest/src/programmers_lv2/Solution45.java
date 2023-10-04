package CodingTest.src.programmers_lv2;

public class Solution45 {
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = {};
		/**
		 * 1. 빈 값을 가진 테이블을 만듦 2. 숫자가 바뀔 때
		 */
		// 1) 1~n 까지의 값이 들어간 사각형 테이블
		int[][] square = initsquare(rows, columns);
		return rotateNums(square, queries);
	}

	// 행렬별 숫자를 넣는 메소드
	public int[][] initsquare(int rows, int colums) {
		int[][] square = new int[rows][colums];
		int value = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colums; j++) {
				square[i][j] = value;
				value++;
			}
		}
		return square;
	}

	// 회전을 수행하는 메소드
	public int[] rotateNums(int[][] square, int[][] queries) {
		int[] answer = new int[queries.length];
		int minimalIdx = 0;

		for (int[] query : queries) {
			// 인덱스
			int x1 = query[0] - 1;
			int y1 = query[1] - 1;
			int x2 = query[2] - 1;
			int y2 = query[3] - 1;

			// 기준이 되는 첫번째 숫자를 빼놓고 숫자를 이동시킴
			int firstNum = square[x1][y2];
			int min = firstNum;

			// 1) 숫자를 오른쪽으로 (위쪽)
			for (int i = y2 - 1; i >= y1; i--) {
				// 하나하나씩 매번 최소를 비교함
				min = Math.min(min, square[x1][i]);
				// 이동 , 한 칸 다음의 값이 그 전 값이 됨
				square[x1][i + 1] = square[x1][i];
			}

			// 2) 숫자를 위쪽으로 (왼쪽) 작아짐
			for (int i = x1 + 1; i <= x2; i++) {
				min = Math.min(min, square[i][y1]);
				square[i - 1][y1] = square[i][y1];
			}

			// 3) 숫자를 왼쪽으로 (아래쪽) 작아짐
			for (int i = y1 + 1; i <= y2; i++) {
				min = Math.min(min, square[x2][i]);
				square[x2][i - 1] = square[x2][i];

			}
			// 4) 숫자를 아래로 (오른쪽)
			for (int i = x2 - 1; i >= x1; i--) {
				min = Math.min(min, square[i][y2]);
				square[i + 1][y2] = square[i][y2];
			}

			square[x1 + 1][y2] = firstNum;
			answer[minimalIdx] = min;
			// query 한개를 수행하고 나서 가장 작은 수
			minimalIdx++;

		}
		return answer;
	}
}
