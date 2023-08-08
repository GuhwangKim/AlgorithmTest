package programmers_kit.repeat;

import java.util.LinkedList;
import java.util.Queue;

public class StackQueue4 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int totalTime = 0;
		int currentBridgeWeight = 0;
		// *** �ð��� bridgeweight���� ����ؼ� ���� ���ϰ� �ݺ��� 
		
		for (int i = 0; i < truck_weights.length; i++) {
			while(true) {
				if(queue.isEmpty()) {
					queue.add(truck_weights[i]);
					currentBridgeWeight+=truck_weights[i];
					totalTime++;
					break;
				} else if (queue.size()==bridge_length) {
					currentBridgeWeight-=queue.poll();
				} else {
					if(currentBridgeWeight+truck_weights[i]<=weight) {
						queue.add(truck_weights[i]);
						currentBridgeWeight+=truck_weights[i];
						totalTime++;
						break;
					} else {
						queue.add(0);
						// *** ������� ���Է� ���ϱ� ������ queue �� ������ �ϴ��� ������� 0�� ���� 
						totalTime++;
					}
				}
			}
		}
		
		
		
		
		return totalTime + bridge_length;
		// *** �������� ���� ���� ������ �� ��ŭ ���̸� ������ 
	}

}
