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
         * info는 space 를 기준으로 split 해주면 되는데 
         * query 는 어떻게 나눌 것인가 
         * 
         * */
        Map<Integer, String[]> map = new HashMap<Integer, String[]>();
        int idx = 1;
        // 1. 지원자들에 대한 정보를 배열에 담아서 list에 넣어줌 
        for(String each : info) {
        	String[] candidate = each.split(" ");
        	map.put(idx, candidate);
        	idx++;
        }
        int answerIdx = 0;
        // 2. 조건을 배열에 담음, and는 조건에서 제외 
        for(String each : query) {
        	String[] eachRequire = each.split(" ");
        	eachRequire = Arrays.stream(eachRequire).filter(t -> !t.equals("and")).toArray(String[]::new);
        	
        	// 3. 조건에 만족하지 않는 인덱스를 제거해주기 위해 지원자의 수를 담은 배열 생성 
        	Integer[] idxs= new Integer[info.length];
        	Arrays.setAll(idxs, i->i+1);
        	List<Integer> listIdsx = Arrays.asList(idxs);
        	
        	// 4 해당 조건별로 비교해서 idx를 삭제해줌
        	for (int i = 0; i < eachRequire.length; i++) { // java
        		if(eachRequire[i] == "-") {
        			continue;
        		}
        		for (int j = 0; j < idxs.length; j++) { // 지원자별로 비교 (지원자 길이) 
					if(isInteger(eachRequire[i])) {
						if(Integer.parseInt(eachRequire[i])>Integer.parseInt(map.get(idxs[j])[i])) {
							listIdsx.remove(j);
							continue; // 해당 지원자는 제외시킴 
						}
						continue;
					}
        			if(eachRequire[i] != map.get(idxs[j])[i]) {
						// java 를 지원자별 i 번쨰 있는 것과 비교해서 같지 않으면 
						listIdsx.remove(j);
						continue; // 해당 지원자는 제외시킴 
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
