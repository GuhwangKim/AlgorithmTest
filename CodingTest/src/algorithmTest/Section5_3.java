package algorithmTest;

import java.util.Scanner;
import java.util.Stack;

public class Section5_3 {
	
	private int T(int[][] arr, int[] marr) {
		int answer = 0;
		
		Stack<Integer> stack = new Stack<>();
		
		for(int x : marr) {
			for (int i = 0; i < arr.length; i++) {
				if(arr[i][x-1]!=0) {
					if(stack.isEmpty()) {
						stack.add(arr[i][x-1]);
						arr[i][x-1]=0;
						break;
					}else {
						if(stack.peek()==arr[i][x-1]) {
							stack.pop();
							arr[i][x-1]=0;
							answer+=2;
							break;
						}else {
							stack.add(arr[i][x-1]);	
							arr[i][x-1]=0;
							break;
						}
					}
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args){
		Section5_3 section = new Section5_3();
	    Scanner in=new Scanner(System.in);
	    int n = in.nextInt();
	    in.nextLine();
	    int[][] arr = new int[n][n];
	    for (int i = 0; i < n; i++) {
			String s1 = in.nextLine();
			String[] sarr1 = s1.split(" ");
			for (int j = 0; j < sarr1.length; j++) {
				arr[i][j]=Integer.parseInt(sarr1[j]);
			}
		}
	    int m = in.nextInt();
	    in.nextLine();
	    String s2 = in.nextLine();
	    String[] sarr2 = s2.split(" ");
	    int[] marr = new int[m];
	    for (int i = 0; i < marr.length; i++) {
			marr[i] = Integer.parseInt(sarr2[i]);
		}
	    System.out.println(section.T(arr, marr));
	  }

}
