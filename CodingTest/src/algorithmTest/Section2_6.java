package algorithmTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Section2_6 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int inp = in.nextInt();
		String[] arr1 = new String[inp];
		String[] arr2 = new String[inp];
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < inp; i++) {
			arr1[i] = in.next();
		}
		for (int i = 0; i < inp; i++) {
			arr2[i]="";
			for (int j = arr1[i].length()-1; j >=0 ; j--) {
				arr2[i]+=arr1[i].charAt(j);
			}
		}
		for (int i = 0; i < inp; i++) {
			int num = Integer.parseInt(arr2[i]);
			if(num==2) {
				list.add(num);
				continue;
			}
			if(num==1) {
				continue;
			}
			boolean chk = true;
			for (int j = 2; j <num; j++) {
				if(num%j==0) {
					chk = false;
					break;
				}
			}
			if(chk==true) {
				list.add(num);
			}
		}
		for(int x : list) {
			System.out.print(x+" ");
		}
		return;
	}
}
