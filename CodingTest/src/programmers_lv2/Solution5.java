package programmers_lv2;

import java.sql.Array;
import java.util.HashMap;
import java.util.Map;

public class Solution5 {
	class Solution {
	    public int solution(int k, int[][] dungeons) {
	        int answer = -1;
	        int idx=0;
	        
//	        k-dungeons[전의 행][1] = 남은 에너지 
//    		dungeons[다음행][0] = 필요 에너지 		
//	        k-dungeons[전의 행][1]>dungeons[다음행][0];
//	        카운트 가장 큰 
//	        
//	        dungeons[1][1];
//	        dungeons[2][1];
	        
	        
	        for (int i = 0; i < dungeons.length; i++) {
				idx=k-dungeons[i][1];
				if(dungeons[i+1][0]>idx) {
					idx=k-dungeons[i+1][1];
				}
			
			}
	        
	        return answer;
	    }
	}
	

}
