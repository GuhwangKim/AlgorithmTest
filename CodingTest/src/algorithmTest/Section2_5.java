
package algorithmTest;

import java.util.Scanner;

public class Section2_5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		int num = 0;
		int[] arr = new int[input+1];
		// 0부터 인덱스가 시작해서 19까지 담김, 20까지 담기려면 +1
		for (int i = 2; i <= input; i++) {
			if(arr[i]==0) {
				num++;
			}
			for (int j = i; j <= input; j+=i) {
				arr[j]=1;
			}
		}
		System.out.println(num);
	}
}
