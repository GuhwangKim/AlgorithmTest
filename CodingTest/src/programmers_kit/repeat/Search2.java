package programmers_kit.repeat;

public class Greedy2 {
	public int[] solution(int brown, int yellow) {
		/**
		 * 어떤 수를 최대로 해서 돌려야할지 ? 
		 * 1단계 : (a-2) (b-2 ) = yellow 각 각 수는 yellow의 약수  
		 * 2단계 : a-2 를 ver / b-2 = hor 라고 잡고 값을 구해나감 
		 * 3단계 : 결국 구하려고 하는 값은 ver hor 값에 +2를 한 값 
		 * */
		int[] answer = new int[2];
		int ver = yellow;
		for (int hor = 1; hor <= yellow; hor++) {
			if(yellow%hor==0) {
				// 약수일 때 (a-2) (b-2 ) = yellow 
				ver = yellow/hor;
				if(2*ver + 2*hor + 4 == brown ) {
					answer[0] = Math.max(hor+2, ver+2);
					answer[1] = Math.min(hor+2, ver+2);
					break;
					// 다 끝났으면 break 걸어서 빼줘야함 
					
				}
			}
		}
		
		
		return answer;

	}

}
