package programmers_lv1;

public class Solution24 {
	class Solution {
	    public long solution(int price, int money, int count) {
	        long answer = -1;
	        
	        long sum=0;
	        
	        for (int i = 1; i <= count; i++) {
				sum+=price*i;
			}
	        
	        if(money-sum<0) {
	        	answer=Math.abs(money-sum);
	        } else {
	        	answer=0;
	        }
	        
	        return answer;
	    }
	}

}
