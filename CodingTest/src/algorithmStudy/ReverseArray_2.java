package algorithmStudy;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray_2 {
	static void swap (int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	static void reverse(int[] a) {
		for (int i = 0; i < a.length/2; i++) {
			swap(a, i , a.length-i-1);
			System.out.println("a["+i+"]�� a["+(a.length-i-1)+"] �� ��ȯ�մϴ�");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int[] x = new int[num];
		
		for (int i = 0; i < x.length; i++) {
			x[i]=sc.nextInt();
		}
		
		reverse(x);
		System.out.println(Arrays.toString(x));
		System.out.println("���������� ���ƽ��ϴ�");
	}
	
	
}
