package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution22 {
	class Solution {
	    public int[] solution(String[] id_list, String[] report, int k) {
	        int[] answer = new int [id_list.length];

	        Map<String, Integer> idM=new HashMap<String, Integer>();
	        Map<String, HashSet<String>> map=new HashMap<String, HashSet<String>>();
	        
	        // 초기화
	        for (int i = 0; i < id_list.length; i++) {
				idM.put(id_list[i], i);
				map.put(id_list[i], new HashSet<String>());
			}
	        
	        // 자신을 신고한 사람의 이름을 저장 
	        for (int i = 0; i < report.length; i++) {
				String[] str=report[i].split(" ");
				map.get(str[1]).add(str[0]);
			}
	        
	        for (int i = 0; i < id_list.length; i++) {
				HashSet<String> set=map.get(id_list[i]);
				if(set.size()>=k) {
					for(String id : set) {
						answer[idM.get(id)]++;
					}
				}
			}
	        return answer;
	        
	    }
	}
}
