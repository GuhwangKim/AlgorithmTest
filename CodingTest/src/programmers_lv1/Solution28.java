package programmers_lv1;

public class Solution28 {
	public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long q=0;
        
        for (int i = 0; i < n; i++) {
			q+=x;
			answer[i]=q;
		}
        
        return answer;
    }

}
