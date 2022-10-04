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
		return;
	}

}
