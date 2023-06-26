package programmers_kit.repeat;

public class Greedy1 {
	
	/**
	 * 1. ���� ���� ���ذ� - A/ Z- ���ذ� +1 
	 * 2. �¿� i �� Ŀ���鼭 A ������ �������� 
	 * - A �� �������� �ڿ� ���� ���� �� ���� ��� : ������� ó~ �� �����̴� ��� 
	 * - A�� �������� �ڿ� ���� ���� �� ª�� ��� : �켱 �ڷ� ���ٰ� �ٽ� ���� ��� 
	 * 
	 * */
	 public int solution(String name) {
		 int answer = 0;
		 int move = name.length()-1;
		 
		 for (int i = 0; i < name.length(); i++) {
			answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i));
			int idxNext = i+1;
			while(idxNext<name.length() && name.charAt(idxNext)=='A') {
				idxNext++;
			}
			move = Math.min(move, i+Math.min(i, name.length()-idxNext))+name.length()-idxNext;
		}
		 
		 
		 return answer+move;
	 }

}
