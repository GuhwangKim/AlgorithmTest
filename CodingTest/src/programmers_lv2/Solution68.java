package CodingTest.src.programmers_lv2;

public class Solution68 {
	public int solution(int[][] triangle) {
		int answer = Integer.MIN_VALUE;
		for (int i = 1; i < triangle.length; i++) {
			// 렬1번쨰 꼭지는 제외하고 더해줌
			for (int j = 0; j < triangle[i].length; j++) {
				// 행
				if (j == 0) { // 왼쪽
					triangle[i][j] += triangle[i - 1][j]; //

				} else if (j == i) { // 오른쪽
					triangle[i][j] += triangle[i - 1][j - 1];
				} else {
					triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
				}
				answer = Math.max(answer, triangle[i][j]);
			}
		}

		return answer;
	}

}
