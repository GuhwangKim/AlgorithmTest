package programmers_kit.repeat;

import java.util.LinkedList;
import java.util.Queue;

public class StackQueue4 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int totalTime = 0;
		int currentBridgeWeight = 0;
		// *** 시간과 bridgeweight으로 계속해서 빼고 더하고를 반복함 
		
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
						// *** 사이즈와 무게로 비교하기 때문에 queue 에 연산을 하더라도 지장없는 0을 삽입 
						totalTime++;
					}
				}
			}
		}
		
		
		
		
		return totalTime + bridge_length;
		// *** 마지막에 들어온 값이 끝까지 갈 만큼 길이를 더해줌 
	}

}
