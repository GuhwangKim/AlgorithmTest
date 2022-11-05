package algorithmTest;

import java.util.Scanner;

public class Section2_10 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.nextLine();
		String[] sarr = new String[num];
		for (int i = 0; i < num; i++) {
			sarr[i] = in.nextLine();
		}
		int[][] iarr = new int[num+2][num+2];
		for (int i = 1; i < iarr.length-1; i++) {
			String[] narr =sarr[i-1].split(" ");
			for (int j = 1; j < iarr.length-1; j++) {
				iarr[i][j]=Integer.parseInt(narr[j-1]);
			}
		}
		int cnt = 0;
		for (int i = 1; i < iarr.length-1; i++) {
			for (int j = 1; j < iarr.length-1; j++) {
				int var = iarr[i][j];
				if(var>iarr[i-1][j]&&var>iarr[i+1][j]&&var>iarr[i][j-1]&&var>iarr[i][j+1]) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
