package CodingTest.src.programmers_lv2;

public class Solution23 {
	int subs = 0;
	int purchase = 0;
	public int[] solution(int[][] users, int[] emoticons) {
		int[] answer = new int[2];

		int[] disPercent = new int[emoticons.length];
		// 할인율이 적용된 이모티콘의 가격이 저장됨 
		
		comb(disPercent, 0, users, emoticons);

		answer[0] = subs;
		answer[1] = purchase;

		return answer;
	}
	
	private void comb(int[] disPercent, int startIdx, int[][] users, int[] emoticons) {
		if(startIdx == disPercent.length) {
			// 10 10 10 10 으로 채워진다면, 
			calculate(disPercent, users, emoticons);
			return;
		}
		
		for (int i = 10; i <= 40; i+=10) {
			disPercent[startIdx] = i;
			// 0 ~ 3 까지 모두 10으로 (20, 30, 40) 채워짐 
			comb(disPercent, startIdx+1, users, emoticons);
			// 
		}
		
	}

	public void calculate (int[] disPercent, int[][] users, int[] emoticons) {
		int count = 0;
		int earn = 0;
		for (int i = 0; i < users.length; i++) {
			int sum = 0;

			for (int j = 0; j < disPercent.length; j++) {
				if(disPercent[j] >= users[i][0]) {
					// users[i][0] 이상인 상품들만 구매하기 때문에 
					sum+=(emoticons[j]/100)*(100-disPercent[j]);
				}
			}

			if (sum >= users[i][1]) {
				count++;
			} else {
				earn += sum;
			}
		}
		if(count>subs) {
			subs= count;
			// 구독자수가 더 크면 교환함 
			purchase = earn;
			return;
		}else if (count==subs) {
			if(purchase<earn) {
				// 구독자 수는 같은데 벌이가 더 큰 경우 
				purchase = earn;
			}
		}
	}
}