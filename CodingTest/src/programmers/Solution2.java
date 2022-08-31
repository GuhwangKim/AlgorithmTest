package programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	
	public static void main(String[] args) {
		int[][] size= new int[3][5];
		
		System.out.println(size[0].length);
	}
	
	class Solution {
	    public int solution(int[][] sizes) {
	        int answer = 0;
	        
	        int mwidth=0;
	        int mheight=0;
	        
	        for (int i = 0; i < sizes.length; i++) {
	        	int w;
				for (int j = 0; j < 2; j++) {
					if(sizes[i][0]<sizes[i][1]) {
						w=sizes[i][0];
						sizes[i][0]=sizes[i][1];
						sizes[i][1]=w;
					}
					
					if(mwidth<sizes[i][0]) {
						mwidth=sizes[i][0];
					}
					if(mheight<sizes[i][1]) {
						mheight=sizes[i][1];
					}
				}
			}
	        return mwidth*mheight;
	    }
	}

}
