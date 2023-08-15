package programmers_lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution31 {

	List<List<Integer>> list; // roads�� ������ ��� ����
	int[] arr; // ���Ƿ� ���� �迭�ν�, ����
	final int max = Integer.MAX_VALUE;

	public int[] solution(int n, int[][] roads, int[] sources, int destination) {

		list = new ArrayList<>(); // �ʱ�ȭ

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>()); // ������ ���̸�ŭ list�� �Ҵ� ��
		}

		for (int[] road : roads) {
			int startNum = road[0];
			int endNum = road[1];

			list.get(startNum).add(endNum);
			list.get(endNum).add(startNum);
			// ����� ������ ǥ��, ���� �� ���� ����

		}

		arr = new int[n + 1];
		// ������ ���� ������ �ִ� �迭
		// �������� ����� ������ ����ġ�� ������
		Arrays.fill(arr, max);
		// arr�� ��� ���� �켱 ���� ū ���� �������
		dijkstra(destination);
		int[] answer = new int[sources.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = (arr[sources[i]] < max) ? arr[sources[i]] : -1;
			// source�� �ִ� ������ arr�� �ִ� ���, default ���� max ���� �۴ٸ� ����Ǿ��ٴ� ��
			// source�� �ش��ϴ� arr ���� ��ȯ
			// max �ΰ�쿣 ���� �� �Ǿ����Ƿ� -1 ��ȯ 
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
				// �������� ����� �����鸸ŭ ����
				int cnntedAtDes = list.get(des).get(i);
				// �������� ����� �������� �ϳ��� ����
				if (arr[cnntedAtDes] > arr[des] + 1) {
					// ������ �Ǿ��ٸ�
					arr[cnntedAtDes] = arr[des] + 1;
					// �ϳ� ���� (����ġ)
					queue.add(cnntedAtDes);
					// ���� ���� ����� ���� ã��
				}
			}
		}

	}

}
