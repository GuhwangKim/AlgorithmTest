package programmers_lv2;

import java.util.HashSet;
import java.util.Set;

public class Solution56 {
	public int[] solution(String[] gems) {
        int[] answer = new int[2];
        /**
         * ������� ���� �ȿ� �ȿ� �ִ� ��� ������ �����ؾ��� 
         * �׶� �����ε��� ~ �� �ε����� ����� 
         * ���� �ε����� ���� ���� ���� 
         * 
         * */
        
        // 1. set���� �ؼ� gems �ȿ� �ִ� ������ �� ������ ���ϰ� 
        // 2. 1���� �����ؼ�, �� ������ ���� �������� startIdx, endIdx �� ������ 
        // 3. �� �ε����� ���� ���� �� -> startIdx�� ���� ���� ����
        
        Set<String> set = new HashSet<String>();
        for(String gem : gems) {
        	set.add(gem);
        }
        int typesTotalCnt = set.size();
        int lastIdx = gems.length - typesTotalCnt;
        
        for (int i = 0; i <= lastIdx ; i++) {
        	String standard = gems[i];
        	int curTypecnt = 1;
        	// ������ �Ǵ� ���� 
			for (int j = i; j < gems.length; j++) {
				if(standard.equals(gems[j])) {
					// �ߺ��Ǵ� ��� 
					continue;
				}
				// �׷��� ���� ��� 
				curTypecnt++;
				
			}
		}
        
        
        
        
        
        
        
        return answer;
    }
}
