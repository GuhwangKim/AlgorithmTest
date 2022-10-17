package algorithmTest;

import java.util.Scanner;

public class Section1_11 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String str = in.next();
		String st = "";
		
		for (int i = 0; i < str.length(); i++) {
			int repeat = 0;
			for (int j = i; j < str.length(); j++) {
				if(str.charAt(i)==str.charAt(j)) {
					repeat++;
				} else {
					break;
				}
			}
			if(repeat>1) {
				st+=String.valueOf(str.charAt(i))+String.valueOf(repeat);
				i+=repeat-1;
			} else {
				st+=String.valueOf(str.charAt(i));
			}
		}
		System.out.println(st);
		return ;
	}
}
