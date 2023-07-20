package programmers_lv2;

import java.util.Arrays;

public class Solution22 {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;

		int deliveryStart = n - 1;
		int pickupStart = n - 1;
		// 거꾸로 루프를 돌 것이기 때문에 인덱스 가장 끝의 값을 넣음

		int deliveryTotal = Arrays.stream(deliveries).sum();
		int pickupTotal = Arrays.stream(pickups).sum();

		while (true) {
			// break 될 때까지 계속 돔
			int deliveryCap = cap;
			int pickupCap = cap;
			int idx = -1;

			// delivery
			for (int i = deliveryStart; i >= 0; i--) {
				if (deliveries[i] > 0) {
					// 끝에서부터 시작하고, 배달할 게 있다면
					idx = Math.max(idx, i);
					if (deliveries[i] <= deliveryCap) {
						// 최대값보다 작은 경우
						deliveryCap -= deliveries[i];
						// 현재 적재된 물건에서 빼줌
						deliveryTotal -= deliveries[i];
						// 총 배달한 수에서 빼줌
						deliveries[i] = 0;
						// 배달완료
					} else {
						// 적재할 수 있는 값보다 맣은 경우엔
						deliveries[i] -= deliveryCap;
						deliveryStart = i;
						// 다시 와야하기 때문에 여기서부터 시작 다시
						deliveryTotal -= deliveryCap;
						// 적재차량 만큼은 배달을 했을 것
						break;
					}
				}
			}

			// pickups
			for (int i = pickupStart; i >= 0; i--) {
				if (pickups[i] > 0) {
					// 끝에서부터 시작하고, 픽업할 게 있다면
					idx = Math.max(idx, i);
					if (pickups[i] <= pickupCap) {
						// 최대값보다 작은 경우
						pickupCap -= pickups[i];
						// 현재 적재된 물건에서 빼줌
						pickupTotal -= pickups[i];
						// 총 배달한 수에서 빼줌
						pickups[i] = 0;
					} else {
						// 적재할 수 있는 값보다 맣은 경우엔
						pickups[i] -= pickupCap;
						pickupStart = i;
						// 다시 와야하기 때문에
						pickupTotal -= pickupCap;
						// 적재차량 만큼은 배달을 했을 것
						break;
					}
				}
			}

			if (idx >= 0) {
				answer += (idx + 1) * 2; // 인덱스여서 -1을 뺐기 때문에 1을 더하고, 왔다갔다
			}
			if (deliveryTotal == 0 && pickupTotal == 0) {
				// 모든 것이 완료
				break;
				// while 문에서 나옴
			}

		}

		return answer;
	}

}
