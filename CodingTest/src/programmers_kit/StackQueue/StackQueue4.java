package programmers_kit.StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackQueue4 {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> queue = new LinkedList<>();

		int totalTime = 0;
		int currentBridgeWeight = 0;
		for (int i = 0; i < truck_weights.length; i++) {
			while (true) {
				if (queue.isEmpty()) {
					// 1. �ٸ��� ���� ���� ���
					queue.add(truck_weights[i]);
					// Ʈ���� ���Կ� ���� �ε����� ��� ��ü�� �������
					currentBridgeWeight += truck_weights[i];
					// ���� �ٸ� ���� �ִ� �ڵ����� ����
					totalTime++;
					// �ϳ� �ư� 1�� ����
					break;
				} else if (queue.size() == bridge_length) {
					// 2. �ٸ��� �������
					currentBridgeWeight -= queue.poll();
				} else {
					// 3. �ٸ��� ���� ������ ������ ���� ���
					
					// 4. ���Ѵ밡 �߰����� �� �ٸ��� �ִ� ���԰� ���� ���� �� 
					if(currentBridgeWeight+truck_weights[i]<=weight) {
						queue.add(truck_weights[i]);
						currentBridgeWeight+=truck_weights[i];
						totalTime++;
						break;
					}else {
						// 5. �ִ� ���԰� ���� �� 
						queue.add(0);
						totalTime++;
					}
				}
			}
		}
		return totalTime + bridge_length;
	}
}