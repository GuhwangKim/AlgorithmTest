package algorithmTest;

import java.util.Scanner;

public class Section1_9 {
	public static void main(String[] args){
	    Scanner in=new Scanner(System.in);
	    String str = in.next();
	    String[] arr = str.split("[a-zA-z]");
	    String s = "";
	    for (int i = 0; i < arr.length; i++) {
			if(arr[i].isEmpty()) {
				continue;
			} else {
				s+=arr[i];
			}
		}
	    System.out.println(Integer.parseInt(s));
	    return ;
	  }

}
