package algorithmTest;

import java.util.Scanner;

public class Section1_4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int val = in.nextInt();
		String[] str = new String[val] ;
		for (int i = 0; i < val; i++) {
			String sum = "";
			String input = in.next();
			for (int j = input.length()-1; j >= 0; j--) {
				sum+=String.valueOf(input.charAt(j));
			}
			str[i]=sum;
		}
		for(String p : str) {
			System.out.println(p);
		}
		return;
	}

}
