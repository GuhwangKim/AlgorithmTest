package programmers_kit.repeat;

public class Greedy1 {
	
	/**
	 * 1. 상하 생각 기준값 - A/ Z- 기준값 +1 
	 * 2. 좌우 i 가 커지면서 A 나오기 직전까지 
	 * - A 를 기준으로 뒤에 남은 수가 더 많은 경우 : 순리대로 처~ 끝 움직이는 경우 
	 * - A를 기준으로 뒤에 남은 수가 더 짧은 경우 : 우선 뒤로 갔다가 다시 오는 경우 
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
