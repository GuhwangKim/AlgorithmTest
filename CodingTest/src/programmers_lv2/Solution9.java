package CodingTest.src.programmers_lv2;

import java.util.*;

public class Solution9 {
	public int[] solution(int[] sequence, int k) {
		int leftIdx = 0;
		int rightidx = 0;
		int partSum = sequence[0];
		// ������ ��

		int length = sequence.length;
		List<Integer> list = new LinkedList<>();

		while (true) {
			if (partSum == k) {
				// 1. ������ ���� �־��� k�� ���Ƹ� ���� �������� �ε����� ����
				list.add(leftIdx);
				list.add(rightidx);
			}

			if (list.size() == 4) {
				// 2. ���� ���� �ε����� �������϶�
				if (list.get(1) - list.get(0) < list.get(3) - list.get(2)) {
					list.remove(2);
					list.remove(2);
				} else if (list.get(1) - list.get(0) > list.get(3) - list.get(2)) {
					list.remove(0);
					list.remove(0);
				} else {
					// 3. ���̵� ������ ���� ���� ��
					list.remove(2);
					list.remove(2);
				}
			}
			if (leftIdx == length && rightidx == length) {
				// 4. �� �ε����� ���� ����
				break;
			}
			if (partSum <= k && rightidx < length) {
				// 5. ���� �κ����� �۰�, �� �ε����� ���Ҵٸ� �� �ε��� ��ĭ ������
				rightidx++;
				partSum += sequence[rightidx];
			} else {
				// 6. �κ� ���� k�� �Ѿ��
				if (leftIdx < length) {
					partSum -= sequence[leftIdx];
					leftIdx++;
				}
			}

		}
		return new int[] {list.get(0), list.get(1)};
	}
}
