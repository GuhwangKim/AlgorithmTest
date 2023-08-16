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
    	
    	// �� ������ ������ ������ 
    	for(int top : topping) {
    		if(A.containsKey(top)) {
    			A.put(top, A.get(top)+1);
    			// ������ �ִٸ�
    		} else {
    			A.put(top, 1);
    			// ���ٸ� 1 ������, 
    		}
    	}
    	
    	for(int top : topping) {
    		A.put(top, A.get(top)-1);
    		// �ϳ��� ���� 
    		B.add(top);
    		// B�� �� 
    		if(A.get(top)==0) {
    			// B�� �� �־��ٸ� 
    			A.remove(top); 
    			// ����
    		}
    		if(A.size()==B.size()) {
    			answer++;
    		}
    	}
    	
        return answer;
    }
	

}
