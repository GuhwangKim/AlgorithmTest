package algorithmTest;

import java.util.Scanner;

public class Section2_3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] arr1 = new int[num];
		int[] arr2 = new int[num];
		
		for (int i = 0; i < num; i++) {
			arr1[i] = in.nextInt();
		}
		for (int i = 0; i < num; i++) {
			arr2[i] = in.nextInt();
		}
		
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i]==1) {
				if(arr2[i]==1) {
					System.out.println("D");
				} else if (arr2[i]==2) {
					System.out.println("B");
				} else {
					System.out.println("A");
				}
			}
			if(arr1[i]==2) {
				if(arr2[i]==2) {
					System.out.println("D");
				} else if (arr2[i]==3) {
					System.out.println("B");
				} else {
					System.out.println("A");
				}
			}
			if(arr1[i]==3) {
				if(arr2[i]==3) {
					System.out.println("D");
				} else if (arr2[i]==1) {
					System.out.println("B");
				} else {
					System.out.println("A");
				}
			}
		}
		
		return;
	}

}
