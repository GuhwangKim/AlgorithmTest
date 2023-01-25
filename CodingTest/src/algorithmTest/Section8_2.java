package algorithmTest;

import java.util.Scanner;

public class Section8_2 {

	static int n, m, total, max = 0;
	static int[] chk;

	public static void main(String[] args) {
		Section8_2 T = new Section8_2();
		Scanner in = new Scanner(System.in);
		m = in.nextInt();
		n = in.nextInt();
		in.nextLine();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
			in.nextLine();
		}
	}
}
