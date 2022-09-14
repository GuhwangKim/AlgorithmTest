package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution25 {
	class Solution {
		public int solution(String dartResult) {
			int answer = 0;
			int x=0;
			List<Integer> list = new ArrayList<Integer>();
			
			String[] str=new String[dartResult.length()];
			
			for (int i = 0; i < dartResult.length(); i++) {
				str[i]=String.valueOf(dartResult.charAt(i));
			}
			
			for (int i = 1; i < str.length; i++) {
				if(str[i]=="S") {
					x=(int)Math.pow(Integer.parseInt(str[i-1]), 1);
				} else if (str[i]=="D") {
					x=(int)Math.pow(Integer.parseInt(str[i-1]), 2);
				} else if (str[i]=="T") {
					x=(int)Math.pow(Integer.parseInt(str[i-1]), 3);
				} 
				if(str[i+1]!=null) {
					if(str[i+1]=="#") {
						x=(x*(-1));
					} else if (str[i+1]=="*") {
						x=(x*2);
					}
				}
				
			}
			
			
			return answer;

		}
	}
	
	public static void main(String[] args) {
		String dartResult="10S2D*3T";
		StringTokenizer stk=new StringTokenizer(dartResult,"SDT*#");
		
		List<String> list = new ArrayList<String>();
		
		while(stk.hasMoreTokens()) {
			list.add(stk.nextToken());
		}
	}

}
