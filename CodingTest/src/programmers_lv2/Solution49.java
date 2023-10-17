package CodingTest.src.programmers_lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution49 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        
        /**
         * info�� space �� �������� split ���ָ� �Ǵµ� 
         * query �� ��� ���� ���ΰ� 
         * 
         * */
        Map<Integer, String[]> map = new HashMap<Integer, String[]>();
        int idx = 1;
        // 1. �����ڵ鿡 ���� ������ �迭�� ��Ƽ� list�� �־��� 
        for(String each : info) {
        	String[] candidate = each.split(" ");
        	map.put(idx, candidate);
        	idx++;
        }
        int answerIdx = 0;
        // 2. ������ �迭�� ����, and�� ���ǿ��� ���� 
        for(String each : query) {
        	String[] eachRequire = each.split(" ");
        	eachRequire = Arrays.stream(eachRequire).filter(t -> !t.equals("and")).toArray(String[]::new);
        	
        	// 3. ���ǿ� �������� �ʴ� �ε����� �������ֱ� ���� �������� ���� ���� �迭 ���� 
        	Integer[] idxs= new Integer[info.length];
        	Arrays.setAll(idxs, i->i+1);
        	List<Integer> listIdsx = Arrays.asList(idxs);
        	
        	// 4 �ش� ���Ǻ��� ���ؼ� idx�� ��������
        	for (int i = 0; i < eachRequire.length; i++) { // java
        		if(eachRequire[i] == "-") {
        			continue;
        		}
        		for (int j = 0; j < idxs.length; j++) { // �����ں��� �� (������ ����) 
					if(isInteger(eachRequire[i])) {
						if(Integer.parseInt(eachRequire[i])>Integer.parseInt(map.get(idxs[j])[i])) {
							listIdsx.remove(j);
							continue; // �ش� �����ڴ� ���ܽ�Ŵ 
						}
						continue;
					}
        			if(eachRequire[i] != map.get(idxs[j])[i]) {
						// java �� �����ں� i ���� �ִ� �Ͱ� ���ؼ� ���� ������ 
						listIdsx.remove(j);
						continue; // �ش� �����ڴ� ���ܽ�Ŵ 
					}
        			
				}
			}
        	answer[answerIdx] = listIdsx.size();
        	answerIdx++;
        	
        }
        
        return answer;
    }
    
    public static boolean isInteger(String strValue) {
        try {
          Integer.parseInt(strValue);
          return true;
        } catch (NumberFormatException ex) {
          return false;
        }
      }
}
