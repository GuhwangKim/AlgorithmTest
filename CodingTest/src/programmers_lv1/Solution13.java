package programmers_lv1;

import java.util.Arrays;

public class Solution13 {
	class Solution {
	    public int[] solution(int[] array, int[][] commands) {
	        int[] answer = {};
	        int[] answer1=new int[commands.length];;
	        
	        for (int i = 0; i < commands.length; i++) {
	        	answer=new int[commands[i][1]-commands[i][0]+1];
				for (int j = 0; j < answer.length; j++) {
					answer[j]=array[commands[i][0]-1+j];
				}
				Arrays.sort(answer);
				answer1[i]=answer[commands[i][2]-1];
			}
	        return answer1;
	    }
	}

}
