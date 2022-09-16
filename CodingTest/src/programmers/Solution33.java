package programmers;

public class Solution33 {
	class Solution {
		public int solution(int num) {
			int answer = 0;
			long n = num;

			if (n == 0) {
				answer = 0;

			} else {
				while (n != 1) {
					if (answer == 500) {
						answer = -1;
						break;
					} else {
						if (n % 2 == 0) {
							n /= 2;
						} else {
							n = (n * 3) + 1;
						}

					}
					answer++;
				}
			}
			return answer;
		}
	}

}
