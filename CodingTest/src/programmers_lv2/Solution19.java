package CodingTest.src.programmers_lv2;

import java.util.HashSet;

public class Solution19 {
	

	public int solution(int x, int y, int n) {
		int answer = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<Integer> next = null;
		set.add(x);
		// x�� ���� ���� �ְ� �̰��� y�� �ɶ�����
		while (!set.isEmpty()) {
			if (set.contains(y)) {
				return answer;
			}
			
			next = new HashSet<Integer>();
			// ������ �������� �Ź� ���Ӱ� set ��ü�� ���� 
			for(int var : set) {
				if(x<y) {
					next.add(x+n);
				}
				if(x<y) {
					next.add(x*2);
				}
				if(x<y) {
					next.add(x*3);
				}
				
			}
			set = next;
			// ������ ������ �Ǵ� set �� �ٲ� (���� �������� set ���� ��ǥ���� ���ٴ� ���� Ȯ�������Ƿ�) 
			answer++;
			// Ƚ���� ������Ŵ 
		}

		return -1;
	}

}
