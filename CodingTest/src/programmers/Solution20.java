package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Solution20 {
	class Solution {
	    public int[] solution(int[] numbers) {
	        HashSet<Integer> list = new HashSet<Integer>();
	        
	        for (int i = 0; i < numbers.length; i++) {
	        	for (int j = i+1; j < numbers.length; j++) {
	        		int sum=numbers[i]+numbers[j];
	        		list.add(sum);
				}
			}
	        
	        int[] answer = new int[list.size()];
	        
	        Iterator<Integer> lit= list.iterator();
	        
	        for (int i = 0; i < answer.length; i++) {
				while (lit.hasNext()) {
					answer[i]=lit.next();
					break;
				}
			}
	        
	        Arrays.sort(answer);
	        
	        return answer;
	    }
	}

}
