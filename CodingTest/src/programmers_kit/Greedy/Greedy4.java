package programmers_kit.Greedy;

import java.util.Arrays;

public class Greedy4 {
	static int[] parent;

	public int solution(int n, int[][] costs) {
		int answer = 0;

		// 1. costs �迭���� ª�� ����� �������� ���� (��������)
		Arrays.sort(costs, (int[] a1, int[] a2) -> a1[2] - a2[2]);
		// 2. ��庰 �θ� ��带 ����ϴ� �迭�� ����
		parent = new int[n];
		// 3. �� �ȿ� �� ��� ���� �ڽ��� ���� ������� (���� ���� �ǹ���)
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		// 4. �� �迭�� ����ִ� ���� ���ڿ� �� ���⿡ �ִ� ����, ��� �� �̾Ƴ�
		for (int[] row : costs) {
			int startNum = row[0];
			int endNum = row[1];
			int cost = row[2];

			// 5. ����� ���� �θ��� ��带 ã�� �޼ҵ忡 ��Ƽ� �θ� ����� ���� ã��
			int startNumsParent = findParentNum(startNum);
			int endNumsParent = findParentNum(endNum);

			// 7. �������� ������ �θ��� ������ ���� ���ϰ� �ǳʶ�
			if (startNumsParent == endNumsParent) {
				continue;
			} else {
				// 8. �ٸ��� �����ϰ� ��뿡 �߰���
				answer += cost;
				// 9. ���⿡ �ִ� ������ �θ� ���� ���� �������� �� 
				// => �̷��� ���� ���� ������ �������� ����ؼ� ����ǰ� �� 
				parent[endNumsParent] = startNum;
			}

		}

		return answer;
	}

	private int findParentNum(int nodesNum) {
		// 6. �ڱ� �ڽ�, �� �����ؼ� ������ Ÿ�� ����, ���� �ִ� �ڱ� �ڽ��� ã�� ������ �ݺ�
		if (parent[nodesNum] == nodesNum) {
			return nodesNum;
		} else {
			// 7. ���࿡ ���� �ƴ϶�� ��� ã�� ������ ��
			return parent[nodesNum] = findParentNum(parent[nodesNum]);
		}
	}

}
