package algorithmTest;

import java.util.Scanner;

public class Section2_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] arr = new int[num];
		
		for (int i = 0; i < num; i++) {
			int x = in.nextInt();
			arr[i]=x;
		}
		for (int i = 0; i < num; i++) {
			if(i==0) {
				System.out.print(arr[0]+" ");
			} else if (arr[i]>arr[i-1]) {
				System.out.print(arr[i]+" ");
			} else {
				continue;
			}
		}
	}

}
