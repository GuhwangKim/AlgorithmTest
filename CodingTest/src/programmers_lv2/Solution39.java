package programmers_lv2;

public class Solution39 {
	int max;
	int len = 11;
	int[] maxRyan = new int[len];

	public int[] solution(int n, int[] info) {
		DFS(0, n, 0, new int[n], info);
		// max == 0 이라면 라이언이 이긴적 없음 
		
		
		return max == 0? new int[] {-1} : maxRyan;
		
	}

	private void DFS(int start, int rest, int idx, int[] result, int[] info) { // result는 화살의 개수 만큼 
		if(idx == rest) {
			// 화살을 남은 개수 만큼 쏜경우 
			int[] info2 = new int[len];
			for(int score : result) {
				// 라이언의 화살 맞춘 개수를 배열에 집어넣음 ex 7점  -> 3번 인덱스 
				info2[10-score]++;
			}
			
			int ryan = 0;
			int apeach = 0;
			
			for (int i = 0; i < 11; i++) {
				//info[0] = 10 / info[1] = 9
				int score = 10-i;
				if(info2[i] > info[i]) {
					// 맞춘 과녁의 개수가 라이언이 더 클 때 
					ryan += score;
					// 라이언이 점수 얻음 
				} else if (info2[i] < info[i]) {
					// 과녁의 개수가 어피치가 더 클 때 
					apeach += score;
					// 어피치가 점수 얻음 
				} else if (info[i]!=0 && info2[i]==info[i]) {
					// 어피치 과녁의 개수가 있는데, 과녁의 개수가 같을 때
					apeach += score;
					// 어피치가 점수 얻음 
					
				}
			}
			if(ryan-apeach>max) {
				max = ryan-apeach;
				// 라이언과 어피치의 과녁의 합의 차가 크다 = 라이언이 더 높은 득점으로 이기다 
				maxRyan = info2;
			}
			return;
		}
		for (int i = start; i < 11; i++) {
			// 완전 탐색 start 0 일때 0 인덱스 즉 10점에 0 들어감 -> idx가 n 화살보다 작은 경우에 
			result[idx] = i;
			DFS(i, rest, idx+1, result, info);
		}
	}

}
