package algorithmTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Section3_2 {
	private ArrayList<Integer> solution(int a, int b, int[] arr1, int[] arr2) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int p = 0, q = 0;
		
		while(p<a && q<b) {
			if(arr1[p]==arr2[q]) {
				answer.add(arr1[p++]);
				q++;
			}
			else if (arr1[p]<arr2[q]) {
				p++;
			} else {
				q++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int[] arr1 = new int[a];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i]=in.nextInt();
		}
		
		int b = in.nextInt();
		int[] arr2 = new int[b];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i]=in.nextInt();
		}
		Section3_2 T = new Section3_2();
		
		for(int num : T.solution(a, b, arr1, arr2)) {
			System.out.print(num+" ");
		}
		
	}

}
