package algorithmTest;

import java.util.Scanner;

public class Section8_1 {
	static String answer = "NO";
	static int n, total = 0;
	boolean flag = false;
	int sum = 0;
	
	private void DFS(int L, int sum, int[] arr) {
		if(flag) return; 
		// 아래 명령을 실행하지 않고, 스텍에 쌓인 것들로 가서 계속 리턴 
		if(sum>total/2) return; 
		// 이미 섬이 커버리면 다 리턴 
		if(L==n) { 
		//L은 0부터 시작, 6까지 갔다면 (부분집합 완성)  
			if((total-sum)==sum) {
				answer ="YES";
				flag = true;
			}
		}else {
			// 2갈래로 뻗어나감 
			DFS(L+1, sum+arr[L], arr);
			DFS(L+1, sum, arr);
		}
	}
	
	
	public static void main(String[] args) {
		Section8_1 T = new Section8_1();
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=in.nextInt();
			total+=arr[i];
		}
		T.DFS(0, 0, arr);
		System.out.println(answer);
	}

}
