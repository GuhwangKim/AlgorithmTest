package programmers_lv1;

public class Solution9 {
	class Solution {
	    public int solution(int[] a, int[] b) {
	        int answer = 1234567890;
	        int sum=0;
	        
	        for (int i = 0; i < a.length; i++) {
				sum+=a[i]*b[i];
			}
	        answer=sum;
	        
	        return answer;
	    }
	}
	

}
