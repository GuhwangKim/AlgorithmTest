package testTask;

import java.util.Scanner;

public class Test13 {
	
	public static void main(String[] args) {
		int r;
		
		Scanner sc=new Scanner(System.in);
		System.out.print("연도 입력"); r=sc.nextInt();
		
		if(r%4==0 && r%100!=0 || r%400==0) {
			System.out.println("윤년");
		} else {
			System.out.println("평년");
		}
	}
	
	

}
