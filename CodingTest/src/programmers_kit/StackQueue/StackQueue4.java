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
					// 1. 다리에 차가 없는 경우
					queue.add(truck_weights[i]);
					// 트럭의 무게와 현재 인덱스가 담긴 객체를 집어넣음
					currentBridgeWeight += truck_weights[i];
					// 현재 다리 위에 있는 자동차의 무게
					totalTime++;
					// 하나 싣고 1초 지남
					break;
				} else if (queue.size() == bridge_length) {
					// 2. 다리가 꽉찬경우
					currentBridgeWeight -= queue.poll();
				} else {
					// 3. 다리에 차가 있지만 꽉차지 않은 경우
					
					// 4. 차한대가 추가했을 때 다리의 최대 무게가 넘지 않을 때 
					if(currentBridgeWeight+truck_weights[i]<=weight) {
						queue.add(truck_weights[i]);
						currentBridgeWeight+=truck_weights[i];
						totalTime++;
						break;
					}else {
						// 5. 최대 무게가 넘을 때 
						queue.add(0);
						totalTime++;
					}
				}
			}
		}
		return totalTime + bridge_length;
	}
}