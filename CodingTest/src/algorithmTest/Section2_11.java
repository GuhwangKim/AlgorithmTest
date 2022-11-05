package algorithmTest;

import java.util.Scanner;

public class Section2_11 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.nextLine();
		String[] sarr = new String[num];
		for (int i = 0; i < num; i++) {
			sarr[i] = in.nextLine();
		}
		int[][] iarr = new int[num][num];
		for (int i = 0; i < num; i++) {
			String[] narr = sarr[i].split(" ");
			for (int j = 0; j < num; j++) {
				iarr[i][j] = Integer.parseInt(narr[j]);
			}
		}
		int max = Integer.MIN_VALUE;
		int idx = num;
		for (int i = 0; i < num; i++) { // 학생 
			int cnt = 0;
			for (int j = 0; j < num; j++) { // 행 
				for (int j2 = 0; j2 < iarr.length; j2++) { //열 
					if (iarr[i][j] == iarr[j2][j]) {
						cnt++;
					}
				}
			}
			if (cnt > max) {
				max = cnt;
				idx = i;
			} 
		}
		System.out.println(idx+1);
	}

}
