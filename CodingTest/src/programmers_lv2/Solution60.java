package programmers_lv2;

public class Solution60 {
	public int solution(int[] stones, int k) {
		int answer = 0;
		int min = 1;
		int max = 200000000;

		// 건널 수 있는 인원 max 가 아직은 크다
		while(min<=max){
			// 건널 인원 반 시도
			int mid = (min + max) / 2;
			if(canAcrossRiver(stones, k, mid)){
				// 건널 수 있다면 더 많이 시도해봄
				min = mid +1;
				answer = Math.max(answer, mid);

			}else{
				// 건널 수 없으면 좁힘
				max = mid-1;
			}
		}
		return answer;
	}

	private boolean canAcrossRiver(int[] stones, int k, int friends) {
		int skip = 0;
		for (int stone : stones){
			if(stone - friends < 0){
				// 3명이 건너야 하는데 돌맹이의 현재 가능한 수가 그거보다 작다면 불가능
				skip++;
			}else{
				// 0 이상이면 건널 수 있음, 건넜다면 skip이 reset 됨
				skip = 0;
			}
			if(skip == k) {
				// k 만큼 건너뛰었으면 못 건넘
				return false;
			}
		}
		return true;
	}

}
