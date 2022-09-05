package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution14 {
	class Solution {
	    public int[] solution(int[] answers) {
	        
	        int[] a = {1, 2, 3, 4, 5};
	        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
	        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	        
	        int suma=0;
	        int sumb=0;
	        int sumc=0;
	        
	        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
	        
	        for (int i = 0; i < answers.length; i++) {
	        	if(answers[i]==a[i%5]) {
	        		suma++;
	        	}
	        	if(answers[i]==b[i%8]) {
	        		sumb++;
	        	}
	        	if(answers[i]==c[i%10]) {
	        		sumc++;
	        	}
			}
	        
	        int max=Math.max(suma, Math.max(sumc, sumb));
	        
	        count.put(1, suma);
	        count.put(2, sumb);
	        count.put(3, sumc);
	        
	        List<Integer> list= new ArrayList<Integer>();
	        
	        for (int i = 1; i < 4; i++) {
				if(max==count.get(i)) {
					list.add(i);
				}
			}        
	        
	        int[] answer = new int[list.size()];
	        
	        for (int i = 0; i < list.size(); i++) {
				answer[i]=list.get(i);
			}
	        
	        return answer;
	    }
	}
}
