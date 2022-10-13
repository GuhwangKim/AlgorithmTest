package algorithmTest;

import java.util.Scanner;

public class Section1_10 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		String t = in.next();
		String[] nstr=new String[str.length()];
		
		for (int i = 0; i < str.length(); i++) {
			String st=String.valueOf(str.charAt(i));
			if(st.equals(t)) {
				nstr[i]="0";
				for (int j = 1; j < i+1; j++) {
					if(i>=j) {
						nstr[i-j]=String.valueOf(j);
					}
					if(i+j<str.length()) {
						nstr[i+j]=String.valueOf(j);
					}
				}
			}
		}
		
		System.out.println(nstr);
		
		return;
	}

}
