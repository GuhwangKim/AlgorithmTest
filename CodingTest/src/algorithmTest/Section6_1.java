package algorithmTest;

import java.util.Scanner;

public class Section6_1 {

	private int[] T(int a, int[] arr) {
		for (int i = 0; i < a-1; i++) {
			for (int j = 0; j < a-1-i; j++) {
				if(arr[j+1]<arr[j]) {
					// ½º¿ÍÇÁ 
					int standard = arr[j];
					arr[j]=arr[j+1];
					arr[j+1] = standard;
				}
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		Section6_1 section = new Section6_1();
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		in.nextLine();
		String str2 = in.nextLine();
		String[] sarr = str2.split(" ");
		int[] arr = new int[a];
		for (int i = 0; i < sarr.length; i++) {
			arr[i]=Integer.parseInt(sarr[i]);
		}
		for(int x : section.T(a, arr)) {
			System.out.print(x+" ");
		}
	}
}
