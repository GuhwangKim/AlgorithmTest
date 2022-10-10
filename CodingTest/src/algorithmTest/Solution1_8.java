package algorithmTest;

import java.util.Scanner;

public class Solution1_8 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		str = str.replaceAll(" ", ""); // 띄어쓰기 없애기
		String word = ""; // 전체
		String word1 = ""; // 반 앞에서
		String word2 = ""; // 반 뒤에서
		String word3 = ""; // 반 뒤에서 거꾸로
		String[] st = str.split("[^a-zA-Z]");
		for (String s : st) {
			word += s;
		}
		word = word.toLowerCase();
		double k = (double)word.length()/2;
		word1 = word.substring(0, word.length() / 2);
		word2 = word.substring((int)Math.round(k), word.length());
		for (int i = word2.length() - 1; i >= 0; i--) {
			word3 += word2.charAt(i);
		}
		if (word1.equals(word3)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		return;
	}

}
