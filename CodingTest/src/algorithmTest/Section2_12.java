package algorithmTest;

import java.util.Scanner;

public class Section2_12 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String result = in.nextLine();
		String[] arr = result.split(" ");
		int tot = Integer.parseInt(arr[0]);
		int row = Integer.parseInt(arr[1]);
		String[] sarr = new String[row];
		
		for (int i = 0; i < row; i++) {
			sarr[i]=in.nextLine();
		}
		int[] iarr = new int[tot];
		for (int i = 0; i < row; i++) { // 3번 행개수 
			String[] tarr = sarr[i].split(" ");
			for (int j = 0; j < tot; j++) { // 4번 행의 열 개수 
				int var = Integer.parseInt(tarr[j]);
				if(i==0) {
					iarr[var-1] = tot-j-1;
				}else if (iarr[var-1]>tot-j-1) {
					iarr[var-1] = tot-j-1;
				}
			}
		}
		int sum=0;
		for(int x : iarr) {
			sum+=x;
		}
		System.out.println(sum);
	}

}
