package CodingTest.src.programmers_lv2;

public class Solution45 {
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = {};
		/**
		 * 1. �� ���� ���� ���̺��� ���� 2. ���ڰ� �ٲ� ��
		 */
		// 1) 1~n ������ ���� �� �簢�� ���̺�
		int[][] square = initsquare(rows, columns);
		return rotateNums(square, queries);
	}

	// ��ĺ� ���ڸ� �ִ� �޼ҵ�
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

	// ȸ���� �����ϴ� �޼ҵ�
	public int[] rotateNums(int[][] square, int[][] queries) {
		int[] answer = new int[queries.length];
		int minimalIdx = 0;

		for (int[] query : queries) {
			// �ε���
			int x1 = query[0] - 1;
			int y1 = query[1] - 1;
			int x2 = query[2] - 1;
			int y2 = query[3] - 1;

			// ������ �Ǵ� ù��° ���ڸ� ������ ���ڸ� �̵���Ŵ
			int firstNum = square[x1][y2];
			int min = firstNum;

			// 1) ���ڸ� ���������� (����)
			for (int i = y2 - 1; i >= y1; i--) {
				// �ϳ��ϳ��� �Ź� �ּҸ� ����
				min = Math.min(min, square[x1][i]);
				// �̵� , �� ĭ ������ ���� �� �� ���� ��
				square[x1][i + 1] = square[x1][i];
			}

			// 2) ���ڸ� �������� (����) �۾���
			for (int i = x1 + 1; i <= x2; i++) {
				min = Math.min(min, square[i][y1]);
				square[i - 1][y1] = square[i][y1];
			}

			// 3) ���ڸ� �������� (�Ʒ���) �۾���
			for (int i = y1 + 1; i <= y2; i++) {
				min = Math.min(min, square[x2][i]);
				square[x2][i - 1] = square[x2][i];

			}
			// 4) ���ڸ� �Ʒ��� (������)
			for (int i = x2 - 1; i >= x1; i--) {
				min = Math.min(min, square[i][y2]);
				square[i + 1][y2] = square[i][y2];
			}

			square[x1 + 1][y2] = firstNum;
			answer[minimalIdx] = min;
			// query �Ѱ��� �����ϰ� ���� ���� ���� ��
			minimalIdx++;

		}
		return answer;
	}
}
