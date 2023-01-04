package algorithmTest;

import java.util.Arrays;
import java.util.Scanner;

public class Section6_8 {

	private int T(int a, int b, int[] arr) {
		int answer = 0;
		Arrays.sort(arr);
		int mid = Math.round(a/2);
		if(arr[mid]==b) {
			answer = mid+1;
			return answer;
		} else if (arr[mid]<b) {
			for (int i = mid+1; i < a; i++) {
				if(arr[i]==b) {
					answer = i+1;
					return answer;
				} 
			}
		}else {
			for (int i = 0; i < mid; i++) {
				if(arr[mid]==b) {
					answer = i+1;
					return answer;
				} 
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Section6_8 section = new Section6_8();
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int[] arr = new int[a];
		int b = in.nextInt();
		in.nextLine();
		for (int i = 0; i < arr.length; i++) {
			arr[i]=in.nextInt();
		}
		System.out.println(section.T(a, b, arr));
	}
}
