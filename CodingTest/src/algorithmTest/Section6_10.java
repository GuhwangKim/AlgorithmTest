package algorithmTest;

import java.util.Arrays;
import java.util.Scanner;

public class Section6_10 {
	
	public int count(int[] arr, int distance) {
		// ¿ë·®À¸·Î ¸îÀåÀÌ ÇÊ¿äÇÑÁö 
		int cnt = 0, ep = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]-ep>=distance) {
				cnt++;
				ep = arr[i];
			}
		}
		return cnt;
	}
	
	private int T(int a, int b, int[] arr) {
		int answer = 0; 
		Arrays.sort(arr);
		int max = arr[a-1];
		int min = 1;
		
		while(min<=max) {
			int mid = (max+min)/2;
			if(count(arr, mid)>=b) {
				answer = mid;
				min = mid+1; // °£°İ ³ĞÈû
			} else {
				max = mid-1; // °£°İ Á¼Èû 
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Section6_10 section = new Section6_10();
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int[] arr = new int[a];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(section.T(a, b, arr));

	}

}
