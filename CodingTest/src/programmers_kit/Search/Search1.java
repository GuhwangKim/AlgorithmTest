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
			// 길이와 값
		}
		answer = set.size();
		for(int a : set) {
			System.out.println(a);
		}
		return answer;
	}

	// 1. 소수를 확인하는 메소드
	public static boolean isPrime(int num) {
		if(num==1||num==0) return false;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	// 2. 순열
	public void DFS(int idx, String idxNum) {
		// 자리수 0, 그 자리수의 값 1 이 넘어옴
		// 자리수 1, 그 자리수의 값 7 이 넘어옴 
		if (idxNum.length() > numbsersUse.length()) {
			// 1) 늘어나는 값이 주어진 값의 길이를 넘으면 안됨
			return;
		}
		if (isPrime(Integer.parseInt(idxNum))) {
			set.add(Integer.parseInt(idxNum));
			// 2) 넘어온 값을

		}

		for (int i = 0; i < numbsersUse.length(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				// 3) 자리수 - 방문했다면 표시
				DFS(i, idxNum + numbsersUse.charAt(i));
				visited[i] = false;
				// 풀어줌
			}
		}

	}

}
