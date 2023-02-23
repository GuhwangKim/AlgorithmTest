package algorithmTest;

import java.util.Scanner;

public class Section8_7 {
	
	int[][] dy = new int[35][35];
	private int DFS(int a, int b) {
		if(dy[a][b]>0) {
			return dy[a][b];
		}
		if(a==b || b==0) {
			return 1; 
		}else {
			return dy[a][b]=DFS(a-1, b-1)+DFS(a-1,b);
		}
	}
	public static void main(String[] args) {
		Section8_7 T = new Section8_7();
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int rnum = in.nextInt();
		System.out.println(T.DFS(num, rnum));
	}

}
