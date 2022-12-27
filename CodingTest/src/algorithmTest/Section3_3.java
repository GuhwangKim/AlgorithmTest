package algorithmTest;

import java.util.Scanner;


public class Section3_3 {
	
	public void solution(int n, int[]arr) {
		int answer = 0;
		int q = 0;
		while(q<=arr.length-n) {
			int sum =0;
			for (int i = 0; i < n; i++) {
				sum+=arr[q+i];
			}
			
			if(sum>answer) {
				answer = sum;
			}
			q++;
		}
		System.out.println(answer);
	}
	
	
	public static void main(String[] args){
	    Scanner in=new Scanner(System.in);
	    String a = in.nextLine();
	    String[] arr1 = a.split(" ");
	    String b = in.nextLine();
	    String[] arr2 = b.split(" ");
	    int[] arr = new int[arr2.length];
	    for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(arr2[i]);
		}
	    int day = Integer.parseInt(arr1[1]);
	    Section3_3 sec = new Section3_3();
	    sec.solution(day, arr);
	  }

}
