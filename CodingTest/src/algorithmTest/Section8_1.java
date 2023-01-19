package algorithmTest;

import java.util.Scanner;

public class Section8_1 {
	static int[] ch;
	static int[] arr;
	static String answer = "NO";
	static int num = 0;
	static int total;
	int sum = 0;
	
	private void DFS(int i) {
		sum +=arr[i];
		while (num<arr.length) {
			if(sum==(total-sum)) {
				answer = "YES";
				break;
			} else {
				for (int j = 1; j <= arr.length; j++) {
					if(ch[j]==0) {
						ch[j]=1;
						DFS(j);
						ch[j]=0;
						sum-=arr[j];
					}
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) {
		Section8_1 T = new Section8_1();
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		arr = new int[a];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=in.nextInt();
			total+=arr[i];
		}
		ch = new int[a+1];
		ch[1]=1;
		T.DFS(0);
	}

}
