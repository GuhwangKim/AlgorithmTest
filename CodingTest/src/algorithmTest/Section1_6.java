package algorithmTest;

import java.util.Scanner;

public class Section1_6 {
	public static void main(String[] args){
	    Scanner in=new Scanner(System.in);
	    String str = in.next();
	    String[] s = new  String[str.length()];
	    
	    for (int i = 0; i < str.length(); i++) {
			s[i]=String.valueOf(str.charAt(i));
		}
	    for (int i = 0; i < s.length; i++) {
			for (int j = i+1; j < s.length; j++) {
				if(s[i].equals(s[j])) {
					s[j]="";
				}
			}
		}
	    for(String a : s) {
	    	System.out.print(a);
	    }
	    return ;
	  }

}
