package programmers_kit.Array;

import java.util.Arrays;

public class Array2 {
	public int solution(int[] citations) {
		int answer = 0;
		int cnt = 1;
		Arrays.sort(citations);
		// h�� �̻� �ο�� ���� ���� h ���� ���� �ִ� 
		
		for (int i = 0; i < citations.length; i++) {
			// ���� ���� �� ���� �������� ��, �ο�� h index �� ���� - �ε����� ��ġ 
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
		 * 1. 1���� �����ؼ� 
		 * 2. n�� �̻��� �� ī���� 
		 * 3. n�� �̻��� ���� �� = n �� ���ٸ� 
		 * 4. answer =
		 * Math.max(answer, n�� �̻��� ���� ��)
		 */
		return answer;
	}

}
