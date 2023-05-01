package programmers_kit.Search;

import java.util.HashSet;

public class Search1 {
	static HashSet<Integer> set = new HashSet<Integer>();
	static String numbsersUse;
	static boolean[] visited;

	public int solution(String numbers) {
		int answer = 0;
		numbsersUse = numbers;
		visited = new boolean[numbers.length()];
		for (int i = 0; i < numbers.length(); i++) {
			visited[i] = true;
			DFS(i, String.valueOf(numbers.charAt(i)));
			visited[i] = false;
			// ���̿� ��
		}
		answer = set.size();
		for(int a : set) {
			System.out.println(a);
		}
		return answer;
	}

	// 1. �Ҽ��� Ȯ���ϴ� �޼ҵ�
	public static boolean isPrime(int num) {
		if(num==1||num==0) return false;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	// 2. ����
	public void DFS(int idx, String idxNum) {
		// �ڸ��� 0, �� �ڸ����� �� 1 �� �Ѿ��
		// �ڸ��� 1, �� �ڸ����� �� 7 �� �Ѿ�� 
		if (idxNum.length() > numbsersUse.length()) {
			// 1) �þ�� ���� �־��� ���� ���̸� ������ �ȵ�
			return;
		}
		if (isPrime(Integer.parseInt(idxNum))) {
			set.add(Integer.parseInt(idxNum));
			// 2) �Ѿ�� ����

		}

		for (int i = 0; i < numbsersUse.length(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				// 3) �ڸ��� - �湮�ߴٸ� ǥ��
				DFS(i, idxNum + numbsersUse.charAt(i));
				visited[i] = false;
				// Ǯ����
			}
		}

	}

}
