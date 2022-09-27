package programmers_lv1;

public class Solution38 {
	class Solution {
		public int solution(int n) {
			int answer = 0;
			int[] number=new int[n+1];
			
	        // 2 이상 자연수 이기 때문에 
			for (int i = 2; i <=n; i++) {
				number[i]=i;
				
			}
			
			// 2 부터 시작해서 2부터 시작한 자연수를 곱한 배수를 (1로 곱한 건 자기 자신)
			// 0 으로 만듦
			for (int i = 2; i <=n; i++) {
				for (int j = 2*i; j <=n; j+=i) {
					// 2 : 4 6 8 ---
					// 3 : 6 9 12 ---
					// 4 : 8 12 16 
					number[j]=0;
				}
			}
			
			for (int i = 2; i < number.length; i++) {
				if(number[i]!=0)
					answer++;
			}
			
			return answer;
		}
	}

}
