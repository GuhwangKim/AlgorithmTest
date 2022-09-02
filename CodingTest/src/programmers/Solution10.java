package programmers;

public class Solution10 {
	class Solution {
	    public int solution(int[] nums) {
	        int answer = -1;
	        int count=0;

	        for (int i = 0; i < nums.length-2; i++) {
				for (int j = i+1; j < nums.length-1; j++) {
					for (int l = j+1; l < nums.length; l++) {
						boolean test1=test((nums[i]+nums[j]+nums[l]));
						if(test1==true) {
							count++;
							}
                        
						}
                    
					}
               
	        	}
	        answer=count;
	        
	        return answer;
	        
			}
	        

	    public boolean test(final int n) {
	    	
	    	for (int i = 2; i < n; i++) {
				if(n%i==0) {
					return false;
				}
			}
	    	return true;
	    }
	   
	}

}
