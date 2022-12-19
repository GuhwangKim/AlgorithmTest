package algorithmTest;

import java.util.ArrayList;
import java.util.Scanner;


public class Section3_1 {
	
	public ArrayList<Integer> solution(int a, int b, int[] arr1, int[] arr2){
		ArrayList<Integer> answer = new ArrayList<Integer>();
		int p = 0, q=0;
		while(p<a && q<b) {
			if(arr1[p]<arr2[q]) {
				answer.add(arr1[p++]);
			}else {
				answer.add(arr2[q++]);
			}
		}
		// 큰 값이 남아있는 배열들 마저 붙여주기 
		while(p<a) answer.add(arr1[p++]);
		while(q<b) answer.add(arr2[q++]);
		
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
		Section3_1 T = new Section3_1();
		
		for(int num : T.solution(a, b, arr1, arr2)) {
			System.out.print(num+" ");
		}
		
	}

}
