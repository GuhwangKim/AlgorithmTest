package programmers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution16 {
	    public int[] solution(int N, int[] stages) {
            int[] answer= new int[N];

	    	double[] ans= new double[N];
	        
	        double count=0;
	        
	        double a = stages.length;
	        
	        List<Double> list = new ArrayList<Double>();
	        
	        for (int j = 1; j < N+1; j++) {
				for (int i = 0; i < stages.length; i++) {
					if(j==stages[i]) {
						count++;
					}
				}
				
				if(a==0) {
					ans[j-1]=(double)0;
					list.add((double)0);
                    
                    
				}else {
					ans[j-1]=count/a;
					list.add(count/a);
					
				}
				a-=count;
				count=0;
			}
	        
	         Collections.sort(list,Collections.reverseOrder());
	         
	         for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < ans.length; j++) {
					if(list.get(i)==ans[j]) {
						answer[i]=j+1;
						ans[j]=(double)-1;
						break;
					}
				}
			}
	        return answer;
	    }
	}
