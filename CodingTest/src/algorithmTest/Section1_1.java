package algorithmTest;

import java.util.Scanner;

public class Section1_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input1 = in.nextLine();
		String input2 = in.nextLine();
		
		char i2 = input2.toUpperCase().charAt(0);
		char i3 = input2.toLowerCase().charAt(0);

		int cnt = 0;
		for (int i = 0; i < input1.length(); i++) {
			if (input1.charAt(i) == i2 ||input1.charAt(i) == i3 ) {
				cnt++;
			}
		}

		System.out.println(cnt);
		return;
	}

}
