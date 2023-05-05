package programmers_kit.Greedy;

public class Greedy1 {
	public int solution(String name) {
		int answer = 0;
		int move = name.length() - 1;

		// 1) 위 아래로 움직임 원리 : 해당 글자의 - A / 전체에서 (해당글 - A) 더 짧은 쪽으로 올라감
		// 2) 인덱스 안의 값 중에, 그 다음값이 A 인 경우

		for (int i = 0; i < name.length(); i++) {
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i)+1);

			// 그 다음수가 A 라면 A의 마지막 위치 찾음
			int idxNext = i + 1;
			while (idxNext < name.length() && name.charAt(idxNext) == 'A') {
				idxNext++;
			}
			// i 지금까지 간 만큼 + 돌아감 + 가장 끝 - A의 마지막 만큼 감 +
			// 최종 모든 문자열까지 한다면 그때 최종 값이 나옴
			move = Math.min(move, i + Math.min(i,name.length() - idxNext) + (name.length() - idxNext));

		}

		return move + answer;
	}

}
