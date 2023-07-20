package programmers_lv2;

import java.util.Arrays;

public class Solution22 {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;

		int deliveryStart = n - 1;
		int pickupStart = n - 1;
		// �Ųٷ� ������ �� ���̱� ������ �ε��� ���� ���� ���� ����

		int deliveryTotal = Arrays.stream(deliveries).sum();
		int pickupTotal = Arrays.stream(pickups).sum();

		while (true) {
			// break �� ������ ��� ��
			int deliveryCap = cap;
			int pickupCap = cap;
			int idx = -1;

			// delivery
			for (int i = deliveryStart; i >= 0; i--) {
				if (deliveries[i] > 0) {
					// ���������� �����ϰ�, ����� �� �ִٸ�
					idx = Math.max(idx, i);
					if (deliveries[i] <= deliveryCap) {
						// �ִ밪���� ���� ���
						deliveryCap -= deliveries[i];
						// ���� ����� ���ǿ��� ����
						deliveryTotal -= deliveries[i];
						// �� ����� ������ ����
						deliveries[i] = 0;
						// ��޿Ϸ�
					} else {
						// ������ �� �ִ� ������ ���� ��쿣
						deliveries[i] -= deliveryCap;
						deliveryStart = i;
						// �ٽ� �;��ϱ� ������ ���⼭���� ���� �ٽ�
						deliveryTotal -= deliveryCap;
						// �������� ��ŭ�� ����� ���� ��
						break;
					}
				}
			}

			// pickups
			for (int i = pickupStart; i >= 0; i--) {
				if (pickups[i] > 0) {
					// ���������� �����ϰ�, �Ⱦ��� �� �ִٸ�
					idx = Math.max(idx, i);
					if (pickups[i] <= pickupCap) {
						// �ִ밪���� ���� ���
						pickupCap -= pickups[i];
						// ���� ����� ���ǿ��� ����
						pickupTotal -= pickups[i];
						// �� ����� ������ ����
						pickups[i] = 0;
					} else {
						// ������ �� �ִ� ������ ���� ��쿣
						pickups[i] -= pickupCap;
						pickupStart = i;
						// �ٽ� �;��ϱ� ������
						pickupTotal -= pickupCap;
						// �������� ��ŭ�� ����� ���� ��
						break;
					}
				}
			}

			if (idx >= 0) {
				answer += (idx + 1) * 2; // �ε������� -1�� ���� ������ 1�� ���ϰ�, �Դٰ���
			}
			if (deliveryTotal == 0 && pickupTotal == 0) {
				// ��� ���� �Ϸ�
				break;
				// while ������ ����
			}

		}

		return answer;
	}

}
