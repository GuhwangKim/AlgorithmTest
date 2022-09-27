package programmers_lv1;


public class Solution25 {
	class Solution {
		public int solution(String dartResult) {
			int[] score=new int[3];
			char[] dat=dartResult.toCharArray();
			int cnt=-1;
			
			for (int i = 0; i < dat.length; i++) {
				if(dat[i]>='0'&&dat[i]<='9') {
					cnt++;
					if(dat[i]=='1'&&dat[i+1]=='0') {
						score[cnt]=10;
						i++;
					} else {
						score[cnt]=dat[i]-'0';
					}
				} else if (dat[i]=='D') {
					score[cnt]*=score[cnt];
					
				} else if (dat[i]=='T') {
					score[cnt]*=score[cnt]*score[cnt];
					
				} else if (dat[i]=='*') {
					score[cnt]*=2;
					
					if(cnt>0) {
						score[cnt-1]*=2;
					}
					
				} else if (dat[i]=='#') {
					score[cnt]*=-1;
					
				}
				
			}
			return  score[0]+score[1]+score[2];

		}
	}
	

}
