package CodingTest.src.programmers_lv2;

public class Solution24 {
	public int solution(int storey) {
		int answer = 0;
		// 자리수대로 숫자를 들고 나와서 그만큼 더해주면 됨
		// 자기보다 앞에 있는 자리수에 +1 을 하면 됨
		// 배열을 만드는 방법
		String numToString = String.valueOf(storey);
		int[] nums = new int[numToString.length()];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = numToString.charAt(i) - '0';
		}

		// 끝자리부터
		for (int i = nums.length - 1; i >= 0; i--) {

			if (nums[i] > 5) {
				answer += (10 - nums[i]);
				// 바로 앞자리 수를 하나 더해줘야함
				if (i == 0) {
					// 바로 앞자리가 없는 경우
					answer++;
					// 0을 하나 더 붙인 값 한번만 추가하면 됨
				} else {
					nums[i - 1]++;
				}

			} else if (nums[i] == 5 && nums[i-1]>=5) {
				// 앞의 수가 5 이상인 경우에
				nums[i-1]++;
				// 앞에는 한번더 누르고 아래로 내려오는 게 나음 
				answer += nums[i];

			} else {
				answer += nums[i];

			}
		}

		return answer;
	}
}
