package programmers_lv2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {
	class Solution {
		public int[] solution(int[] fees, String[] records) {
			// String 을 어떻게 끊어야할까
			int[] answer = {};
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			Map<String, Integer> fmap = new HashMap<String, Integer>();
			
			for (int i = 0; i < records.length; i++) {
				fmap.put(records[i].split(" ")[1], 0);
			}

			for (int i = 0; i < records.length; i++) {
				String[] infos = records[i].split(" ");
				if(m1ap.containsKey(infos[1])) {
					
				}2
				
				
			}
			
			
			return answer;
		}
	}

}
