package algorithmTest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Section2_9 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[][] arr = new int[num][num];
		in.nextLine();
		for (int i = 0; i < num; i++) {
			String str = in.nextLine();
			String[] sarr = str.split(" ");
			for (int j = 0; j < num; j++) {
				arr[i][j]=Integer.parseInt(sarr[j]);
			}
		}
		Set<Integer	> set = new HashSet<Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			int sumh =0;
			int sumv = 0;
			for (int j = 0; j < arr.length; j++) {
				sumh+=arr[i][j];
				sumv+=arr[j][i];
			}
			set.add(sumh);
			set.add(sumv);
		}
		int sumr = 0;
		for (int i = 0; i < arr.length; i++) {
			sumr+=arr[i][i];
			set.add(sumr);
		}
		int suml = 0;
		for (int i = arr.length-1; i >= arr.length; i--) {
			suml+=arr[i][i];
			set.add(suml);
		}
		Iterator<Integer> itr = set.iterator();
		int max = 0;
		for (int i = 0; i < set.size(); i++) {
			if(itr.hasNext()) {
				int comp = itr.next();
				if(comp>max) {
					max = comp;
				}
			}
		}
		System.out.println(max);
		return;
	}

}
