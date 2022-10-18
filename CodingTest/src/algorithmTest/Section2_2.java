package algorithmTest;

import java.util.Scanner;

public class Section2_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {
			int x = in.nextInt();
			arr[i] = x;
		}

		int count = 0;
		int max = 0;
		for (int i = 0; i < num; i++) {
			if (i == 0) {
				count++;
				max = arr[0];
				continue;
			} else {
				if (arr[i] > arr[i - 1] && arr[i] > max) {
					max = arr[i];
					count++;
				} else {
					continue;
				}
			}
		}
		System.out.println(count);
	}
}
