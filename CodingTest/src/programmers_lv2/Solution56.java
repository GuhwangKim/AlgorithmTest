package programmers_lv2;

import java.util.HashSet;
import java.util.Set;

public class Solution56 {
	public int[] solution(String[] gems) {
        int[] answer = new int[2];
        /**
         * 순서대로 구간 안에 안에 있는 모든 종류를 포함해야함 
         * 그때 시작인덱스 ~ 끝 인덱스를 담아줌 
         * 시작 인덱스는 가장 작은 수로 
         * 
         * */
        
        // 1. set으로 해서 gems 안에 있는 종류의 총 개수를 구하고 
        // 2. 1부터 시작해서, 총 개수를 구할 때까지의 startIdx, endIdx 를 지정함 
        // 3. 두 인덱스의 차가 작은 것 -> startIdx가 작은 것이 답임
        
        Set<String> set = new HashSet<String>();
        for(String gem : gems) {
        	set.add(gem);
        }
        int typesTotalCnt = set.size();
        int lastIdx = gems.length - typesTotalCnt;
        
        for (int i = 0; i <= lastIdx ; i++) {
        	String standard = gems[i];
        	int curTypecnt = 1;
        	// 기준이 되는 보석 
			for (int j = i; j < gems.length; j++) {
				if(standard.equals(gems[j])) {
					// 중복되는 경우 
					continue;
				}
				// 그렇지 않은 경우 
				curTypecnt++;
				
			}
		}
        
        
        
        
        
        
        
        return answer;
    }
}
