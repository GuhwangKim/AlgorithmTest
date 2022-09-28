package programmers_lv2;

// 미완 알고리즘 학습 필요
public class Solution2 {
	class Solution {
	    public int[] solution(int n, int[] info) {
	        int[] answer = new int[info.length];
	        int[] asum = new int[info.length];
	        int[] rsum = new int[info.length];
	        
	        for (int i = 0; i < info.length; i++) {
	        	asum[i]=(10-i)*info[i];
			}
	        for (int i = 0; i < rsum.length; i++) {
				rsum[i]=(10-i)*(n-answer[i]);
			}
	        
	        
	        return answer;
	    }
	}

}
