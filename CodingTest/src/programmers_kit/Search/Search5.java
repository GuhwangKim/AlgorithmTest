package programmers_kit.Search;

public class Search5 {
	static int count =0;
	static boolean finalEnd = false;
	char[] aeiou = { 'A', 'E', 'I', 'O', 'U' };

	public int solution(String word) {
		DFS("", word, 0);

		return count;
	}

	public  void DFS(String cbnAlphabet, String givenWord, int depth) {
		// 알파벳, 주어진수, 현재 노드, 몇번째인지 카운트 하는 것을 넘김
		// 이젠 아래로 내려가면서 문자를 만들 예정
		// 가장 처음엔 공란과 카운트 0을 넣어서 보냄

		// 끝까지 내려와도 끝
		if (depth == 6) {
			return;
		}

		// 주어진 수와 같다면 종료, 완전끝 => 태그 달아줌
		if (givenWord.equals(cbnAlphabet)) {
			finalEnd = true;
			return;
		}

		for (int i = 0; i < aeiou.length; i++) {
			if (finalEnd)
				return;
			if(depth + 1 < 6) count++;
			DFS(cbnAlphabet + aeiou[i], givenWord, depth + 1);
		}

	}
}
