package programmers_kit;

import java.util.HashSet;
import java.util.Set;

public class Hash1 {
	public int solution(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		int answer = 0;
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		if ((nums.length / 2) > set.size()) {
			answer = nums.length / 2;
		} else {
			answer =set.size();
		}
		return answer;
	}

}
