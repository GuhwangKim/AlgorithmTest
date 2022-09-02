package programmers;

import java.util.HashSet;

public class Solution11 {
	class Solution {
	    public int solution(int[] nums) {
	        
	        HashSet<Integer> set= new HashSet<Integer>();
	        
	        for (int i = 0; i < nums.length; i++) {
				set.add(nums[i]);
			}
	        
	        
	        
	        if(set.size()>nums.length/2) {
	        	return nums.length/2;
	        } else {
	        	return set.size();
	        }
	        
	    }
	}

}
