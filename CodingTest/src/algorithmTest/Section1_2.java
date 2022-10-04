package algorithmTest;

import java.util.Scanner;

public class Section1_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input1 = in.nextLine();
		String sum="";
		for (int i = 0; i < input1.length(); i++) {
			char x = input1.charAt(i);
			if(x>=65&& x <=89) {
				x+=32;
				sum+=String.valueOf(x);
			} else {
				x-=32;
				sum+=String.valueOf(x);
			}
		}
		System.out.println(sum);
		return;
	}
}
