package algorithmTest;

import java.util.Arrays;
import java.util.Scanner;

public class Section6_5 {

	private String T(int a, int[] arr) {
		String answer = "U";
		Arrays.sort(arr);
		for (int i = 0; i < a-1; i++) {
			if(arr[i]==arr[i+1]) {
				return "D";
			} 
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Section6_5 section = new Section6_5();
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int[] arr = new int[a];
		in.nextLine();
		String str = in.nextLine();
		String[] sarr = str.split(" ");
		for (int i = 0; i < sarr.length; i++) {
			arr[i]=Integer.parseInt(sarr[i]);
		}
		System.out.println(section.T(a, arr));
	}
}
