package programmers_lv2;

public class Solution4 {
	static class Solution {
		public int solution(int n, int k) {
			int answer = 0;
			String x = "";

			while (n != 0) {
				x = n % k + x;
				n /= k;
			}

			String[] sp = x.split("0");

			for (int i = 0; i < sp.length; i++) {
				if (sp[i].isEmpty()) {
					continue;
				}
				if (isPrime(Long.parseLong(sp[i]))) {
					answer++;
				}
			}
			return answer;
		}

		public boolean isPrime(long n) {
			if (n < 2) {
				return false;
			}
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}

	}
}
