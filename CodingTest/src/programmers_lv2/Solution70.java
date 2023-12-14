package CodingTest.src.programmers_lv2;

import java.util.HashMap;
import java.util.Map;

public class Solution70 {
    public String[] solution(String[] record) {
    	Map<String, String> idMap = new HashMap<String, String>();
    	// id - nickname => id ���� �ߺ��Ǹ� ���� ������ nickname���� ����� 
    	
    	int count = 0 ; // change�ϋ��� ī��Ʈ �� 
    	
    	for (int i = 0; i < record.length; i++) {
			String[] info = record[i].split(" ");
			
			if(info[0].equals("Leave")) {
				// ������ ��쿡�� ���̻� �г��� ����� �� �����Ƿ� �ȴ�Ƶ� �� 
				continue;
			} else if (info[0].equals("Enter")) {
				idMap.put(info[1], info[2]); // id �г��� 
			} else {
				idMap.put(info[1], info[2]);
				count++; // ������ ���� ī��Ʈ �� 
			}
		}
    	
    	String[] answer = new String[record.length - count];
    	int idx = 0;
    	
    	for (int i = 0; i < record.length; i++) {
			String[] info = record[i].split(" ");
			String nickname = idMap.get(info[1]);
			// ���̵� ���� ���� �ֱ� �г��� ���� ���� 
			
			if(info[0].equals("Enter")) {
				answer[idx++] = nickname + "���� ���Խ��ϴ�.";
			}else if (info[0].equals("Leave")) {
				answer[idx++] = nickname +"���� �������ϴ�.";
			}
		}
        return answer;
    }

}
