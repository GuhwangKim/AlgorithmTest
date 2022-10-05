package algorithmTest;

import java.util.Scanner;

public class Section1_3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input1 = in.nextLine();
		String[] arr = input1.split(" ");
		String max = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].length() < arr[i + 1].length()) {
				max = arr[i + 1];
			}
		}

		System.out.println(max);
		
		String answer="";
		int m = Integer.MIN_VALUE, pos;
		while((pos=input1.indexOf(' '))!=-1) {
			String tmp=input1.substring(0, pos);
			int len=tmp.length();
			if(len>m) {
				m=len;
				answer=tmp;
			}
			input1=input1.substring(pos+1);
		}
		if(input1.length()>m) {
			answer=input1;
		}
		
		return;
	}

}
