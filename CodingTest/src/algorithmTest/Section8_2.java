package algorithmTest;

import java.util.Scanner;

public class Section8_2 {

	static int max = Integer.MIN_VALUE, m, n;

	private void DFS(int num, int total, int[] arr) {
		if (total > m) { // 1. 합이 주어진 최대 값보다 큰 경우 리턴 max 반영 안함 
			return;
		}
		if (num == n) { // 2. 가장 마지막 끝까지 내려왔을 때 배열의 사이즈
			max = Math.max(max, total);
			// total > max && total < m
		} else {
			DFS(num + 1, total + arr[num], arr);
			DFS(num + 1, total, arr); // 1-2 앞으로 당겨짐
		}
	}

	public static void main(String[] args) {
		Section8_2 T = new Section8_2();
		Scanner in = new Scanner(System.in);
		m = in.nextInt();
		n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		T.DFS(0, 0, arr);
		System.out.println(max);
	}
}
