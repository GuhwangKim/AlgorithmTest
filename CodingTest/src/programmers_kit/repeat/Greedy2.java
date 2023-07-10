package programmers_kit.repeat;

public class Greedy2 {
	public int[] solution(int brown, int yellow) {
		/**
		 * � ���� �ִ�� �ؼ� ���������� ? 
		 * 1�ܰ� : (a-2) (b-2 ) = yellow �� �� ���� yellow�� ���  
		 * 2�ܰ� : a-2 �� ver / b-2 = hor ��� ��� ���� ���س��� 
		 * 3�ܰ� : �ᱹ ���Ϸ��� �ϴ� ���� ver hor ���� +2�� �� �� 
		 * */
		int[] answer = new int[2];
		int ver = yellow;
		for (int hor = 1; hor <= yellow; hor++) {
			if(yellow%hor==0) {
				// ����� �� (a-2) (b-2 ) = yellow 
				ver = yellow/hor;
				if(2*ver + 2*hor + 4 == brown ) {
					answer[0] = Math.max(hor+2, ver+2);
					answer[1] = Math.min(hor+2, ver+2);
					break;
					// �� �������� break �ɾ ������� 
					
				}
			}
		}
		
		
		return answer;

	}

}
