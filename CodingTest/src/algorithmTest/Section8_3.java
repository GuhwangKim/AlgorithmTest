package algorithmTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Section8_3 {
	static class Tree {
		int prob;
		int minute;
	}

	static int max = Integer.MIN_VALUE, m, n;

	private static void DFS(int num, int limit, int total, List<Tree> list) {
		// 깊이, sum , time, 배열 
		if (limit > m) {
			return;
		}
		if(total>max) {
			max=total;
		}
		if (num == n) {
			max = Math.max(max, total);
		} else {
			DFS(num + 1, limit + list.get(num).minute, total + list.get(num).prob, list);
			DFS(num + 1, limit, total, list);
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); // 문제
		m = in.nextInt(); // 제한 시간
		List<Tree> list = new ArrayList<Tree>();
		for (int i = 0; i < n; i++) {
			Tree tree = new Tree();
			tree.prob = in.nextInt();
			tree.minute = in.nextInt();
			list.add(tree);
		}
		DFS(0, 0, 0, list);
		System.out.println(max);
	}
}
