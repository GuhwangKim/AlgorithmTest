package programmers_lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution31 {

	List<List<Integer>> list; // roads의 정보를 담고 있음
	int[] arr; // 임의로 만든 배열로써, 가변
	final int max = Integer.MAX_VALUE;

	public int[] solution(int n, int[][] roads, int[] sources, int destination) {

		list = new ArrayList<>(); // 초기화

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>()); // 지역의 길이만큼 list가 할당 됨
		}

		for (int[] road : roads) {
			int startNum = road[0];
			int endNum = road[1];

			list.get(startNum).add(endNum);
			list.get(endNum).add(startNum);
			// 연결된 점들이 표시, 복수 값 저장 가능

		}

		arr = new int[n + 1];
		// 지역의 수를 가지고 있는 배열
		// 목적지와 연결된 노드들의 가중치가 더해짐
		Arrays.fill(arr, max);
		// arr의 모든 수를 우선 가장 큰 수로 집어넣음
		dijkstra(destination);
		int[] answer = new int[sources.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = (arr[sources[i]] < max) ? arr[sources[i]] : -1;
			// source에 있는 값들이 arr에 있는 경우, default 값인 max 보다 작다면 연결되었다는 뜻
			// source에 해당하는 arr 값을 반환
			// max 인경우엔 연결 안 되었으므로 -1 반환 
		}

		return answer;

	}

	private void dijkstra(int destination) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(destination);
		arr[destination] = 0;

		while (!queue.isEmpty()) {
			int des = queue.poll();

			for (int i = 0; i < list.get(des).size(); i++) {
				// 목적지에 연결된 지역들만큼 검증
				int cnntedAtDes = list.get(des).get(i);
				// 목적지에 연결된 지역들을 하나씩 뽑음
				if (arr[cnntedAtDes] > arr[des] + 1) {
					// 연결이 되었다면
					arr[cnntedAtDes] = arr[des] + 1;
					// 하나 연결 (가중치)
					queue.add(cnntedAtDes);
					// 다음 노드와 연결된 것을 찾음
				}
			}
		}

	}

}
