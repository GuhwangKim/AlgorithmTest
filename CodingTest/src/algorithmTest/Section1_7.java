package algorithmTest;

import java.util.Scanner;

public class Section1_7 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		String yn="";
		str=str.toUpperCase();
		
		String[] st = new String[str.length()];
		for (int i = 0; i < str.length(); i++) {
			st[i]=String.valueOf(str.charAt(i));
		}
		if(st[0].equals(st[str.length()-1])) {
			yn="YES";
		}else {
			yn="NO";
		}
		System.out.println(yn);
		return;
	}

}
