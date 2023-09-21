package programmers_kit.repeat2;

import java.util.Arrays;

public class Hash1 {
	 public boolean solution(String[] phone_book) {
		 
		 Arrays.sort(phone_book);
		 
		 for (int i = 0; i < phone_book.length; i++) {
			for (int j = i+1; j < phone_book.length; j++) {
				if(phone_book[j].startsWith(phone_book[i])) {
					return false;
					
				}
			}
		}
		 
		return true;
	 }

}
