package programmers_lv2;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {
	class Solution {
	    public int[] solution(int n, long left, long right) {
	        
	        int[] answer = new int [(int)(right-left+1)];
	        
	        int idx=0;
	        for (long i = left; i <= right; i++) {
	        	long row = i/n;
	        	long col = i%n;
				answer[idx++]=Math.max((int)row, (int)col)+1;
			}
	        
	        return answer;
	    }
	}
	
	
	public static void main(String[] args) {
		long right = 5;
		long left = 2; 
		int n = 3;
		
		System.out.println(1/n);
		
       
	}
}
