package programmers_lv2;

import java.sql.Array;
import java.util.HashMap;
import java.util.Map;

public class Solution5 {
	class Solution {
	    public int solution(int k, int[][] dungeons) {
	        int answer = -1;
	        int idx=0;
	        
//	        k-dungeons[���� ��][1] = ���� ������ 
//    		dungeons[������][0] = �ʿ� ������ 		
//	        k-dungeons[���� ��][1]>dungeons[������][0];
//	        ī��Ʈ ���� ū 
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
