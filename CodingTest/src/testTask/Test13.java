package testTask;

import java.util.Scanner;

public class Test13 {
	
	public static void main(String[] args) {
		int r;
		
		Scanner sc=new Scanner(System.in);
		System.out.print("���� �Է�"); r=sc.nextInt();
		
		if(r%4==0 && r%100!=0 || r%400==0) {
			System.out.println("����");
		} else {
			System.out.println("���");
		}
	}
	
	

}
