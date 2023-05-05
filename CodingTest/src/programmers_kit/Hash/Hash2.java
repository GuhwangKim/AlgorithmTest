package programmers_kit.Hash;

import java.util.Arrays;

public class Hash2 {
	public static void main(String[] args) {
		Hash2 s = new Hash2();
		String[] a = { "123", "456", "789" };
		s.solution(a);
	}

	public boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
		for (int i = 0; i < phone_book.length-1; i++) {
			if(phone_book[i+1].startsWith(phone_book[i]))
				return false;
		}
		return true;
	}

}
