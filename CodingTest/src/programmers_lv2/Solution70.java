package CodingTest.src.programmers_lv2;

import java.util.HashMap;
import java.util.Map;

public class Solution70 {
    public String[] solution(String[] record) {
    	Map<String, String> idMap = new HashMap<String, String>();
    	// id - nickname => id 값이 중복되면 가장 마지막 nickname으로 저장됨 
    	
    	int count = 0 ; // change일떄를 카운트 함 
    	
    	for (int i = 0; i < record.length; i++) {
			String[] info = record[i].split(" ");
			
			if(info[0].equals("Leave")) {
				// 나가는 경우에는 더이상 닉네임 변경될 일 없으므로 안담아도 됨 
				continue;
			} else if (info[0].equals("Enter")) {
				idMap.put(info[1], info[2]); // id 닉네임 
			} else {
				idMap.put(info[1], info[2]);
				count++; // 변경일 때는 카운트 함 
			}
		}
    	
    	String[] answer = new String[record.length - count];
    	int idx = 0;
    	
    	for (int i = 0; i < record.length; i++) {
			String[] info = record[i].split(" ");
			String nickname = idMap.get(info[1]);
			// 아이디에 대한 가장 최근 닉네임 값을 구함 
			
			if(info[0].equals("Enter")) {
				answer[idx++] = nickname + "님이 들어왔습니다.";
			}else if (info[0].equals("Leave")) {
				answer[idx++] = nickname +"님이 나갔습니다.";
			}
		}
        return answer;
    }

}
