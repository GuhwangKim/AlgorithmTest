package algorithmTest;

import java.util.Scanner;

public class Section1_5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		String sum1 = "";
		String sum2 = "";
		String[] arr1 = str.split("[a-zA-Z]"); // 특수문자
		String[] arr2 = str.split("[!@#$%^&*(),.?\\\":{}|<>]"); // 문자
		for(String a : arr1) {
			sum1+=a;
		}
		for(String b : arr2) {
			sum2+=b;
		}
		int x = sum2.length()-1;
		int y = 0;
		String[] arr3 = new String[str.length()]; // 새로 만들것
		for (int i = 0; i < arr3.length; i++) {
			if(str.charAt(i)>='a'&&str.charAt(i)<='z'||str.charAt(i)>='A'&&str.charAt(i)<='Z') {
				arr3[i]=String.valueOf(sum2.charAt(x));
				x--;
			} else {
				arr3[i]=String.valueOf(sum1.charAt(y));
				y++;
			}
		}
		
		for(String z : arr3) {
			System.out.print(z);
		}
		return;
	}

}
