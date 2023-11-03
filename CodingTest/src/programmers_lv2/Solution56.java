package programmers_lv2;

import java.util.HashSet;
import java.util.Set;

public class Solution56 {
	public static void main(String[] args) {
		Solution56 s = new Solution56();
		String[] arr = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		s.solution(arr);
		
	}
	
	public int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = gems.length;
        
        Set<String> set = new HashSet<String>();
        for(String gem : gems) {
        	set.add(gem);
        	
        }
        int typesTotalCnt = set.size();
        if(typesTotalCnt==1) {
        	// 1���� ������ 
        	answer[0]=1;
        	answer[1]=1;
        	return answer;
        }
        int lastIdx = gems.length - typesTotalCnt;
        for (int i = 0; i <= lastIdx ; i++) {
        	Set<String> set2 = new HashSet<String>();
        	set2.add(gems[i]);
        	// ������ �Ǵ� ���� 
			for (int j = i+1; j < gems.length; j++) {
				if(set2.contains(gems[j])) {
					// �ߺ��Ǵ� ��� 
					continue;
				}
				// �׷��� ���� ��� 
				set2.add(gems[j]);
				if(set2.size()==typesTotalCnt) {
					// �� ������ ���ٸ� 
					if((answer[1]-answer[0]>j-i)) {
						// ���� �� �۴ٸ� 
						answer[0] = i+1;
						answer[1] = j+1;
					}
				}
			}
		}
        return answer;
    }
}
