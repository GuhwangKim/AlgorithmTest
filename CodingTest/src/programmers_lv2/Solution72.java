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
	        // number를 기준으로 나뉨
	        List<FileName> list = new ArrayList<>();
	        
	        for(String file : files) {
	        	// 숫자가 나오는 시작과 끝 인덱스를 찾자 
	        	int startIdx = -1;
	        	int endIdx = -1;
	        	
	        	for (int i = 0; i < file.length(); i++) {
	        		char curChar = file.charAt(i);
					if(Integer.class.isInstance(curChar-'0')) {
						// 현재 값이 숫자라면 
						if(startIdx==-1) {
							// 시작 값이 초기 상태 
							startIdx = i;
						}else {
							// 그 다음 나온 값은 마지막 
							endIdx = i;
							// 2번만 하면 되고 그 다음은 중요하지 않음 
							break; 
						}
					}
				}
	        	
	        	String name = file.substring(0, startIdx);
	        	String number = file.substring(startIdx, endIdx);
	        	String tail;
	        	if(endIdx<file.length()-1) {
	        		// 마지막 인덱스가 길이보다 작을 때 
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
