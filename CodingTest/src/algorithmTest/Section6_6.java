package algorithmTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Section6_6 {

	private List<Integer> T(int a, int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		int[] tmp = new int[a];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i]=arr[i];
		}
		Arrays.sort(tmp);
		for (int i = 0; i < tmp.length; i++) {
			if(arr[i]!=tmp[i]) {
				list.add(i+1);
			}
		}
		
		return list;
	}

	public static void main(String[] args) {
		Section6_6 section = new Section6_6();
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int[] arr = new int[a];
		in.nextLine();
		String str = in.nextLine();
		String[] sarr = str.split(" ");
		for (int i = 0; i < sarr.length; i++) {
			arr[i] = Integer.parseInt(sarr[i]);
		}
		for (int x : section.T(a, arr)) {
			System.out.print(x+" ");
		}
	}
}
