package algorithmTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Section8_4 {
	static int n,m,answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Section8_4 S = new Section8_4();
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); // 동전 종류 개수
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr, Collections.reverseOrder());// 객체 형으로 
		m = in.nextInt(); // 거슬러 줘야하는 금액
		S.DFS(n, m,arr);
		System.out.println(answer);
		return;
	}

	private void DFS(int L, int sum, Integer[] arr) {
		if(sum>m) return; // 무한 방지 
		if(L>=answer) return; // 더 깊이 내려갈 필요 없음 
		if(sum==m) {
			answer = Math.min(answer, L);
			
		}else {
			for (int i = 0; i < n; i++) {
				DFS(L+1, sum+arr[i], arr);
			}
		}
	}

}
