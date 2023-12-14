package programmers_lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution72 {
	
	class FileName {
		private String head;
		private String number;
		private String tail;
		
		public FileName(String name, String number, String tail) {
			this.head = head;
			this.number = number;
			this.tail = tail;
		}
	}
	
	 public String[] solution(String[] files) {
	        String[] answer = {};
	        // number�� �������� ����
	        List<FileName> list = new ArrayList<>();
	        
	        for(String file : files) {
	        	// ���ڰ� ������ ���۰� �� �ε����� ã�� 
	        	int startIdx = -1;
	        	int endIdx = -1;
	        	
	        	for (int i = 0; i < file.length(); i++) {
	        		char curChar = file.charAt(i);
					if(Integer.class.isInstance(curChar-'0')) {
						// ���� ���� ���ڶ�� 
						if(startIdx==-1) {
							// ���� ���� �ʱ� ���� 
							startIdx = i;
						}else {
							// �� ���� ���� ���� ������ 
							endIdx = i;
							// 2���� �ϸ� �ǰ� �� ������ �߿����� ���� 
							break; 
						}
					}
				}
	        	
	        	String name = file.substring(0, startIdx);
	        	String number = file.substring(startIdx, endIdx);
	        	String tail;
	        	if(endIdx<file.length()-1) {
	        		// ������ �ε����� ���̺��� ���� �� 
	        		tail = file.substring(endIdx);
	        	}else {
	        		tail = "";
	        	}
	        	FileName fileName = new FileName(name, number, tail);
	        	list.add(fileName);
	        }
	        
	        Collections.sort(list, (o1, o2) -> {);
	        
	        
	        return answer;
	    }
}
