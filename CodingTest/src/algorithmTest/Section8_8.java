package algorithmTest;

import java.util.Scanner;

public class Section8_8 {
	static int[] b, p, ch;
	static int n, f;
	boolean flag = false;
	int [][] dy = new int[35][35];
	public int combi(int n, int r) { // ������ ���ؼ� �迭�� ���� 
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
		// �ٷ� ���� 
		if(L==n) {
			if(sum==f) {
				for(int x : p) {
					System.out.println(x+" ");
					flag = true;// �ٸ� ��͵��� ���ֱ� ���ؼ� 
				}
			}
		}else {
			for (int i = 1; i <= n; i++) { // ������ ����� �� �� ��ü 
				if(ch[i]==0) { // ����ߴ�?
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
	    b = new int[n]; //������ ���� �迭
	    p = new int[n]; // ���� ���� �迭 
	    ch = new int[n+1];
	    for (int i = 0; i < n; i++) {
			b[i] = T.combi(n-1,i); // ���� 
		}
	  }



}
