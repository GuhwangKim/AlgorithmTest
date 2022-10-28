package algorithmTest;

import java.util.Scanner;

public class Section2_4 {
	public static void main(String[] args){
	    Scanner in=new Scanner(System.in);
	    int input = in.nextInt();
	    int[] arr = new int[input];
	    arr[0]=1;
	    arr[1]=1;
	    for (int i = 2; i < input; i++) {
	    	arr[i]=arr[i-2]+arr[i-1];
		}
	    for(int i : arr) {
	    	System.out.print(i+" ");
	    }
	    
	    return ;
	  }

}
