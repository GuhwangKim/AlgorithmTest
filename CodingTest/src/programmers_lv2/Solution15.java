package CodingTest.src.programmers_lv2;

public class Solution15 {

	/**
	 * 1. ���ڰ� ���� ��� o�� x ���� 2�� �̻� ������ �ȵ�, x�� o���� 1�� �̻� ������ �ȵ� 2. o�� �¸��ϴ� ��� : o ��
	 * x���� 1�� �� ���� 3. x�� �¸��ϴ� ��� : x �� ���� = o�� ���� 4. o x ��� �¸��ϴ� ��� ���� (������ ���� 3��)
	 */
	public int solution(String[] board) {
		int answer = -1;

		int countO = 0;
		int countX = 0;

		int oWin = 0;
		int xWin = 0;

		// ������ ����
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i].charAt(j) == 'O') {
					countO++;
				}
				if (board[i].charAt(j) == 'X') {
					countX++;
				}
			}
		}

		// ������ ���� �켱
		if (countO - countX > 1 || countX > countO) {
			return 0;
		}
		// 0�� �̱�� ���
		if (countO >= 3) {
			oWin = winnderCheck(board, 'O');
		}

		// X�� �̱�� ���
		if (countX >= 3) {
			xWin = winnderCheck(board, 'X');
		}

		// �Ѵ� �̱�� ��� ����
		if (oWin == 1 && xWin == 1) {
			return 0;
		}

		// 0 �¸��ÿ�
		if (oWin == 1) {
			if (countO == countX + 1) {
				return 1;
			} else {
				return 0;
			}
		}
		if (xWin == 1) {
			if (countX == countO) {
				return 1;
			} else {
				return 0;
			}
		}

		return 1;
	}

	public int winnderCheck(String[] board, char ox) {

		boolean check = true;

		// ���� üũ
		for (int i = 0; i < 3; i++) {
			check = true;
			for (int j = 0; j < 3; j++) {
				if (board[i].charAt(j) != ox) {
					check = false;
					// ������ �ϳ��� �ٸ��� ������ false
				}
			}
			if (check) {
				return 1;
				// �����̶� ������ �Ϸ�
			}
		}

		// ���� üũ
		for (int i = 0; i < 3; i++) {
			check = true;
			for (int j = 0; j < 3; j++) {
				if (board[j].charAt(i) != ox) {
					check = false;
					// ������ �ϳ��� �ٸ��� ������ false
				}
			}
			if (check) {
				return 1;
				// �����̶� ������ �Ϸ�
			}
		}

		// �밢�� üũ
		if (board[0].charAt(0) == ox && board[1].charAt(1) == ox && board[2].charAt(2) == ox) {
			return 1;
		}
		if (board[0].charAt(2) == ox && board[1].charAt(1) == ox && board[2].charAt(0) == ox) {
			return 1;
		}
		return 0;

	}
}
