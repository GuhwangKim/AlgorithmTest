package programmers;

import java.util.HashMap;
import java.util.Map;

public class Solution21 {
	class Solution {
	    public String solution(String[] survey, int[] choices) {
	        String answer = "";
	        
	       
	        Map<Character, Integer> map=new HashMap<Character, Integer>();
	        
	        map.put('R', 0);
	        map.put('T', 0);
	        map.put('C', 0);
	        map.put('F', 0);
	        map.put('J', 0);
	        map.put('M', 0);
	        map.put('A', 0);
	        map.put('N', 0);
	        
	        
	        for (int i = 0; i < choices.length; i++) {
				if(choices[i]>=4) {
					map.put(survey[i].charAt(1), map.get(survey[i].charAt(1))+Math.abs(choices[i]-4));
				} else {
					map.put(survey[i].charAt(0), map.get(survey[i].charAt(0))+Math.abs(choices[i]-4));
				}
			}
	        
	        String a=map.get('R')>=map.get('T')?"R":"T";
	        String b=map.get('C')>=map.get('F')?"C":"F";
	        String c=map.get('J')>=map.get('M')?"J":"M";
	        String d=map.get('A')>=map.get('N')?"A":"N";
	        
	        answer=a+b+c+d;
	        
	        return answer;
	    }
	}
	
}
