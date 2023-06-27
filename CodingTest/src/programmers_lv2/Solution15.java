package CodingTest.src.programmers_lv2;

public class Solution15 {

	/**
	 * 1. 승자가 없는 경우 o가 x 보다 2개 이상 많으면 안됨, x는 o보다 1개 이상 많으면 안됨 2. o가 승리하는 경우 : o 는
	 * x보다 1개 더 많음 3. x가 승리하는 경우 : x 의 개수 = o의 개수 4. o x 모두 승리하는 경우 없음 (개수가 서로 3개)
	 */
	public int solution(String[] board) {
		int answer = -1;

		int countO = 0;
		int countX = 0;

		int oWin = 0;
		int xWin = 0;

		// 개수를 세줌
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

		// 개수로 검증 우선
		if (countO - countX > 1 || countX > countO) {
			return 0;
		}
		// 0가 이기는 경우
		if (countO >= 3) {
			oWin = winnderCheck(board, 'O');
		}

		// X가 이기는 경우
		if (countX >= 3) {
			xWin = winnderCheck(board, 'X');
		}

		// 둘다 이기는 경우 없음
		if (oWin == 1 && xWin == 1) {
			return 0;
		}

		// 0 승리시에
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

		// 가로 체크
		for (int i = 0; i < 3; i++) {
			check = true;
			for (int j = 0; j < 3; j++) {
				if (board[i].charAt(j) != ox) {
					check = false;
					// 한줄이 하나라도 다른게 있으면 false
				}
			}
			if (check) {
				return 1;
				// 한줄이라도 같으면 완료
			}
		}

		// 세로 체크
		for (int i = 0; i < 3; i++) {
			check = true;
			for (int j = 0; j < 3; j++) {
				if (board[j].charAt(i) != ox) {
					check = false;
					// 한줄이 하나라도 다른게 있으면 false
				}
			}
			if (check) {
				return 1;
				// 한줄이라도 같으면 완료
			}
		}

		// 대각선 체크
		if (board[0].charAt(0) == ox && board[1].charAt(1) == ox && board[2].charAt(2) == ox) {
			return 1;
		}
		if (board[0].charAt(2) == ox && board[1].charAt(1) == ox && board[2].charAt(0) == ox) {
			return 1;
		}
		return 0;

	}
}
