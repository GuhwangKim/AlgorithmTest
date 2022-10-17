package algorithmTest;

import java.util.Scanner;

public class Section1_12 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		String str = in.next();
		String st = "";
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='#') {
				st+="1";
			} else {
				st+="0";
			}
		}
		String answer = "";
		int length = str.length()/num;
		for (int i = 0; i <st.length()/length; i++) {
			// 글자의 길이가 됨 
			String s="";
			for (int j = 0; j <= 6; j++) {
				 s+=String.valueOf(st.charAt((i*7)+j));
				 // 7개씩 끊음 
			}
			int k = Integer.parseInt(s,2);
			char ch = (char)k;
			answer+=String.valueOf(ch);
		}
		System.out.println(answer);
		return;
	}

}
