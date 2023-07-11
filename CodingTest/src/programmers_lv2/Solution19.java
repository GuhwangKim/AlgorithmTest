package CodingTest.src.programmers_lv2;

import java.util.HashSet;

public class Solution19 {
	

	public int solution(int x, int y, int n) {
		int answer = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<Integer> next = null;
		set.add(x);
		// x의 값을 집어 넣고 이것이 y가 될때까지
		while (!set.isEmpty()) {
			if (set.contains(y)) {
				return answer;
			}
			
			next = new HashSet<Integer>();
			// 루프를 돌때마다 매번 새롭게 set 객체를 만듦 
			for(int var : set) {
				if(var+n<y) {
					next.add(var+n);
				}
				if(var*2<y) {
					next.add(var*2);
				}
				if(var*3<y) {
					next.add(var*3);
				}
				
			}
			set = next;
			// 검증의 기준이 되는 set 이 바뀜 (위에 검증으로 set 에는 목표값이 없다는 것을 확인했으므로) 
			answer++;
			// 횟수를 증가시킴 
		}

		return -1;
	}

}
