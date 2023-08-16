package programmers_lv2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution32 {
	
    public int solution(int[] topping) {
    	int answer = 0 ;
    	Map<Integer, Integer> A = new HashMap<Integer, Integer>();
    	Set<Integer> B = new HashSet<Integer>();
    	
    	// 각 토핑의 개수를 구해줌 
    	for(int top : topping) {
    		if(A.containsKey(top)) {
    			A.put(top, A.get(top)+1);
    			// 같은게 있다면
    		} else {
    			A.put(top, 1);
    			// 없다면 1 더해줌, 
    		}
    	}
    	
    	for(int top : topping) {
    		A.put(top, A.get(top)-1);
    		// 하나를 빼서 
    		B.add(top);
    		// B에 줌 
    		if(A.get(top)==0) {
    			// B에 다 주었다면 
    			A.remove(top); 
    			// 삭제
    		}
    		if(A.size()==B.size()) {
    			answer++;
    		}
    	}
    	
        return answer;
    }
	

}
