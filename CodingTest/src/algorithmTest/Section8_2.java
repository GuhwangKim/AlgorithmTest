package algorithmTest;

import java.util.Scanner;

public class Section8_2 {

	static int max = Integer.MIN_VALUE, m, n;

	private void DFS(int num, int total, int[] arr) {
		if (total > m) { // 1. ���� �־��� �ִ� ������ ū ��� ���� max �ݿ� ���� 
			return;
		}
		if (num == n) { // 2. ���� ������ ������ �������� �� �迭�� ������
			max = Math.max(max, total);
			// total > max && total < m
		} else {
			DFS(num + 1, total + arr[num], arr);
			DFS(num + 1, total, arr); // 1-2 ������ �����
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
