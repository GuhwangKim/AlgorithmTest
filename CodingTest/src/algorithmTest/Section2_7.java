package algorithmTest;

import java.util.Scanner;

public class Section2_7 {
	public static void main(String[] args){
	    Scanner in=new Scanner(System.in);
	    int tot = in.nextInt();
	    in.nextLine();
	    String result = in.nextLine();
	   	String[] arr = result.split(" ");
	   	int num = 0;
	   	int sum = 0;
	   for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals("1")) {
				num++;
				sum+=num;
			}else {
				num=0;
				sum+=num;
			}
	   }
	   System.out.println(sum);
	  }
}
