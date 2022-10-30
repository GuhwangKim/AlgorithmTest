package algorithmTest;

import java.util.Scanner;

public class Section2_8 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.nextLine();
		String str = in.nextLine();
		String[] arr = str.split(" ");
		
		int[] iarr = new int[arr.length];
		int[] rarr = new int[arr.length];
		
		
		for (int i = 0; i < iarr.length; i++) {
			iarr[i]=Integer.parseInt(arr[i]);
		}
		for (int i = 0; i < iarr.length; i++) {
			int rank = 1;
			for (int j = 0; j < iarr.length; j++) {
				if(iarr[i]<iarr[j]) {
					rank++;
				}
			}
			rarr[i]=rank;
		}
		for(int r : rarr) {
			System.out.print(r+" ");
		}
		return;
	}

}
