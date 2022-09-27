package programmers_lv1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution3 {
	class Solution {
	    public int[] solution(int[] lottos, int[] win_nums) {
	        int[] answer = {};
	        
	        List<Integer> list1=new ArrayList<Integer>();
	        List<Integer> list2=new ArrayList<Integer>();
	        
	        
	        for (int i = 0; i < lottos.length; i++) {
	        	for (int j = 0; j < win_nums.length; j++) {
	        		if(lottos[i]==win_nums[j]) {
	        			list1.add(lottos[i]);
	        			list2.add(lottos[i]);
	        		}
	        		
	        		if(lottos[i]!=win_nums[j]) {
	        			if(lottos[i]==0) {
	        				list1.add(win_nums[j]);
	        			}
	        		}
					
				}
				
			}
	        
	        switch (list1.size()) {
			case 6:
				answer[0]=1;
				break;
			case 5:
				answer[0]=2;
				break;
			case 4:
				answer[0]=3;
				break;
			case 3:
				answer[0]=4;
				break;
			case 2:
				answer[0]=5;
				break;				
			default:
				answer[0]=6;
				break;
			}
	        
	        switch (list2.size()) {
			case 6:
				answer[1]=1;
				break;
			case 5:
				answer[1]=2;
				break;
			case 4:
				answer[1]=3;
				break;
			case 3:
				answer[1]=4;
				break;
			case 2:
				answer[1]=5;
				break;				
			default:
				answer[1]=6;
				break;
			}	      
	        
	        
	        int count=0;
	        int zeroCnt=0;
	        
	        for(int lt: lottos) {
	        	if(lt==0) {
	        		zeroCnt++;
	        	}
	        	for(int w : win_nums) {
	        		if(lt==w) {
	        			count++;
	        		}
	        	}
	        }
	        
	        answer=new int[2];
	        
	        int tot=zeroCnt+count;
	        
	        if(tot==0) {
	        	tot=1;
	        }
	        
	        if(count==0) {
	        	count=1;
	        }
	        
	        answer[0]=7-(tot);
	        answer[1]=7-(count);
	        
	        return answer;
	    }
	}

}
