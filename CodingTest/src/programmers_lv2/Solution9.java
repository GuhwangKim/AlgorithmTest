package CodingTest.src.programmers_lv2;

import java.util.*;

public class Solution9 {
	public int[] solution(int[] sequence, int k) {
		int leftIdx = 0;
		int rightidx = 0;
		int partSum = sequence[0];
		// 현자의 합

		int length = sequence.length;
		List<Integer> list = new LinkedList<>();

		while (true) {
			if (partSum == k) {
				// 1. 현재의 합이 주어진 k와 같아면 왼쪽 오른쪽의 인덱스를 삽입
				list.add(leftIdx);
				list.add(rightidx);
			}

			if (list.size() == 4) {
				// 2. 합이 같은 인덱스가 복수개일때
				if (list.get(1) - list.get(0) < list.get(3) - list.get(2)) {
					list.remove(2);
					list.remove(2);
				} else if (list.get(1) - list.get(0) > list.get(3) - list.get(2)) {
					list.remove(0);
					list.remove(0);
				} else {
					// 3. 길이도 같으면 먼저 들어온 것
					list.remove(2);
					list.remove(2);
				}
			}
			if (leftIdx == length && rightidx == length) {
				// 4. 두 인덱스가 끝에 도달
				break;
			}
			if (partSum <= k && rightidx < length) {
				// 5. 아직 부분합이 작고, 끝 인덱스가 남았다면 끝 인덱스 한칸 옆으로
				rightidx++;
				partSum += sequence[rightidx];
			} else {
				// 6. 부분 합이 k를 넘어가면
				if (leftIdx < length) {
					partSum -= sequence[leftIdx];
					leftIdx++;
				}
			}

		}
		return new int[] {list.get(0), list.get(1)};
	}
}
