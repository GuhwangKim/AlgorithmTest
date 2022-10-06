package algorithmTest;

import java.util.Scanner;

public class Section1_6 {
	public static void main(String[] args){
	    Scanner in=new Scanner(System.in);
	    String str = in.next();
	    char[] cha = new  char[str.length()];
	    for (int i = 0; i < str.length(); i++) {
			cha[i]=str.charAt(i);
		}
	    for (int i = 0; i < cha.length; i++) {
			for (int j = i+1; j < cha.length; j++) {
				if(cha[i]==cha[j]) {
					cha[j]='0';
				}
			}
		}
	    for(char a : cha) {
	    	if(a!='0') {
	    		System.out.print(a);
	    	}
	    }
	    return ;
	  }

}
