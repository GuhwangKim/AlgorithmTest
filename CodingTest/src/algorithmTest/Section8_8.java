package algorithmTest;

import java.util.Scanner;

public class Section8_8 {
	static int[] b, p, ch;
	static int n, f;
	boolean flag = false;
	int [][] dy = new int[35][35];
	public int combi(int n, int r) { // 순열을 구해서 배열에 담음 
		if(dy[n][r]>0) {
			return dy[n][r];
		}
		if(n==r||r==0) {
			return 1;
		}else {
			return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
		}

	}
	public void DFS(int L, int sum) {
		if(flag) return; 
		// 바로 리턴 
		if(L==n) {
			if(sum==f) {
				for(int x : p) {
					System.out.println(x+" ");
					flag = true;// 다른 재귀들을 없애기 위해서 
				}
			}
		}else {
			for (int i = 1; i <= n; i++) { // 순열을 만드는 값 그 자체 
				if(ch[i]==0) { // 사용했니?
					ch[i]=1;
					p[L]=i;
					DFS(L+1, sum+(p[L]*b[L]));
					ch[i]=0;
				}
			}
		}
	}
	
	public static void main(String[] args){
		Section8_8 T = new Section8_8();
	    Scanner in=new Scanner(System.in);
	    n = in.nextInt(); ///4
	    f = in.nextInt();
	    b = new int[n]; //순열을 담을 배열
	    p = new int[n]; // 값을 담을 배열 
	    ch = new int[n+1];
	    for (int i = 0; i < n; i++) {
			b[i] = T.combi(n-1,i); // 순열 
		}
	  }



}
