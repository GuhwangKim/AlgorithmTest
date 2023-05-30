package programmers_kit.Greedy;

import java.util.Arrays;

public class Greedy4 {
	static int[] parent;

	public int solution(int n, int[][] costs) {
		int answer = 0;

		// 1. costs 배열에서 짧은 비용을 기준으로 정렬 (오름차순)
		Arrays.sort(costs, (int[] a1, int[] a2) -> a1[2] - a2[2]);
		// 2. 노드별 부모 노드를 기록하는 배열을 생성
		parent = new int[n];
		// 3. 그 안에 각 노드 값에 자신의 값을 집어넣음 (가장 끝을 의미함)
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		// 4. 각 배열에 들어있는 시작 숫자와 그 방향에 있는 숫자, 비용 을 뽑아냄
		for (int[] row : costs) {
			int startNum = row[0];
			int endNum = row[1];
			int cost = row[2];

			// 5. 노드의 값을 부모의 노드를 찾는 메소드에 담아서 부모 노드의 값을 찾음
			int startNumsParent = findParentNum(startNum);
			int endNumsParent = findParentNum(endNum);

			// 7. 시작점과 끝점의 부모값이 같으면 연결 안하고 건너뜀
			if (startNumsParent == endNumsParent) {
				continue;
			} else {
				// 8. 다르면 연결하고 비용에 추가함
				answer += cost;
				// 9. 방향에 있는 숫자의 부모 값은 이제 시작점이 됨 
				// => 이럼에 따라서 가장 상위를 기준으로 계속해서 연결되게 됨 
				parent[endNumsParent] = startNum;
			}

		}

		return answer;
	}

	private int findParentNum(int nodesNum) {
		// 6. 자기 자신, 즉 연결해서 끝까지 타고 들어가서, 끝에 있는 자기 자신을 찾을 때까지 반복
		if (parent[nodesNum] == nodesNum) {
			return nodesNum;
		} else {
			// 7. 만약에 끝이 아니라면 계속 찾을 때까지 들어감
			return parent[nodesNum] = findParentNum(parent[nodesNum]);
		}
	}

}
