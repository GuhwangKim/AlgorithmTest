package programmers_kit.Array;

import java.util.Arrays;

public class Array2 {
	public int solution(int[] citations) {
		int answer = 0;
		int cnt = 1;
		Arrays.sort(citations);
		// h번 이상 인용된 논문의 수가 h 번인 것의 최대 
		
		for (int i = 0; i < citations.length; i++) {
			// 가장 낮은 수 부터 시작했을 때, 인용된 h index 는 길이 - 인덱스의 위치 
			int hIdex = citations.length-i;
			
			if(citations[i]>=hIdex) {
				answer = Math.max(answer, hIdex);
			}
			
			
		}

//		for (int i = 0; i < citations.length - 1; i++) {
//			for (int j = i+1; j < citations.length; j++) {
//				if (0 == citations[i]) {
//					continue;
//				} else {
//					if (citations[i] <= citations[j]) {
//						cnt++;
//					}
//
//				}
//
//			}
//			if(citations[i]==cnt) {
//				answer = Math.max(answer,cnt);
//			}
//			cnt = 1;
//		}

		/*
		 * 1. 1부터 시작해서 
		 * 2. n번 이상인 수 카운팅 
		 * 3. n번 이상인 논문의 수 = n 과 같다면 
		 * 4. answer =
		 * Math.max(answer, n번 이상인 논문의 수)
		 */
		return answer;
	}

}
